# RxJava 的简单分享

### 0x01 入门

#### 介绍

![What Is The RxJava?](http://ww3.sinaimg.cn/large/a17a2d22gw1f4dk4mjsjoj21kw12an52.jpg) 

 

> 一个在 Java VM 上使用可观测序列来组成的异步的、基于事件的程序的库

这是 RxJava 的官方解释，扔物线前辈总结了一点特别好。

> 其实， RxJava 的本质可以压缩为异步这一个词。说到根上，它就是一个实现异步操作的库，而别的定语都是基于这之上的。

#### 为什么使用？

简洁，异步。

随着程序逻辑变得越来越复杂，它依然能够保持简洁和清晰。

**举个例子**

一组文件夹下所有的 png 图片都加载出来，并显示在 imageCollectorView 内

看看不用 RxJava 是这么写：

```java
new Thread() {
    @Override
    public void run() {
        super.run();
        for (File folder : folders) {
            File[] files = folder.listFiles();
            for (File file : files) {
                if (file.getName().endsWith(".png")) {
                    final Bitmap bitmap = getBitmapFromFile(file);
                    getActivity().runOnUiThread(new Runnable() {

@Override

public void run() {

    imageCollectorView.addImage(bitmap);

}
                    });
                }
            }
        }
    }
}.start();
```

现在我们试试 RxJava 来写这段逻辑：

```
Observable.from(folders)
.flatMap(new Func1<File, Observable<File>>() {
    @Override
    public Observable<File> call(File file) {
        return Observable.from(file.listFiles());
    }
})
.filter(new Func1<File, Boolean>() {
    @Override
    public Boolean call(File file) {
        return file.getName().endsWith(".png");
    }
})
.map(new Func1<File, Bitmap>() {
    @Override
    public Bitmap call(File file) {
        return getBitmapFromFile(file);
    }
})
.subscribeOn(Schedulers.io())
.observeOn(AndroidSchedulers.mainThread())
.subscribe(new Action1<Bitmap>() {
    @Override
    public void call(Bitmap bitmap) {
        imageCollectorView.addImage(bitmap);
    }
});
```

如果使用 lambda 你看到的是这样的：

```java
Observable.from(folders)
    .flatMap((Func1) (folder) -> { Observable.from(file.listFiles()) })
    .filter((Func1) (file) -> { file.getName().endsWith(".png") })
    .map((Func1) (file) -> { getBitmapFromFile(file) })
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe((Action1) (bitmap) -> { imageCollectorView.addImage(bitmap) });
```

#### 基本概念

![观察者，被观察者](http://ww2.sinaimg.cn/large/a17a2d22gw1f4dnhakt0qj21kw0zk0yn.jpg)

![img](http://ww4.sinaimg.cn/large/a17a2d22gw1f4dnnnfubsj21kw0zk0xz.jpg)

Observable 对于我的理解是一个“车间头”，随后所有连接的操作符都是“加工方式”，最后再给“订阅者（Subscriber）”

添加订阅关系的方法是 subscribe()

```java
public final Subscription subscribe(final Observer<? super T> observer) {
    if (observer instanceof Subscriber) {
        return subscribe((Subscriber<? super T>)observer);
    }
    return subscribe(new ObserverSubscriber<T>(observer));
}
```

可以看到无论我们传入 subscribe() 里的参数是 Subscriber 还是 Observe ，最终都会转化成 Subscriber 。

| ![img](http://ww3.sinaimg.cn/large/a17a2d22gw1f4do6au7f5j20j60k2n1k.jpg) | ![img](http://ww4.sinaimg.cn/large/a17a2d22gw1f4do6soeodj20j20m43zs.jpg) |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
|                                                              |                                                              |

可以知道 Subscriber 比起 Observe 更能让我们做好状态的控制。

**那么 Subscriber 是多久取消订阅的呢？**

我们深入源码看看：

前面我看到添加了订阅关系后 observer 会被转化成 Subscriber 随后我们继续深入我们发现最终会到：

```java
private static <T> Subscription subscribe(Subscriber<? super T> subscriber, Observable<T> observable) {
	// 省略无关代码
	 subscriber.onStart();
	 if (!(subscriber instanceof SafeSubscriber)) {
		 subscriber = new SafeSubscriber<T>(subscriber);
	 }
	// 忽略
 }
```

我们发现了 SafeSubscriber ，深入发现该类中方法：

```java
public void onCompleted() {
        if (!done) {
            done = true;
            try {
                actual.onCompleted();
            } catch (Throwable e) {
            } finally {
                unsubscribe();
            }
        }
    }
```

得知 **最终它在 finally 里自动取消订阅了**。

#### 实操练习

输出一个 `Hello World`

![img](http://ww4.sinaimg.cn/large/a17a2d22gw1f4doth2f1fj21kw0zkjvq.jpg)

新的需求，`Hello World - xxx` 加上签名

![img](http://ww2.sinaimg.cn/large/a17a2d22gw1f4dovmxj27j21kw0zkgpu.jpg)

**Observable** 和 **Subscriber** 是独立于中间的变换过程的。

所以上述最好是使用 `map` 来实现转换。

![img](http://ww3.sinaimg.cn/large/a17a2d22gw1f4doxzdamyj21kw0zkn23.jpg)

