package com.lxy.designmode.CompositeAndVisitor;

public class UpdateFileNameVisitor implements Visitor {
	@Override
	public void visit(Element element) {
		if (element instanceof Folder) {
			element.accept(this);
		} else {
			File file = (File) element;
			file.setName("visitor update-" + file.getName());
		}
	}
}
