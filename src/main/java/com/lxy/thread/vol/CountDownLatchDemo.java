package com.lxy.thread.vol;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
	private static final int PLAYER_AMOUNT = 5;

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch end     = new CountDownLatch(PLAYER_AMOUNT);
		Player[]       players = new Player[PLAYER_AMOUNT];
		CountDownLatch begin   = new CountDownLatch(1);
		for (int i = 0; i < PLAYER_AMOUNT; i++) {
			players[i] = new Player(i + 1, begin, end);
		}
		ExecutorService exe = Executors.newFixedThreadPool(PLAYER_AMOUNT);
		for (Player p : players) {
			exe.execute(p);
			System.out.println("rach begins!");
			p.getBegin().countDown();
			Thread.sleep(1000);
		}
		try {
			end.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("rach ends!");
		}
		exe.shutdown();
	}
}


