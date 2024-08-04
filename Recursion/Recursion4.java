/*
Move all 'x' to the end of the string
input : "axbcxxd"
output : "abcdxxx"

Time complexity of this code is O(n + count) = O(2n) = O(n)
 */

package Recursion;

public class Recursion4 {

//    public static void moveAllX(String str, int index, int count, String newString){
////        base case
//        if(index == str.length()){
//            for(int i = 0; i < count; i++){
//                newString += 'x';
//            }
//            System.out.println(newString);
//            return;
//        }
//        char currentChar = str.charAt(index);  // create a currentChar  char type variable that stores the value of each character from string
//        //if the current character is matched with x character then increase the count but,
////         if its not the take all the character to the new string recursively
//
//        if(currentChar == 'x'){
//            count++;
//            moveAllX(str,index+1,count,newString);
//        } else {
//            newString = newString + currentChar;  // I am adding each character into new string that is empty at initial state
//            moveAllX(str, index+1, count, newString);
//        }
//    }

    public static void moveAllX(String str, int index, int count, String newString){
//        base case
        if(index == str.length()){
            for(int i = 0; i < count; i++){
               newString += 'x';
            }
            System.out.println(newString);
            return;
        }
//        create char variable
        char currChar = str.charAt(index);

        if(currChar == 'x'){
            count++;
            moveAllX(str,index+1,count,newString);
        } else {
            newString += currChar;
            moveAllX(str,index+1,count,newString);

        }

    }

    public static void main ( String[] args ) {
            String str = "axbcxxd";
            moveAllX(str,0,0,"");

    }
}
