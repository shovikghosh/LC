package implementstackusingqueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
class MyStack {
    Queue<Integer> l1;
    Queue<Integer> l2;
    Queue<Integer> head;
    Queue<Integer> tail;

    public MyStack() {
        l1 = new LinkedList<>();
        l2 = new LinkedList<>();
        head = l1;
        tail = l2;
    }

    public void push(int x) {
        if (head.isEmpty()) {
            head.add(x);
        } else if (tail.isEmpty()) {
            tail.add(x);
        } else {
            head.add(tail.poll());
            tail.add(x);
        }
    }

    public int pop() {
        if (tail.isEmpty()) {
            if (head.isEmpty()) {
                return -1;
            } else {
                return head.poll();
            }
        } else {
            int retVal = tail.poll();

            while (!head.isEmpty()) {
                int tmp = head.poll();
                if (head.isEmpty()) {
                    head.add(tmp);
                    break;
                } else tail.add(tmp);
            }
            Queue<Integer> t;
            t = head;
            head = tail;
            tail = t;
            return retVal;
        }
    }

    public int top() {
        if (tail.isEmpty()) {
            if (head.isEmpty()) {
                return -1;
            } else {
                return head.peek();
            }
        } else {
            return tail.peek();
        }
    }

    public boolean empty() {
        return tail.isEmpty() && head.isEmpty();
    }
}
