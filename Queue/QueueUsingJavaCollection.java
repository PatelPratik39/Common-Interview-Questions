package Queue;

import java.util.*;

public class QueueUsingJavaCollection {



    public static void main ( String[] args ) {
//        Queue queue = new Queue();
        Queue<Integer> queue = new LinkedList <>();
        Queue<Integer> queue1 = new ArrayDeque <>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        queue1.add(4);
        queue1.add(5);
        queue1.add(6);

        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            System.out.println();
            System.out.println(queue1.peek());
            queue.remove();
            queue1.remove();
        }
    }
}
