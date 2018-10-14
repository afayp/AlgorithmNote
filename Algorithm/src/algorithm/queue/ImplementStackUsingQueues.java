package algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

/**703.
 Kth Largest Element in a Stream

 * 225.Implement Stack using Queues
 *
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 */
public class ImplementStackUsingQueues {


    class MyStack {
        Queue<Integer> queue = new LinkedList<Integer>();



        /** Push element x onto stack.
         *
         * 每次把新加入的数插到前头，这样队列保存的顺序和栈的顺序是相反的，它们的取出方式也是反的，那么反反得正，就是我们需要的顺序了。
         * */
        public void push(int x) {
            queue.add(x);
            for(int i=0;i<queue.size()-1;i++) {
                queue.add(queue.poll()); // 从head取出来放到tail
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
