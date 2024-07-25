/*
Find the Longest string words such that every prefix of its also in words.
 */

package TRIE;

public class LongestWordWithPrefixes {

    static class Node{
        Node[] children;
        boolean endOfWord;

        public Node(){
            children = new Node[26];
            endOfWord = false;
        }
    }
//initialize root node
    static Node root = new Node();

    public static void insert(String word){
        Node currentRoot = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a'; //calculate the index number of character
            Node node = currentRoot.children[idx];

            if(node == null){
                node = new Node();
                currentRoot.children[idx] = node;
            }
//            make the end of workd
            if(i == word.length() - 1){
                node.endOfWord = true;
            }
            currentRoot = node;   // Move to the next node in the Trie
        }
    }

    public static  boolean search(String key){
//        create root node
        Node currentRoot = root;
        for(int i = 0; i<key.length(); i++){
            int idx = key.charAt(i) - 1;
            Node node = currentRoot.children[idx];

            if(node == null){
                return false;
            }
            if(i == key.length() -1 && node.endOfWord == false){
                return false;
            }
            currentRoot = node;
        }
        return true;
    }


    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp){
//        iterate over a children array
        for (int i=0; i < 26; i++){
//            if I indexed child root is not null and i indexed child is endOF word true?
            if(root.children[i] != null && root.children[i].endOfWord == true){
                temp.append((char) (i + 'a'));   // in temp array, I am appending index character by type cast converting from int to character
                if(temp.length() > ans.length()){  // if temp string length is greater than and string length !!
                    ans = temp.toString();     //storing that temp length to answer string
                }
//                recursive call
                longestWord(root.children[i],temp );
//                deleting character on backtracking process
                temp.deleteCharAt(temp.length() -1);
            }
        }
    }

    public static void main ( String[] args ) {
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "appl", "continuously"};
        String str = "apple";
        System.out.println(str);


        for(String word :  words){
            insert(word);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
