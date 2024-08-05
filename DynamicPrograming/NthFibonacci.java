
/*
 Program for nth Catalan Number
 */

package DynamicPrograming;

public class NthFibonacci {

    private int catalan ( int n) {
        int result = 0;
        if(n <= 1){
            return 1;
        }
        for(int i = 0;  i< n; i++){
            result += catalan(i) * catalan(n-i - 1);
        }
        return result;
    }

    public static void main ( String[] args ) {
        NthFibonacci n = new NthFibonacci();
        for(int i = 0; i < 10; i++){
            System.out.println(n.catalan(i)  + " ");
        }
    }


}
