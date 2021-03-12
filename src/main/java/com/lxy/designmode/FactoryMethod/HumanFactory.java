package com.lxy.designmode.FactoryMethod;

public class HumanFactory extends AbstractHumanFactory{
	@Override
	public <T extends Human> T createHuman(Class<T> c) {
		Human human = null;
		try {
			human = (Human) Class.forName(c.getName()).newInstance();
		}catch (Exception e){
			System.out.println("human product error");
		}
		return (T) human;
	}

	public static void main(String[] args) {
		AbstractHumanFactory LuZi = new HumanFactory();
		System.out.println("white start");
		Human whiteHuman = LuZi.createHuman(WhiteHuman.class);
		System.out.println(whiteHuman.getColor());
		whiteHuman.talk();
		Human blackHuman = LuZi.createHuman(BlackHuman.class);
		System.out.println(blackHuman.getColor());
		blackHuman.talk();
	}
}
