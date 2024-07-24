package TRIE;

public class TRIEDemo2 {

    static class Node{
        Node[] children;
        boolean eow;  // end-Of-Word

        public Node(){
            children = new Node[26]; //a-z values
//            now I need to initialize this array using for loop
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
            eow = false; // initialize eow as false
        }
    }
//    when ever we try to use TRIE data structure, we need to define a node as empty
    static Node root = new Node();

    /*
    Insert()
     */
    public static void insert(String words){
//        I need to create a new node as current
        Node currentRoot = root;
//        to insert a word into TRIE first, i need to find a character index using for loop iteration
        for(int i =0; i < words.length(); i++){   // O(L)
            int idx = words.charAt(i) - 'a';   //to get index number of a character, i need to subtract index i from character of a and store in index
//            first condition to check if the current node is null or not, if its a null then create new Node
            if(currentRoot.children[idx] == null){
//                add new Node
                currentRoot.children[idx] = new Node();
            }
//            second Condition to check if the last node is valid word
            if(i == words.length() - 1){
                currentRoot.children[idx].eow = true;
            }
//            create new Root at the end
            currentRoot = currentRoot.children[idx];
        }
    }

    /*
    search() -> Time complexity is O(L)
     */

    public static boolean search(String key){
        Node currentRoot = root;
//        first iterate over a word to find the character of a word
        for(int i=0; i < key.length(); i++){
            int idx = key.charAt(i) - 'a';   //storing the index number of character into idx variable
            Node node = currentRoot.children[idx];
//            first condition to check if the node is null or not, if its null then return false
            if(node == null){
                return false;
            }
//            second condition to check if last charter of a word from KEY and a node from eod are false
            if(i == key.length()-1 && node.eow == false){
                return false;
            }
//            create new root
            currentRoot = currentRoot.children[idx];
        }
        return true;
    }


    public static void main ( String[] args ) {
        String words[] = {"the", "a", "there", "their", "any", "them", "then"};
//        Now, i want to send each string of words[] to the TRIE so i need to iterate over an array
        for(int i = 0; i < words.length; i++){
            insert(words[i]);
        }
        System.out.println(search("their"));
        System.out.println(search("there"));
        System.out.println(search("thor"));
        System.out.println(search("an"));

    }
}
