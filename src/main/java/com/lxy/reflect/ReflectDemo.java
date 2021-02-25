package com.lxy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {
	private String name = "name";
	public Integer age = 22;
	private static final int SINT = 10;

	public ReflectDemo() {
	}

	public ReflectDemo(String name, Integer age) {
		this.name = name;
		this.age  = age;
	}

	public void show(){
		System.out.println("show");
	}
	private void see(){
		System.out.println("see");
	}

	public static void main(String[] args) {
		Class clazz = null;
		try {
			clazz = Class.forName("com.lxy.reflect.ReflectDemo");
			Field[] fields = clazz.getDeclaredFields();
			Method[] methods = clazz.getMethods();
			for (Field field:fields){
				System.out.println(field.toString());
			}
//			Constructor[] constructor=clazz.getDeclaredConstructors();
//			for(Constructor c:constructor){
//				System.out.println(c.toString());
//			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
