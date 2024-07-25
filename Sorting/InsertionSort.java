package Sorting;

public class InsertionSort {
//    write a method to print array
    public static void printArray(int arry[]){
        for(int i : arry){
            System.out.print(i + " - ");
        }
        System.out.println();
    }

    public static void main ( String[] args ) {
        int arry[] = { 7,8,3,1,2,4};

//        Insertion sort logic
        for(int i = 1; i < arry.length; i++){
            int current = arry[i];
            int j = i -1;
            while(j >= 0 && current < arry[j]){
                arry[j+1] = arry[j];
                j--;
            }
//            placement of the element that is smaller than sorted elements
            arry[j+1] = current;
        }
        printArray(arry);  //calling printArrayMethod
    }

}
