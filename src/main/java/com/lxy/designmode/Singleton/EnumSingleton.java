package com.lxy.designmode.Singleton;

public class EnumSingleton {
	public static EnumSingleton getInstance() {
		return EnumHolder.INSTANCE.getInstance();
	}

	private enum EnumHolder {
		INSTANCE;
		private EnumSingleton instance = null;

		private EnumHolder() {
			instance = new EnumSingleton();
		}

		private EnumSingleton getInstance() {
			return instance;
		}
	}
}
