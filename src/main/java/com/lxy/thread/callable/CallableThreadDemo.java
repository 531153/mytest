package com.lxy.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThreadDemo implements Callable<Integer> {
	public static void main(String[] args) {
		CallableThreadDemo ctd = new CallableThreadDemo();
		FutureTask<Integer> ft = new FutureTask<>(ctd);
		for (int i = 0; i < 21; i++) {
			System.out.println(Thread.currentThread().getName()+" 的循环变量i的值"+i);
			if (i==20){
				new Thread(ft,"有返回值的线程FutureTask").start();
			}
		}
		try {
			System.out.println("子线程的返回值："+ft.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer call() throws Exception {
		int i=0;
		for (; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
		return i;
	}
}
