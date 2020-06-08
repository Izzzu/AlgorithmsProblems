package stacks;

import java.util.EmptyStackException;

class MyStack {

    class Node {
        int val;
        Node next;
        Node(int v) {
            this.val = v;
        }
    }
    Node top;
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if (top==null) {
            top = new Node(x);
        }
        Node n = new Node(x);
        n.next = top;
        top = n;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (top == null) throw new EmptyStackException();
        int t = top.val;
        top = top.next;
        return t;
    }
    
    /** Get the top element. */
    public int top() {
        if (top == null) throw new EmptyStackException();
        return top.val;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return top == null;
    }
}