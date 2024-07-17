package Stack;

//Reverse the

import java.util.Stack;

public class ReverseStack {
/*
below method I have created to push the data from the bottom inside stack
    1. in this method i am passing stack data and stack as recursive
    2. check if the stack is empty or not. if its empty then push the data and return from there
    3. first remove the data from top using pop method.
    4. using pushAtBottmo method add the data into bottom of the stack using recursive call
    5. and the push back removed top data into stack

 */
    public static void pushAtBottom(int data, Stack<Integer> stack){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushAtBottom(data, stack);
        stack.push(top);
    }

//    below method will remove stack elements
    /*
    1.  first check whether stack is empty or not.
    2.  remove all the elements from the top of stack
    3.  reverse the stack.
    4.  recursive call - push back all removed data from top
     */

    public static  void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }

        int top = stack.pop();
        reverse(stack);
        pushAtBottom(top, stack);
    }

    public static void main ( String[] args ) {
        Stack <Integer> stack = new Stack <>();
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(9);

        reverse(stack);

        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
