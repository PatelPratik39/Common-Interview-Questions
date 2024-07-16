package linkedList;

public class LinkedList3 {
    Node head;
    class Node {
        int value;
        Node next;
        Node(int value){
            this.value = value;
            this.next = null;
        }
    }
        public void printList(){
            Node newNode = head;
            while(newNode != null){
                System.out.print(newNode.value + " -> ");
                newNode = newNode.next;
            }
            System.out.println();
        }
//        add nodes inti linked list
        public void addNode(int value){
            if(head == null){
                head = new Node(value);
                return;
            }
            Node newNode = head;
            while (newNode.next != null){
                newNode = newNode.next;
            }
            newNode.next = new Node(value);
        }

        public void reverseList(){
            Node prev = null;
            Node current = head;
            Node next = null;

            while(current != null){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }

        public static void main ( String[] args ) {
            LinkedList3 list = new LinkedList3();
            list.addNode(3);
            list.addNode(6);
            list.addNode(9);
            list.addNode(18);
            list.printList();

            list.reverseList();
            list.printList();
        }
}
