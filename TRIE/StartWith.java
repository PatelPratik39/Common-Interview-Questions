package TRIE;

public class StartWith {

//    create static class for node
    static class Node{
        Node[] children;
        boolean eow;
        public Node(){
            children = new Node[26];
            eow = false;
        }
    }
//    initialize Node that should be empty
    static Node root = new Node();

     public static void insert(String words){
       Node currentRoot = root;

       for (int i=0; i < words.length(); i++){
           int idx = words.charAt(i) - 'a';
           if (currentRoot.children[idx] == null){
               currentRoot.children[idx] = new Node();
           }
           currentRoot = currentRoot.children[idx];
       }
       currentRoot.eow = true;
    }

////    search Fucntion
//    public static boolean search(String key){
//        Node currentNode = root;
//        for(int i = 0;  i < key.length(); i++){   //O(L)
//            int idx = key.charAt(i) - 'a';
//            Node node = currentNode.children[idx];
//
//            if(node == null){
//                return false;
//            }
//
//            if(i ==key.length()-1 && node.eow == false){
//                return false;
//            }
//            currentNode = node;
//        }
//        return true;
//    }

//      startsWith function to find a word using prefix of keyword
    public static boolean startWith(String prefix){
//         initialize new root node
            Node currentNode = root;
//            find a character from words using for loop

            for(int i = 0; i <prefix.length(); i++){
                int idx = prefix.charAt(i) - 'a';
                Node node = currentNode.children[idx];

                if(node == null){
                    return false;
                }
                currentNode = node;
            }
            return true;
     }

    public static void main ( String[] args ) {
        String words[] = {"apple", "app", "mango", "man", "woman"};
        String prefix = "man";

        for(String word : words){
            insert(word);
        }
        System.out.println(startWith(prefix));
    }
}
