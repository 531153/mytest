package com.lxy.thread.wait;

public class JiiThread implements Runnable {
	private TwoThreadNotify number;

	public JiiThread(TwoThreadNotify number) {
		this.number = number;
	}

	@Override
	public void run() {
		while (number.start < 100) {
			synchronized (TwoThreadNotify.class) {
				if (number.flag == 3) {
					System.out.println(Thread.currentThread().getName() + number.start);
					number.start++;
					number.flag = 1;
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
