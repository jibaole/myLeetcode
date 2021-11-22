package leetcode.editor.cn.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description：
 * @author：JBL
 * @date：2021/10/8 6:44 下午
 */
public class PrintNumber1 extends Thread{
    private static AtomicInteger cnt = new AtomicInteger();
    private int id;
    public PrintNumber1(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (cnt.get() <= 100) {
            while (cnt.get()%2 == id) {
                System.out.println("thread_" + id + " num:" + cnt.get());
                cnt.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread0 = new PrintNumber1(0);
        Thread thread1 = new PrintNumber1(1);
        thread0.start();
        thread1.start();
    }
}
