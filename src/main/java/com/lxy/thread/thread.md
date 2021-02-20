# 线程通信
### 1、等待通知机制
#### wait/notifyAll
##### **注意**
1、wait() 、notify()、notifyAll() 调用的前提都是获得了对象的锁(也可称为对象监视器)。
2、调用 wait() 方法后线程会释放锁，进入 WAITING 状态，该线程也会被移动到等待队列中。
#### join
等待线程执行结束之后执行，实际实现是wait，在 join 线程完成后会调用 notifyAll() 方法，是在 JVM 实现中调用，所以这里看不出来。
#### volatile 共享内存
#### CountDownLatch和CyclicBarrier 并发工具
CyclicBarrier可以重复使用已经通过的障碍，而CountdownLatch不能重复使用
#### 线程响应中断 interrupt
#### 线程池 awaitTermination() 方法
#### 管道通信
# 多线程面试题
#### [顶级多线程面试题](https://www.cnblogs.com/huajiezh/p/5790942.html)
1. 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
    - lock
    - join
    - wait
2. 在Java中Lock接口比synchronized块的优势是什么？<br>
lock接口在多线程和并发编程中最大的优势是它们为读和写分别提供了锁,可以有条件的阻塞
3. 在java中wait和sleep方法的不同？<br/>
    最大的不同是在等待时wait会释放锁，而sleep一直持有锁。Wait通常被用于线程间交互，sleep通常被用于暂停执行。
    
```java

```