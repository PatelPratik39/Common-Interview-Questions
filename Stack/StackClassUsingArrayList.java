package Stack;

import java.util.ArrayList;

public class StackClassUsingArrayList {

    class Node{
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

//    create Stack
    static class Stack {
       static ArrayList<Integer> list = new ArrayList <>();

        public static boolean isEmpty(){
            return list.size() == 0;
        }

//        push()
        public static void push(int data){
            list.add(data);
        }
//      pop()
//    if list is empty then return -1;
//    if a list isn't emptier than find last element from an Array using size()-1
//    once found the last element then remove last element and return new top
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size()-1);
            return top;
        }
//    peek()
        public  static  int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }

    public static void main ( String[] args ) {
        Stack stack = new Stack();
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
