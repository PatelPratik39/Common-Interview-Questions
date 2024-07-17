package Queue;

public class LinkedListQueue {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    static class Queue{
        static Node head = null;
        static Node tail = null;


        //        check Queue is empty or not
        public static boolean isEmpty(){
//            System.out.println("Queue is Empty");
            return head == null && tail == null;
        }


        //        enqueue (add) O(1)
        public void add ( int data ) {

            Node newNode = new Node(data);
            if(tail == null){
                tail = head = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;

        }

        //        dequeue (remove()) O(1)
        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty queue");
                return -1;
            }
            int front = head.data;
            if(head == tail){
                tail = null;
            }
            head = head.next;

            return front;

        }

        //        Peek()
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            return head.data;
        }

    }
    public static void main ( String[] args ) {
      Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);


        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.remove();
        }
    }
}
