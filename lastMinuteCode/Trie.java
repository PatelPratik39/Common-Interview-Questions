package lastMinuteCode;

import TRIE.TRIEDemo;
import TRIE.TRIEDemo2;

public class Trie {

    static class Node{
        Node[] children;
        boolean eow;

        public Node() {
            children = new Node[26];
//            initialize this array
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    static Node root = new Node();  // I have to create empty root node as static in TRIE data structure

    public static void insert(String word){
        Node currentNode = root;
        for(int i = 0; i < word.length(); i++){   //loop over word O(L)

            int index = word.charAt(i) - 'a';    // find index of particular character from a word
            if(currentNode.children[index] == null){  // node is null then create new node
                currentNode.children[index] = new Node();
            }
//            eow condition
            if(i == word.length()-1){
                currentNode.children[index].eow = true;
            }
            currentNode = currentNode.children[index]; //updating a root
        }
//        currentNode.eow = true;
    }

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
        String words[] = {"the", "a", "there", "their", "any", "that"};

        for(String word : words){
            insert(word);
        }
        System.out.println(search("their"));
        System.out.println(search("any"));
        System.out.println(search("an"));
    }
}
