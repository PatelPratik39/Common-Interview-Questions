package TRIE;

public class TRIEDemo {

//    create a Node class
    static class Node {
    //        add variables like a Node type of array with name of children and boolean type of end of Word node
    Node[] children;
    boolean eow;

    //        create constructor
    public Node () {
//            at the initial stage, I don't have any data, so I need to assign a children as a new Node with[26] characters because
//            In Java, we have to assign or define space in an array, so I define in constructor with 26.
//           children = new Node[26]; // create a new children Node with 26 characters long children array with a-z
//        Iterate of the array to provide characters, and at the initial stage, i have to set children[i] as null by allocating a space but
//        i don't have exact space that why i am providing value as null;

        children = new Node[26]; // create a new children Node with 26 characters long children array with a-z
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
        eow = false; //initial state of the end of word node
    }

    static Node root = new Node();


//    Insert function
    public static void insert(String word){

        Node currntNode = root;
        for(int i=0; i< word.length(); i++){   // O(L) time complexity
            int idx = word.charAt(i)-'a';
            if(currntNode.children[idx] == null){
                //add new node if node is null
                currntNode.children[idx]  = new Node();
            }
            if( i == word.length() - 1){
                currntNode.children[idx].eow = true;
            }
//     The previous nod will be new Node
            currntNode = currntNode.children[idx];
        }
    }

//    Search Function in TRIE
    public static boolean search(String key){

        Node currntNode = root;
//        first, I need to find the index of a character from string
        for(int i = 0; i < key.length(); i++){    // Time Complexity => O(L); L = key length
            int index = key.charAt(i)- 'a';
            Node node = currntNode.children[index];

            if(node == null) { //if current root is null
                return false;    // return false;
            }
            if(i == key.length() - 1 && node.eow == false){  // if I am at the last character of key and that node is not a eow then return false
                return false;
            }
            currntNode = node;  // update the root based on index
        }
        return true;
    }
    /*
         wordBreak()
         */


    public static boolean wordBreak(String key){
        if(key.length() == 0){
            return true;
        }
//    i need to slice each character
        for(int i = 0; i <= key.length(); i++){
            String firstPart = key.substring(0,i);  //0-1
            String secondPart = key.substring(i);

            if(search(firstPart) && wordBreak(secondPart)){
                return true;
            }
        }
        return false;
    }

    public static void main ( String[] args ) {
//        String words[] = {"the", "a", "there", "their", "any", "them", "then"};

        String words[] = {"i", "like", "sam", "samsung", "mobile"};
        String key = "ilikesamsung";

        for(int i=0; i< words.length;i++){
            insert(words[i]);
        }
        System.out.println(wordBreak(key));
//        System.out.println(search("their"));
//        System.out.println(search("them"));
//        System.out.println(search("thor"));
//        System.out.println(search("an"));
    }
}
}
