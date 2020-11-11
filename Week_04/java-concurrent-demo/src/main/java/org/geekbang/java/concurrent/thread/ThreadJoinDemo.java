package org.geekbang.java.concurrent.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/11/11
 * @Modify
 * @since
 */
public class ThreadJoinDemo {

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
}
