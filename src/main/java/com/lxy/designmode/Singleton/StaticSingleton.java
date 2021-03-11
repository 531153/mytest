package com.lxy.designmode.Singleton;

public class StaticSingleton {
	private static class StaticSingletonHolder {
		private static StaticSingleton instance = new StaticSingleton();
	}

	public static StaticSingleton getInstance() {
		return StaticSingletonHolder.instance;
	}
}
