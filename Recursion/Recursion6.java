/*
*               Print All the SubSequences of a String - IMPORTANT
*           Input : "abc"
*            Output : abc
ab
ac
a
bc
b
c
*
*    Time Complexity = 2^n = for "abc" = 2^3 = 8   => O(2^n)
* */

package Recursion;

public class Recursion6 {

    public static void subSequence(String str, int index, String newString){
//        base case
        if(index == str.length()){
            System.out.println(newString);
            return;
        }
//        let's get the first current character form string
        char currChar = str.charAt(index);
//        currentChar has 2 choices
//        to be joined
        subSequence(str, index+1, newString + currChar);
//        or not to be joined
        subSequence(str, index+1, newString);
    }

    public static void main ( String[] args ) {
        String str = "abc";
        subSequence(str,0,"");
    }
}
