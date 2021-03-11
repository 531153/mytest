package com.lxy.designmode.CompositeAndVisitor;

public class ComponentTest {
	public static void main(String[] args) {
		Folder folder  = new Folder("根文件夹");
		Folder folder1 = new Folder("文件夹1");
		folder.add(folder1);
		File file1 = new File("文件1");
		folder1.add(file1);
		File file2 = new File("文件2");
		folder1.add(file2);
		Folder folder2 = new Folder("文件夹2");
		folder.add(folder2);
		File file3 = new File("文件3");
		folder2.add(file3);
		File file4 = new File("文件4");
		folder2.add(file4);
		File file5 = new File("文件5");
		folder2.add(file5);
		File file6 = new File("文件6");
		folder.add(file6);

		folder.show("==");
		System.out.println("----------------");
		folder1.show("");

		Visitor visitor = new UpdateFileNameVisitor();
		folder.accept(visitor);
		folder.show("");
	}
}
