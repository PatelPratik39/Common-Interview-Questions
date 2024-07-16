


/*

Reverse LinkedList without changing memory so time complexity should be O(1)  -- USING iterative way(Most important)

 */
package linkedList;

import java.util.LinkedList;

public class ReverseLinkedList {
    Node head;
//    create a Single Node
    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
            this.next = null;
        }
    }


//    let's reverse the linkedList
    public void  reverseList(){
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null ){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

//    Print a LinkedList

    public void printList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void append(int value){
        if(head == null){
            head = new Node(value);
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(value);
    }

    public static void main ( String[] args ) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        System.out.print("Original List " + list);
        list.printList();

        list.reverseList();

        System.out.print("Reversed List:");
        list.printList();




    }
}
