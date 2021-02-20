package com.lxy.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProCon {


	public static void main(String[] args) {
		final Bounded bounded = new Bounded();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("t1 run");
				for (int i = 1; i <= 180; i++) {
					try {
						System.out.println("putting..");
						bounded.put(Integer.valueOf(i));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("t2 run");
				for (int i = 1; i <= 180; i++) {
					try {
						Object val = bounded.take();
						System.out.println(val);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t1.start();
		t2.start();
	}

	static class Bounded {
		private final ReentrantLock lock = new ReentrantLock();
		/**
		 * 可写锁
		 */
		private final Condition notFull = lock.newCondition();
		/**
		 * 可读锁
		 */
		private final Condition notEmpty = lock.newCondition();
		/**
		 * 固定100的容器
		 */
		Object[] items = new Object[100];
		int count, putc, takec;

		public void put(Object i) throws InterruptedException {
			lock.lock();
			try {
				while (count == items.length) {
					System.out.println("full ，wait ");
					notFull.await();
				}
				items[putc] = i;
				++count;
				if (++putc == items.length) {
					putc = 0;
				}
				notEmpty.signal();
			} finally {
				lock.unlock();
			}

		}

		public Object take() throws InterruptedException {
			lock.lock();
			try {
				while (0 == count) {
					notEmpty.await();
				}
				Object x = items[takec];
				if (++takec == items.length) {
					takec = 0;
				}
				--count;
				notFull.signal();
				return x;
			} finally {
				lock.unlock();
			}
		}
	}
}
