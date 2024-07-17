package Stack;
/*
Push the element from the bottom of the stack
- it can be possible using recursion
 */


import java.util.Stack;

public class StackDemo {
//    to add an element from the bottom of the stack
    public static void pushAtBottom(int data, Stack<Integer> stack){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int top = stack.pop();  //remove top elemnts
        pushAtBottom(data, stack);   //recursion call
        stack.push(top);
    }

    public static void main ( String[] args ) {
        Stack<Integer> stack = new Stack <>();
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(9);

        pushAtBottom(39, stack);

        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
