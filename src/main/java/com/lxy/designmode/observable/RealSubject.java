package com.lxy.designmode.observable;

import java.util.Observable;
import java.util.Observer;

public class RealSubject extends Observable {
	public void makeChanged(){
		setChanged();
		notifyObservers();
	}

	public static void main(String[] args) {
		RealSubject subject = new RealSubject();
		RealObserver observer = new RealObserver();
		RealObserver1 observer1 = new RealObserver1();
		subject.addObserver(observer);
		subject.addObserver(observer1);
		subject.makeChanged();
	}
}
class RealObserver implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("调用了");
	}
}
class RealObserver1 implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("调用了1");
	}
}
