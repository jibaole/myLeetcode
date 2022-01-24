package leetcode.editor.cn.dataType;

import java.util.Stack;

/**
 * @description：
 * @author：JBL
 * @date：2021/12/15 6:42 下午
 */
public class MyQueue {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        in2out();
        return out.pop();
    }

    public int peek() {
        in2out();
        return out.peek();
    }

    private void in2out() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue =new MyQueue();
        for (int i = 0; i < 10; i++) {
            queue.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.pop());
        }

    }
}
