package com.lxy.designmode.CompositeAndVisitor;

public class File extends Component {

	public File(String name) {
		super(name);
	}

	@Override
	public void show(String prefix) {
		System.out.println(prefix + "/" + this.name);
	}
	@Override
	public void accept(Visitor visitor){
		visitor.visit(this);
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
}
