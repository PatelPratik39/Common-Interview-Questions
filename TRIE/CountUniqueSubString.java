
/*
    Given a string of length n of lowercase alphabet characters, we need to count the total number of distinct (Unique) substring of this string
 */
package TRIE;

public class CountUniqueSubString {
//    create a node
    static class Node{
        Node[] children;
        boolean endOfWord;
        public Node(){
            children = new Node[26];
//            for(int i=0; i < 26; i++){
//                children[i] = null;
//            }
            endOfWord = false;
        }
    }
//    Initialize root node
     static  Node root = new Node();

    /*
        insert() function to add nodes into a TRIE tree
     */

    public static void insert(String word){

//        first, I need to initialize root as current Node
        Node currentRoot = root;

//        Iterate over each character in the word
        for(int i = 0; i <word.length(); i++){
            int idx = word.charAt(i) - 'a';     //Calculate index for the current character
            Node node = currentRoot.children[idx];

//            if current root's child[i] is null then create New Node
            if(node== null){
                node = new Node();
                currentRoot.children[idx] = node;
            }

            if(i == word.length() - 1){    // Check if this is the last character of the word
                node.endOfWord = true; // Mark the end of the word at the last character node
            }
            currentRoot = node;   // Move to the next node in the Trie
        }
    }

    /*
        search() function to search nodes into a TRIE tree
     */
    public static boolean search(String key){
//        Initialize root node as current Node
        Node currentRoot = root;

//        Iterate over each character in the key
        for(int i=0; i < key.length(); i++){
//            calculate the index number of the character from an array
            int index = key.charAt(i) - 'a';
            Node node = currentRoot.children[index];

            if (node == null) { // if character at index is not present
                return false;  // then key is not present
            }
            currentRoot = node;  // move to new node in the TRIE
        }
        return currentRoot.endOfWord;  // check if current node is marked as EOD as true or not
    }


    /*
        find uniqueSubstrings() function to find distinct substring count from a string
     */

    public static int countNode(Node root){  // Node object - root, that i have used as parameter because count start from root node
//        base case -> if node is Null!!
        if(root == null){
            return 0;
        }
//        initialize count as 0
        int count = 0;
        for(int i=0; i < 26; i++){  // this for loop iterates over all possible children of the current Node
            if(root.children[i] != null){  // check if the child node of root is not null
                count += countNode(root.children[i]);  //then it recursively calls countNode on that child node
            }
        }
        return count + 1;  // after iterating through children, count contains total number of node with adding 1 current node as well
    }


    public static void main ( String[] args ) {
//        String words[] = {"the", "a", "there", "their", "any", "them", "then"};
//        String str = "ababa";
//        for(String word : words){
//            insert(word);
//        }

//        System.out.println(search("their"));


//        String str = "ababa";
        String str = "BANANA";
        //to get all suffixes from a string, I need to iterate over string using for loop
        for(int i =0; i < str.length(); i++){
            String suffix = str.substring(i).toLowerCase();
            insert(suffix);
            System.out.println(suffix);
       }
        System.out.println();
        System.out.println("Total count of unique (Distinct) possible substring of given String : " + countNode(root));


//
//        for(int i=0; i< str.length(); i++){
//            String prefix = str.substring(0, i+1);
//            System.out.println(prefix);
//        }

    }
}
