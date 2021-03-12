package com.lxy.designmode.FactoryMethod;

public class YellowHuman implements Human{
	@Override
	public String getColor() {
		return "yellow";
	}

	@Override
	public void talk() {
		System.out.println("i am yellow human");
	}
}
