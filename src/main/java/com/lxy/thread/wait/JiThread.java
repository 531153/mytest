package com.lxy.thread.wait;

public class JiThread implements Runnable {
	private TwoThreadNotify number;

	public JiThread(TwoThreadNotify number) {
		this.number = number;
	}

	@Override
	public void run() {
		while (number.start < 100) {
			synchronized (TwoThreadNotify.class) {
				if (number.flag == 2) {
					System.out.println(Thread.currentThread().getName() + number.start);
					number.start++;
					number.flag = 3;
					TwoThreadNotify.class.notifyAll();
				} else {
					try {
						TwoThreadNotify.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
