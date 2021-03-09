package com.lxy.thread.vol;

public class VolatileDemo {
	public volatile int inc = 0;

	public synchronized void increase() {
		inc++;
	}

	public static void main(String[] args) throws InterruptedException {
		final VolatileDemo volatileDemo = new VolatileDemo();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 1000; j++) {
						volatileDemo.increase();
					}
				}
			}).start();
		}
		System.out.println(volatileDemo.inc);
	}
}
