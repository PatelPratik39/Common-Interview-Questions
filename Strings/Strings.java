package Strings;

public class Strings {

    public static void main ( String[] args ) {

//        substring function
        String sentence =  "My Name is Tony Stark";
//       String newSentence =  sentence.substring(11, sentence.length());
        String newSentence =  sentence.substring(12);

        StringBuilder stringBuilder = new StringBuilder(sentence);
        String reverseStr = stringBuilder.reverse().toString();

        System.out.println(reverseStr);

    }
}
