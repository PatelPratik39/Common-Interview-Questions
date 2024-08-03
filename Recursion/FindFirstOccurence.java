package Recursion;

public class FindFirstOccurence {
    public static void findOccurence(String str, char element){
        int first = str.indexOf(element);
        int last = str.lastIndexOf(element);

        if(first == -1){
            System.out.println("Not Found!!!");
        } else {
            System.out.println("first Occurrence : " +  first);
            System.out.println("Last Occurrence : " +  last);
        }
    }

    public static void findOccrnc(String str, int index, char elmnt){
        int first = str.indexOf(elmnt);
        int last = str.lastIndexOf(elmnt);
        if(index == str.length()){
            System.out.println(first);
            System.out.println(last);
            return;
        }
        char currentChar = str.charAt(index);
        if(currentChar == elmnt){
            if(first == -1){
                first = index;
            } else {
                last = index;
            }
        }
        findOccrnc(str, index+1, elmnt);

    }


    public static void main ( String[] args ) {
        String str = "fdsdgljfsdjhvgcjbaasssdde";
        char element = 'd';
        findOccurence(str,element);

        findOccrnc(str,0,'d');
    }
}
