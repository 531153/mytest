package com.lxy.statictest;

public class OutClass {
	private int out = 12;

	public static void main(String[] args) {
		OutClass            outClass   = new OutClass();
		OutClass.InnerClass innerClass = outClass.new InnerClass();
		OutClass.StaticInnerClass staticInnerClass = new OutClass.StaticInnerClass();
		staticInnerClass.staticInnerShow();
		innerClass.innerShow();
	}

	public void outShow() {
		System.out.println("outshow");
	}

	public class InnerClass {
		public void innerShow() {
			outShow();
			System.out.println("innershow");
		}
	}

	static class StaticInnerClass{
		public void staticInnerShow() {
			System.out.println("staticInnerShow");
		}
	}
}
