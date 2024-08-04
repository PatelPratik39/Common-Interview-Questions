package BackTracking;

public class BackTracking2 {
    public static void printPermutation(String str, String permutation, int index){
//        base case
        if(str.length() == 0){
            System.out.println(permutation);
            return;
        }
        for(int i=0; i < str.length(); i++){
            char currentChar = str.charAt(i);
            String newStr = str.substring(0,i) + str.substring(i+1);
            printPermutation(newStr,permutation+currentChar, index+1);
        }
    }


    public static void main ( String[] args ) {
        String str = "XYZ";
        printPermutation(str,"",0);
    }
}
