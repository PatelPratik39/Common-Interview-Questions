package linkedList;

public class LinkedList {

//    create Head first
        Node head;
//        size variable
        private int size;
        LinkedList(){
            this.size = 0;
        }
//    Create Node first as a class

    class Node {
//        node contains two properties lik data and politer 'next'
        String data;
        Node next;

//        add constructor
//        At the initial stage, when we create a node for linked list, Node contains data and pointer that should be next but value remain null before connecting to another node.
        Node(String data){
            this.data = data;
            this.next = null;
            size++;
        }
    }

//    Add node in linkedList
    public void addFirstNode(String data){
        Node newNode =  new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

//    Add new Node at last position

    public void addLstNode(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }

//    print
    public void  printList(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }

        Node currNode = head;
        while (currNode != null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

//    Delete first Node
    public void deleteFirstNode(){
        if(head == null){
            System.out.println("Your list is Emty");
            return;
        }
        size--;
        head = head.next;
    }

//    deleteLastNode
    public void deleteLast(){
        if(head == null){
            System.out.println("This is empty List");
            return;
        }
        size--;
//        if header.next is null, we just return badk
        if(head.next == null){
            head = null;
            return;
        }
        Node secondLast = head;
        Node lastNode = head.next;

        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    public int getSize(){
         return size;
    }



    public static void main ( String[] args ) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirstNode("a");
        linkedList.addFirstNode("is");
        linkedList.printList();

        linkedList.addLstNode("LastNode");
        linkedList.printList();

        linkedList.addFirstNode("This ");
        linkedList.printList();

        linkedList.deleteFirstNode();
        linkedList.printList();

        linkedList.deleteLast();
        linkedList.printList();

        System.out.println( linkedList.getSize());
        linkedList.addFirstNode("THISSSSS");

        System.out.println( linkedList.getSize());
    }
}
