package Stack;

public class StackClass {


    static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    static class Stack {
//        create head in stack
        public static Node head;

//        let's check the first stack is empty or not
        public static boolean isEmpty(){
            return head == null;
        }

//        Push Function in Stack

        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

//        Pop function in Stack

        public static int pop(){

            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

//        peek function in Stack

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(3);
        s.push(4);
        s.push(5);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
