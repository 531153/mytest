package com.lxy.designmode.CompositeAndVisitor;

public interface Element {
	void accept(Visitor visitor);
}
