/*
Find the first and last occurrence of a String character using Recursion.
We have a string where I want to find an index of an character from string where i want to see when it came first and last time within a string
abaacdaefaah =>first a =1 and last a =10
 */

package Recursion;

public class Recursion3 {

    public static int firstOccurence = -1;
    public static int lastOccurrence = -1;

    public static void findOccurence(String str, int index, char element){    // Time Complexity = O(n) because of String length
        if(index == str.length()){
            System.out.println(firstOccurence);
            System.out.println(lastOccurrence);
            return;
        }
        char currentChar = str.charAt(index);
        if(currentChar == element){
            if(firstOccurence == -1){
                firstOccurence = index;
            }else {
                lastOccurrence = index;
            }
        }
        findOccurence(str,index + 1,element);
    }


//    another method

    public static void findOccurence(String str, char element){
        int firstOccurence = str.indexOf(element);
        int lastOccurence = str.lastIndexOf(element);
        if(firstOccurence == -1){
            System.out.println("Not Found");
        }else {
            System.out.println(firstOccurence);
            System.out.println(lastOccurence);
        }
    }
    public static void main ( String[] args ) {
        String str = "abaacdaefaah";
        findOccurence(str,0,'a');
        char element = 'a';
        findOccurence(str, element);
    }
}
