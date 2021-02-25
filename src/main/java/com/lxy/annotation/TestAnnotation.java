package com.lxy.annotation;

public class TestAnnotation {
	public static void main(String[] args) {
		Class<Father> clazz = Father.class;
		boolean present = clazz.isAnnotationPresent(AnnotationDemo.class);
		if(present){
			AnnotationDemo annotationDemo = clazz.getAnnotation(AnnotationDemo.class);
			System.out.println(annotationDemo.name());
			System.out.println(annotationDemo.age());
		}
	}
}
