package Recursion;

public class ReverseString {
    public static void printStrReverse(String str, int index){   //Time Complexity = O(n)

//        base case once we reach at first index from last then print whole string
        if(index == 0){
            System.out.println(str.charAt(index));
            return;
        }
        System.out.print(str.charAt(index) + " ");
        printStrReverse(str,index - 1);
    }
//    using String Builder
    public static String printStrReverse2(String str1){
        StringBuilder reversed = new StringBuilder();
        for(int i = str1.length() - 1; i >= 0; i--){
            reversed.append(str1.charAt(i));
        }
        return reversed.toString();
    }

//    using Java8
    public static String reversedStrReversed3(String str3){
        return new StringBuilder(str3).reverse().toString();
    }

    public static void main ( String[] args ) {
        String str = "Hello, World";
        printStrReverse(str, str.length()-1);

        String str1 = "Lasan Lala";
        String reversed = printStrReverse2(str1);
        System.out.println(reversed);

        String str3 = "Mangoo Moti";
        System.out.println(reversedStrReversed3(str3));
    }
}
