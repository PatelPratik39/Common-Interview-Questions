package Queue;

/*

Queue is a linear data structure that follows FIFO Principle
Key Operations: 1. Enqueue, 2. Dequeue, 3.Peek/front, 4. isEmpty = -1, 5. isFull = 0
 */

public class QueueDemo {

//    using static clas and methods, so I can use those static functions in to other classes
    static class Queue{

//        static variables so we can use it in different functions
        static int arr[];  // not clear about size
        static int size;
        static int rear = -1;  //declare rear with -1

        Queue(int n){
            arr = new int[n];
            this.size = n;
        }

        public static boolean isEmpty(){
            return rear == -1;
        }

        /*
         Time Complexity of Add() O(1)
         */
//        lets add data into queue first = enqueue = add()

        public static void add(int data){
//            the first check queue is empty or full, if queue is full then print a statement that the queue is full and return
            if(rear == size-1){
                System.out.println("Full Queue");
                return;
            }
//            but If the Queue is not full
            rear++;
            arr[rear] = data;
        }
        
        /*
        TimeComplexity of remove and Peek() = O(n)
         */
//        Dequeue - O(n) - remove() in Array using Queue
        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty Queue");
//                -1 represent here queue is empty , if not it will return 0
                return -1;
            }

            int front = arr[0];   // 0th index element stored in front variable
//            I need to iterate over loop and push all the rest elements to shift front side of an array
            for(int i = 0; i < rear; i++){
                arr[i] = arr[i+1];  // moving all the elements from [i+1] index to i index
            }
            rear--; //after shifting all elements, the rear pointer will be decremented by 1
            return front;
        }
//        peek
        public static int peek(){
            // Check if the queue is empty
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;  // Indicates that the queue is empty
            }
            return arr[0]; // it will return 0th index element because peek provides top most element data only
        }
    }


    public static void main ( String[] args ) {

//        create a Queue
        Queue q = new Queue(7);
//        Queue queue = new Queue(7);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(6);
        q.add(7);
        q.add(9);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove(); // Ensure to remove the element to avoid infinite loop
        }
    }
}
