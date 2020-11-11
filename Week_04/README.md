学习笔记

#### 2.（必做) 思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程？

###### 1、ThreadJoin
```java
public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        for(int i=0; i<10; i++){
            Thread t = new Thread("sub-thread" + i){
                @Override
                public void run() {
                    try{
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName() + "finished");
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            list.add(t);
            t.start();
        }
        for(Thread item : list){
            item.join();
        }
        System.out.println("main thread finished");
    }
```

###### 2、ThreadSleep
```java
    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i<10; i++){
            new Thread("sub-thread" + i){
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "finished");
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }.start();
        }
        Thread.sleep(2000);
        System.out.println("main thread finished");
    }
```
###### 3、ThreadYieldAndActiveCount
```java
public static void main(String[] args) {
        // 关键参数
        int defaultThreadNum = 2;
        for(int i=0; i<10 ;i++){
            new Thread("sub-thread" + i){
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "finished");
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }.start();
        }

        while(Thread.activeCount() > defaultThreadNum){
            // 当活跃线程数大于设定的默认线程数的时候 主线程让步
            Thread.yield();
        }
        System.out.println("main thread finished");
    }
```

###### 4、ExecutorService

```java
    public static void main(String[] args) {

        // 有缺陷，主线程先于子线程运行完毕
        errorMethod();
        // 正确执行方法
        correctMethod();
    }

    private static void correctMethod() {
        // 创建ExecutorService
        ExecutorService ex =  Executors.newCachedThreadPool();
        for(int i=0; i<10; i++){
            // 添加 task
            ex.submit(new Thread("sub-thread" + i){

                @Override
                public void run() {
                    try{
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "finished");
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
        }

        // 使用shutdown 会通知ExecutorService 停止添加其它task 它会等待所有子线程运行结束才退出Java进程
        ex.shutdown();
        try {
            // 设置等待时间等待子线程运行完毕
            if(!ex.awaitTermination(2000, TimeUnit.MILLISECONDS)){
                // 等待时间内子线程并未全部运行完毕就直接关闭
                ex.shutdownNow();
            }
        }catch(InterruptedException e){
            ex.shutdownNow();
        }

        System.out.println("main thread finished");
    }

    private static void errorMethod() {
        // 创建ExecutorService
        ExecutorService ex =  Executors.newCachedThreadPool();
        for(int i=0; i<10; i++){
            // 添加 task
            ex.submit(new Thread("sub-thread" + i){

                @Override
                public void run() {
                    try{
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "finished");
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
        }

        // 使用shutdown 会通知executorService 停止添加其它task 它会等待所有子线程运行结束才退出Java进程
        ex.shutdown();
        System.out.println("main thread finished");
    }
```


#### 4.（必做）把多线程和并发相关知识带你梳理一遍，画一个脑图，截图上传到 Github 上。可选工具：xmind，百度脑图，wps，MindManage 或其他。

###### 见resource下文件