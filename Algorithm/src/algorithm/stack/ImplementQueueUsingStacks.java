package algorithm.stack;

import java.util.Stack;

/**
 * 232.Implement Queue using Stacks
 *
 使用栈实现队列的下列操作：

 push(x) -- 将一个元素放入队列的尾部。
 pop() -- 从队列首部移除元素。
 peek() -- 返回队列首部的元素。
 empty() -- 返回队列是否为空。
 */
public class ImplementQueueUsingStacks {


    class MyQueue {
        Stack<Integer> pushStack = new Stack<>();
        Stack<Integer> popStack = new Stack<>();


        /** Push element x to the back of queue. */
        public void push(int x) {
            pushStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return pushStack.isEmpty() && popStack.isEmpty();
        }

    }


}
