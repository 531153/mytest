package com.lxy.designmode.FactoryMethod;

public class BlackHuman implements Human{
	@Override
	public String getColor() {
		return "black";
	}

	@Override
	public void talk() {
		System.out.println("i am black human");
	}
}
