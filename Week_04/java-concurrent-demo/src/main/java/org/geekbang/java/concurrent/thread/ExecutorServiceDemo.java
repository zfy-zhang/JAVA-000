package org.geekbang.java.concurrent.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/11/10
 * @Modify
 * @since
 */
public class ExecutorServiceDemo {
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
}
