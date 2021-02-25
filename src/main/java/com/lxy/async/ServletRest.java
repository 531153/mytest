package com.lxy.async;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.concurrent.Callable;

@RestController
@RequestMapping(path = "servlet")
public class ServletRest {

	@GetMapping(path = "get")
	public void get(HttpServletRequest request) {
		AsyncContext asyncContext = request.startAsync();
		asyncContext.addListener(new AsyncListener() {
			@Override
			public void onComplete(AsyncEvent asyncEvent) throws IOException {
				System.out.println("操作完成:" + Thread.currentThread().getName());
			}

			@Override
			public void onTimeout(AsyncEvent asyncEvent) throws IOException {
				System.out.println("超时返回!!!");
				asyncContext.getResponse().setCharacterEncoding("utf-8");
				asyncContext.getResponse().setContentType("text/html;charset=UTF-8");
				asyncContext.getResponse().getWriter().println("超时了！！！!");
			}

			@Override
			public void onError(AsyncEvent asyncEvent) throws IOException {
				System.out.println("出现了m某些异常");
				asyncEvent.getThrowable().printStackTrace();

				asyncContext.getResponse().setCharacterEncoding("utf-8");
				asyncContext.getResponse().setContentType("text/html;charset=UTF-8");
				asyncContext.getResponse().getWriter().println("出现了某些异常哦！！！!");
			}

			@Override
			public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
				System.out.println("开始执行");
			}
		});

		asyncContext.setTimeout(3000L);
		asyncContext.start(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println("内部线程：" + Thread.currentThread().getName());
					asyncContext.getResponse().setCharacterEncoding("utf-8");
					asyncContext.getResponse().setContentType("text/html;charset=UTF-8");
					asyncContext.getResponse().getWriter().println("异步返回!");
					asyncContext.getResponse().getWriter().flush();
					// 异步完成，释放
					asyncContext.complete();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		System.out.println("主线程over!!! " + Thread.currentThread().getName());
	}

	@GetMapping(path = "getCallable")
	public Callable<String> getCallable() {
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("do some thing");
				Thread.sleep(1000);
				System.out.println("执行完毕，返回!!!");
				return "over!";
			}
		};
		return callable;
	}

	@GetMapping("getWebAsync")
	public WebAsyncTask<String> getWebAsync(long sleep, boolean error) {
		Callable<String> callable = () -> {
			System.out.println("do some thing");
			Thread.sleep(sleep);

			if (error) {
				System.out.println("出现异常，返回!!!");
				throw new RuntimeException("异常了!!!");
			}

			return "hello world";
		};
		// 指定3s的超时
		WebAsyncTask<String> webTask = new WebAsyncTask<>(3000, callable);
		webTask.onCompletion(() -> System.out.println("over!!!"));

		webTask.onTimeout(() -> {
			System.out.println("超时了");
			return "超时返回!!!";
		});

		webTask.onError(() -> {
			System.out.println("出现异常了!!!");
			return "异常返回";
		});

		return webTask;
	}

}
