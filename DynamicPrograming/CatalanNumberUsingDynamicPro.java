package DynamicPrograming;

public class CatalanNumberUsingDynamicPro {

    private static int catalanDynamic ( int n ) {

        int[] catalan = new int[n+1];
//        initialize first catalan number
        catalan[0] = 1;
//        fill the catalan array in bottom-up manner
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                catalan[i] += catalan[j] * catalan[i - j -1];
            }
        }
        return catalan[n];
    }
    public static void main ( String[] args ) {
        int n = 8;
        System.out.println("The " + n + "th Catalan number (using dynamic programming) is: " + catalanDynamic(n));
    }


}
