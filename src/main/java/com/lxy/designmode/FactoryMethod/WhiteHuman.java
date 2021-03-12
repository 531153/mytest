package com.lxy.designmode.FactoryMethod;

public class WhiteHuman implements Human{
	@Override
	public String getColor() {
		return "white";
	}

	@Override
	public void talk() {
		System.out.println("i am white human");
	}
}
