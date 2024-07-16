//    1. Create Node class with constructor
//    2. Create LinkedList Class
//    3. Write methods in LinkedList class like append(), printList(), preAppend(),reverseList()

package linkedList;

public class LinkedList2 {

    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
            this.next = null;
        }
    }

        Node head;

//        add nodes into linkedList
        public void append(int value){
//            check node is not null
            if(head == null){
                head = new Node(value);
                return;
            }
            Node newNode = head;
            while(newNode.next != null ){
                newNode = newNode.next;
            }
            newNode.next = new Node(value);
        }
//        print the list
        public void printList(){
            Node newNode = head;
            while(newNode != null){
                System.out.print(newNode.value + " -> ");
                newNode = newNode.next;
            }
            System.out.println();
        }

//        now reverse  the LinkedList

    public void reverseList(){
//            i need to three variables
        Node prev = null;
        Node currentNode = head;
        Node next = null;
        while(currentNode != null){
            next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
        }
        head = prev;
    }

        public static void main ( String[] args ) {
            LinkedList2 list = new LinkedList2();
            list.append(3);
            list.append(4);
            list.append(6);
            list.append(4);
            list.append(1);
            list.append(9);
            list.append(8);
            list.printList();

            System.out.println();
            System.out.println("Reversed LinkedList ");

            list.reverseList();
           list.printList();
        }
    }


