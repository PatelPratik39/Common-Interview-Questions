/*
            Print All te Unique sub sequences of a String

            input = "aaa"
            output = "aaa", "aa","a"
 */

package Recursion;

import java.util.HashSet;

public class Recursion7 {

    public static void uniqueSubSequence(String str, int index, String newString,  HashSet<String> set){
        if(index == str.length()){
            if(set.contains(newString)){
                return;
            }else {
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }
        char currChar = str.charAt(index);
//        to be joined
        uniqueSubSequence(str,index + 1,newString + currChar,set);
//        not to be joined
        uniqueSubSequence(str,index+1,newString,set);
    }

    public static void main ( String[] args ) {
        String str = "aaa";
        HashSet<String> set = new HashSet<>();   // to get unique values from a string
        uniqueSubSequence(str,0,"",set);
    }
}
