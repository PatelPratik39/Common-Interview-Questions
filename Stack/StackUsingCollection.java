package Stack;

import java.util.Stack;

public class StackUsingCollection {
    public static void main ( String[] args ) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(9);

        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
