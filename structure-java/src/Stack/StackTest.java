package Stack;


import util.Logger;

import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        MyStack stack = new MyStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Logger.println(stack.peek()+"");


        while (!stack.isEmpty()) {
            Logger.println(stack.pop()+"");
        }

    }
}
