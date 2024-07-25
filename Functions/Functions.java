package Functions;

import java.util.Scanner;

public class Functions {

    public static void printMyName(String name){
        System.out.println(name);
        return;
    }
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        printMyName(name);
    }
}
