package com.lxy.statictest;

public class People {
	//成功
	public static String SUCCESS = "SUCCESS";
	//信息
	public static String INFO = "INFO";
	//警告
	public static String WARNING = "WARNING";
	//错误
	public static String ERROR = "ERROR";
	static{
		System.out.println("静态代码块，程序启动后执行，只执行一次");
	}
	public People(){
		System.out.println("默认构造器");
	}
	public People(String str){
		System.out.println("带参构造器，参数+"+str);
	}
	{
		System.out.println("构造代码块，每次调用构造方法都会执行一次！");
	}
	public void show(){
		int s = 1;
		{
			int m = 2;
			System.out.println(s);
		}
		System.out.println(s);
	}

	public static void main(String[] args) {
		People people  = new People();
		People people1 = new People("张三");
	}
}
