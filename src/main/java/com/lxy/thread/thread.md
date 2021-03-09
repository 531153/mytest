#创建线程的4种方式
1. 继承Thread类 
2. 实现Runnable接口
3. Callable和Future创建线程
4. 使用Executor线程池创建
````
1. Callable类似于Runnable，但是它有返回值，Runnable没有。
2. new Thread(futureTask)的方式来创建FuntureTask任务，FuntureTask是一个实现了Runnable和Future接口的类
3. call方法可以抛出异常，run方法不可以
4. 运行Callable任务可以拿到一个Future对象，表示异步计算的结果。它提供了检查计算是否完成的方法，以等待计算
   的完成，并检索计算的结果。通过Future对象可以了解任务执行情况，可取消任务的执行，还可获取执行结果
````
# 线程池
### Java通过Executors提供四种线程池，分别为:
1. newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
2. newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
3. newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
4. newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
[ThreadPoolExecutor的参数解释](https://blog.csdn.net/u011517841/article/details/79810689)
[Java线程池详解](https://www.jianshu.com/p/7726c70cdc40)
![线程池执行流程](https://upload-images.jianshu.io/upload_images/6024478-88ee7b20f8f45825.png)
# 线程通信
### 1、等待通知机制
#### wait/notifyAll
##### **注意**
1、wait() 、notify()、notifyAll() 调用的前提都是获得了对象的锁(也可称为对象监视器)。
2、调用 wait() 方法后线程会释放锁，进入 WAITING 状态，该线程也会被移动到等待队列中。
#### join
等待线程执行结束之后执行，实际实现是wait，在 join 线程完成后会调用 notifyAll() 方法，是在 JVM 实现中调用，所以这里看不出来。
#### volatile 共享内存
[volatile关键字的用法](https://www.cnblogs.com/ustc-anmin/p/11434769.html)
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
# 线程状态
[java线程6种状态](https://blog.csdn.net/qq_22771739/article/details/82529874)