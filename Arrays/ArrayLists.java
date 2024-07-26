package Arrays;

import java.util.*;


public class ArrayLists {
    public static void main ( String[] args ) {
        ArrayList <Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        System.out.println(list);

        int elm = list.get(1);
        System.out.println(elm);

        list.add(1,5);
        System.out.println(list);

        for (int i=0; i<list.size(); i++){
            System.out.print(list.get(i));
        }
        System.out.println();

//        sorting
        Collections.sort(list);
        System.out.println(list);
    }
}
