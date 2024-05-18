package implementstackusingqueues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void push() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        assertEquals(1, myStack.pop());
    }

    @Test
    void pop() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        assertEquals(1, myStack.pop());
    }

    @Test
    void top() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        assertEquals(1, myStack.top());
    }

    @Test
    void empty() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        assertEquals(1, myStack.pop());
        assertEquals(true, myStack.empty());
    }

    @Test
    void push_2() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        assertEquals(2, myStack.pop());
    }

    @Test
    void testMyStack() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertEquals(3, myStack.pop());
        assertEquals(2, myStack.pop());
        assertEquals(1, myStack.top());
        assertFalse(myStack.empty());
        assertEquals(1, myStack.pop());
        assertTrue(myStack.empty());
    }

    @Test
    void testMyStack_2() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        assertFalse(myStack.empty());
    }
}
