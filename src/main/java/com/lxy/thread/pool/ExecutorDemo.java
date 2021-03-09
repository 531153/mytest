package com.lxy.thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {
	public static void main(String[] args) {
		ExecutorService mypool = new ThreadPoolExecutor(3, 4,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
	}
}
