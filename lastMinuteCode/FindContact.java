//
///*
//
//We're going to make our own Contacts application! The application must perform two types of operations:
//
//add name, where  is a string denoting a contact name. This must store  as a new contact in the application.
//find partial, where  is a string denoting a partial name to search the application for.
//It must count the number of contacts starting with  and print the count on a new line.
//Given  sequential add and find operations, perform each operation in order.
//
//Example
//Operations are requested as follows:
//
//add ed
//add eddie
//add edward
//find ed
//add edwina
//find edw
//find a
//Three  operations include the names 'ed', 'eddie', and 'edward'. Next,  matches all  names.
//Note that it matches and counts the entire name 'ed'. Next, add 'edwina' and then find 'edw'.
// names match: 'edward' and 'edwina'. In the final operation, there are  names that start with 'a'. Return the array .
// */
//
//package lastMinuteCode;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class FindContact {
//    Node root;
//    public FindContact (  ) {
//        this.root = root;
//    }
//
//
//
//    static class Node{
//        Node[] children = new Node[26];
//        int count = 0;
//
//        public Node(){};
//    }
//
//    private static int[] contacts ( String[] queries ) {
//        FindContact contactApp = new FindContact();
//        List< ArrayList > results = new ArrayList <>();
//        return results;
//    }
//
//    public static void main ( String[] args ) {
//        String[] queries = {
//                "add hack",
//                "add hackerrank",
//                "find hac",
//                "find hak"
//        };
//        int[] results = contacts(queries);
//        for(int result : results){
//            System.out.println(result);
//        }
//    }
//
//
//}
