package org.geekbang.java.concurrent.thread;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/11/10
 * @Modify
 * @since
 */
public class ThreadSleepDemo {
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
}
