package com.lxy.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableDemo implements Serializable {
	private String name = "name";
	private Integer age = 22;
	private static final int SINT = 10;
	private static final long serialVersionUID = 1L;

	SerializableDemo(String name, Integer age) {
		this.name = name;
		this.age  = age;
	}

	public static void main(String[] args) {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("E:\\object.out"));
			objectOutputStream.writeObject(new SerializableDemo("我要序列化", 32));
			ObjectInputStream inputStream      = new ObjectInputStream(new FileInputStream("E:\\object.out"));
			SerializableDemo  serializableDemo = (SerializableDemo) inputStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
