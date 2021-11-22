package leetcode.editor.cn.thread;

/**
 * @description：
 * @author：JBL
 * @date：2021/10/8 6:47 下午
 */
public class PrintNumber2 extends Thread{
    private static int cnt = 0;
    private int id;  // 线程编号
    public PrintNumber2(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (cnt <= 100) {
            while (cnt%2 == id) {
                synchronized (PrintNumber2.class) {
                    cnt++;
                    System.out.println("thread_" + id + " num:" + cnt);
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread0 = new PrintNumber2(0);
        Thread thread1 = new PrintNumber2(1);
        thread0.start();
        thread1.start();
    }
}
