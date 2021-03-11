package com.lxy.designmode.CompositeAndVisitor;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Component {
	private List<Component> componentList = new ArrayList<>();

	public Folder(String name) {
		super(name);
	}

	@Override
	public void show(String prefix) {
		prefix += "/" + name;
		String finalPrefix = prefix;
		System.out.println(finalPrefix);
		componentList.forEach(component -> component.show(finalPrefix));
	}

	@Override
	public void add(Component component) {
		componentList.add(component);
	}

	@Override
	public void accept(Visitor visitor) {
		componentList.stream().forEach(component -> visitor.visit(component));
	}
}
