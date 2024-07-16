package linkedList;


import java.util.LinkedList;

public class LL {

    public static void main ( String[] args ) {

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("a");
        linkedList.addFirst("is");
        System.out.println(linkedList);

        linkedList.addFirst("This");
        linkedList.add("list");
        System.out.println(linkedList);

        System.out.println(linkedList.size());

        for(int i=0; i< linkedList.size(); i++){
            System.out.print(linkedList.get(i) + " =>");
        }
        System.out.println("null");

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        linkedList.remove(1);
        System.out.println(linkedList);
    }

}
