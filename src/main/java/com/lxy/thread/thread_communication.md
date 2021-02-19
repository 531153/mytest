#线程通信
###1、等待通知机制
####wait/notifyAll
```java
public class TwoThreadNotify {
	public int start = 1;
	public short flag = 1;

	public static void main(String[] args) {
		TwoThreadNotify twoThreadNotify = new TwoThreadNotify();
		Thread t1 = new Thread(new OuThread(twoThreadNotify));
		Thread t2 = new Thread(new JiThread(twoThreadNotify));
		Thread t3 = new Thread(new JiiThread(twoThreadNotify));
		t1.setName("A");
		t2.setName("B");
		t3.setName("C");
		t1.start();
		t2.start();
		t3.start();
	}
}
```