# 异步请求相关
## 概念
    接收到调用，主线程新开一个线程来做，主线程自己则去干其他的事情，等后台线程处理
    完之后，主线程再返回结果。
## 特点
    1. 业务线程，处理请求逻辑
    2. 请求处理线程立即释放，通过回调处理线程返回结果
## 实现方式
### AsyncContext
    获取AsyncContext，添加监听器asyncContext.addListener(AsyncListener)
### Callable
    直接返回一个Callable即可
### WebAsyncTask
    callable 的方式，非常直观简单，但是我们经常关注的超时+异常的处理却不太好，这个时候我们可以用WebAsyncTask
### DeferredResult
    DeferredResult与WebAsyncTask最大的区别就是前者不确定什么时候会返回结果，sse实现