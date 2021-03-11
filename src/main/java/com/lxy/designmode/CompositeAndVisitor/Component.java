package com.lxy.designmode.CompositeAndVisitor;

public abstract class Component implements Element {
	protected String name;

	public Component(String name) {
		this.name = name;
	}

	public abstract void show(String prefix);

	public void add(Component component) {
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
