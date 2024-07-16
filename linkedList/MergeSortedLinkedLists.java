package linkedList;

import java.util.LinkedList;

public class MergeSortedLinkedLists {

    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
            this.next = null;
        }
    }

    class LinkedList{
        Node head;
//        Add Node into Linked List
        public void append(int value){
            if(head == null){
                head = new Node(value);
                return;
            }
            Node newNode = head;
            while(newNode.next != null){
                newNode = newNode.next;
            }
           newNode.next = new Node(value);
        }

//        Print the list
        public void printList(){
            Node newNode = head;
            while (newNode != null){
                System.out.print(newNode.value + " => ");
                newNode = newNode.next;
            }
            System.out.println("Null");
        }

//        Merge Two sorted LinkedList
        public Node mergeSortedLists(Node l1, Node l2){
            Node dummy = new Node(0);
            Node tail = dummy;

            while(l1 != null && l2 != null){
                if(l1.value < l2.value){
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }

//            If one of the list is not empty, append it to result
            if(l1 != null){
                tail.next = l1;
            }
            else {
                tail.next = l2;
            }
            return dummy.next;
        }
    }

    public static void main ( String[] args ) {
        MergeSortedLinkedLists mergeList = new MergeSortedLinkedLists();
        LinkedList list1 = mergeList.new LinkedList();
        list1.append(1);
        list1.append(3);
        list1.append(5);
        list1.append(7);

        LinkedList list2 = mergeList.new LinkedList();
        list2.append(2);
        list2.append(4);
        list2.append(6);
        list2.append(8);
        System.out.println("List 1 ");
        list1.printList();
        System.out.println("List 2 : ");
        list2.printList();

        LinkedList result = mergeList.new LinkedList();
        result.head = result.mergeSortedLists(list1.head, list2.head);

        System.out.println("Merged List:");
        result.printList();
    }
}
