/*

Permutation
Time Complexity = O(n*n)!
 */


package BackTracking;

public class BackTracking {

    public static void printPermutation(String str, String permutation, int index){
//        base case
        if(str.length() == 0){
            System.out.println(permutation);
            return;
        }
        for(int i = 0; i < str.length(); i++){
            char currentChar = str.charAt(i);
            String newStr = str.substring(0,i) + str.substring(i + 1);
            printPermutation(newStr,permutation + currentChar,index+1);
        }
    }

    public static void main ( String[] args ) {
//        using factorial i can find a multiple combination like 3! = 6
        String str = "ABC";
        printPermutation(str,"", 0);
    }
}
