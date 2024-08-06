package lastMinuteCode;

import java.util.Scanner;
import java.util.Stack;

public class BalanceBrackets {

    private static String isBalance ( String str ) {
//        create a Stack
        Stack<Character> stack = new Stack <>();

        for(char c : str.toCharArray()){
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return "NO";
                }
                char top = stack.pop();
                if(!isMatchingPair(top, c)){
                    return "NO";
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static boolean isMatchingPair(char open, char close){
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main ( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // newline

        for(int i=0; i <n; i++){
            String str = scanner.nextLine();
            System.out.println(isBalance(str));
        }
        scanner.close();
    }


}
