package com.lxy.designmode.Singleton;

public class EnumSingleton {
	public static EnumSingleton getInstance() {
		return EnumHolder.MSA.getInstance();
	}

	private enum EnumHolder {
		MSA;
		private EnumSingleton instance = null;

		private EnumHolder() {
			instance = new EnumSingleton();
		}

		private EnumSingleton getInstance() {
			return instance;
		}
	}
}
