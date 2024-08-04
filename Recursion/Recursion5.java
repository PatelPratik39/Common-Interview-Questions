/*
Probelem 5: Remove All duplicate characters from a string
        Input: "abbccddaa"
        output: "abcd"

        Time complexity  = O(n)
 */

package Recursion;

import java.util.stream.Collectors;

public class Recursion5 {

//    public static boolean[] map = new boolean[26];    //create a map [] which holds character 26 of alphabets
//
//    public static void removeDuplicates(String str, int index, String newString){
//        //base case
//        if(index == str.length()){
//            System.out.println(newString);
//            return;
//        }
//
//        char currentChar = str.charAt(index);  //find out current character
//        if(map[currentChar - 'a']){  //calculating an index from a map array by subtracting character -'a' like ['b' - 'a' = 1]
//            removeDuplicates(str,index+1,newString);
//        } else {
//            //if current is new then add into newString
//            newString += currentChar;
//            map[currentChar - 'a'] = true;
//            removeDuplicates(str,index+1, newString);
//        }
//    }

    public static boolean map[] = new boolean[26];

    public static void removeAllDuplicates(String str, int index, String newString){

//        base case
        if(index == str.length()){
            System.out.println(newString);
            return;
        }
        //lets find a character from a string
        char currChar = str.charAt(index);

        if(map[currChar - 'a']){
            removeAllDuplicates(str,index+1,newString);
        } else{
            newString += currChar;
            map[currChar - 'a'] = true;
            removeAllDuplicates(str,index+1,newString);
        }

    }


    //second Attempt using java 8
    public static String removeDuplicates(String str){
        return str.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    public static void main ( String[] args ) {
        String str = "abbccddaa";
//        removeDuplicates(str,0,"");
        System.out.println(removeDuplicates(str));

        removeAllDuplicates(str,0, "");
    }
}
