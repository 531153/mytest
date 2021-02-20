package com.lxy.statictest;

public class StaticDemo {
	private  static int show = 1;

	public static void main(String[] args) {
		myShow(12);
		myShow(11);
	}

	public static void myShow(final int x) {
		show++;
		System.out.println(show);
		System.out.println(x);
	}
}
