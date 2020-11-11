package org.geekbang.java.concurrent.thread;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/11/11
 * @Modify
 * @since
 */
public class ThreadYieldAndActiveCountDemo {
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
}
