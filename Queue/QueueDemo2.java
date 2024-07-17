package Queue;

public class QueueDemo2 {

    private int front, rear, size;
    private int[] array;

    public QueueDemo2(int size){
        this.size = size;
        array = new int[size];
        front = rear = -1;
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public boolean isFull(){
        return rear == size - 1;
    }

    public void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is Full");
            return;
        }
        if(front == -1){
            front = 0;
        }
        array[++rear] = data;
    }
    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        int data = array[front];
        if(front == rear){
            front = rear = -1;
        } else{
            for (int i = front; i < rear; i++){
                array[i] = array[i+1];
            }
            rear--;
        }
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return array[front];
    }

    public static void main ( String[] args ) {
        QueueDemo2 queue = new QueueDemo2(6);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.dequeue();
        }
    }
}
