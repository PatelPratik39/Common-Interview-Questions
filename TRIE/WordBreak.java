package TRIE;

public class WordBreak {
    static class Node {
        Node[] children;
        boolean eow;

        public Node () {
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }
        static Node root = new Node();  // initialize static node first
        /*
            insert() -> Time complexity will be O(L) because we have one loop
         */
        public static void insert(String words){
            Node currentRoot = root;
//            find index number of each word through iteration
            for(int i=0; i< words.length(); i++){
                int idx = words.charAt(i) - 'a';

                if(currentRoot.children[idx] == null){
//                    if the current child root is null then create new Node
                    currentRoot.children[idx] = new Node();
                }
                if(i == words.length()-1){
                    currentRoot.children[idx].eow = true;
                }
//                create new root node
                currentRoot = currentRoot.children[idx];
            }
        }
        /*
        search()
         */
        public static boolean search(String key){
            Node currentRoot = root;
            for(int i = 0; i < key.length(); i++){
                int idx = key.charAt(i) - 'a';

                if(currentRoot.children[idx] == null){
                    return false;
                }
                if( i == key.length()-1 && currentRoot.children[idx] == null){
                    return false;
                }
//                create new root
                currentRoot = currentRoot.children[idx];
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
        String words[] = {"i", "like", "sam", "samsung", "mobile"};
        String key = "ilikesam";

        for(int i=0; i < words.length; i++){
            insert(words[i]);
        }
        System.out.println(wordBreak(key));
    }
}
