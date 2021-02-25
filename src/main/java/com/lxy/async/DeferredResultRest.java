package com.lxy.async;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping(path = "defer")
public class DeferredResultRest {

	private Map<String, DeferredResult> cache = new ConcurrentHashMap<>();

	@GetMapping(path = "get")
	public DeferredResult<String> get(String id) {
		DeferredResult<String> res = new DeferredResult<>();
		cache.put(id, res);

		res.onCompletion(new Runnable() {
			@Override
			public void run() {
				System.out.println("over!");
			}
		});
		return res;
	}

	@GetMapping(path = "pub")
	public String publish(String id, String content) {
		DeferredResult<String> res = cache.get(id);
		if (res == null) {
			return "no consumer!";
		}

		res.setResult(content);
		return "over!";
	}
}