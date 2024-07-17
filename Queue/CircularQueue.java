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


        Queue(int n){
            arr = new int[n];
            this.size = n;
            this.rear = -1;
        }

//        check Queue is empty or not
        public static boolean isEmpty(){
            System.out.println("Queue is Empty");
            return rear == -1;
        }
        public static boolean isFull(){
            System.out.println("Queue is Full");
            return rear == size-1;
        }

    }

    public static void main ( String[] args ) {

        CircularQueue queue = new CircularQueue();


    }
}
