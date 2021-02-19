package com.lxy.thread.wait;

public class OuThread implements Runnable {
	private TwoThreadNotify number;

	public OuThread(TwoThreadNotify number) {
		this.number = number;
	}

	@Override
	public void run() {
		while (number.start < 100) {
			synchronized (TwoThreadNotify.class) {
				if (number.flag == 1) {
					System.out.println(Thread.currentThread().getName() + number.start);
					number.start++;
					number.flag = 2;
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
