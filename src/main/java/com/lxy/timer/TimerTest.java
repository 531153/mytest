package com.lxy.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest extends TimerTask {
	private String TaskName;

	TimerTest(String TaskName) {
		this.TaskName = TaskName;
	}

	@Override
	public void run() {
		System.out.println(this.TaskName + " task run!");
	}

	public static void main(String[] args) {
		Timer time = new Timer();
		time.schedule(new TimerTest("A"), 10, 1000);
		time.schedule(new TimerTest("B"), 10, 2000);
	}
}
