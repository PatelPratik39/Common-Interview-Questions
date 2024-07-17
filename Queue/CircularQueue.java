package Queue;
/*
    Circular Queue is a Linear data structure.
    both the ends of an array are connected so it contains two pointers like front and rear
    Circular Queue is a more efficient form of queue data structure.
    CircularQueue has special conditions to handle when queue isfull (rear + 1 == front) and isEmpty( front == -1)
    - Space Efficient - Avoid the wastage of the space that can occur in standard queue.



 */
public class CircularQueue {

    static class Queue{
        static int arr[];
        static int size;
        static int rear = -1;
        static int front = -1;


        Queue(int n){
            arr = new int[n];
            this.size = n;
//            this.rear = -1;

        }

//        check Queue is empty or not
        public static boolean isEmpty(){
//            System.out.println("Queue is Empty");
            return rear == -1 && front == -1;
        }
//        if queue is full
        public static boolean isFull(){
//            System.out.println("Queue is Full");
            return ( rear + 1) % size == front;
        }

//        enqueue (add) O(1)
        public static void add(int data) {
//            check queue is full or not
            if(isFull()){
//                print  que is full
                System.out.println("Queue is full");
//                and return if queue is full
                return;
            }
            // 1st element adds
//            check if the front is empty or not by checking front == -1. -1 consider as empty and 0 consider not empty
            if (front == -1) {
//                if the front is empty, it sets front to 0 from -1.
//                that indicates that the first element will be added at front of the queue
                front = 0;
            }
//            updating the rear index to the next position in circular queue
            rear = (rear + 1) % size;
//            adds new elements data in yo the position that is indicated by arr[rear]
            arr[rear]= data;
        }

    //        dequeue (remove()) O(1)
    public static int remove(){
        if(isEmpty()){
            System.out.println("Empty queue");
            return -1;
        }
        int result = arr[front];
        if(rear == front){
            rear = front = -1;
        } else{
            front = (front + 1) % size;
        }
        return result;
    }

//        Peek()
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            return arr[front];
        }

    }

    public static void main ( String[] args ) {
        Queue queue = new Queue(6);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        System.out.println(queue.remove()); // Should remove 1
        queue.add(7); // Add 7 at the position where 1 was
        System.out.println(queue.remove()); // Should remove 2

        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.remove();
        }
    }
}
