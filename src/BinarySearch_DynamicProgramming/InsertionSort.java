package BinarySearch_DynamicProgramming;

public class InsertionSort {
    public static void main(String[] args) {
        int []arr = {3,19,4,11,13,16,31,44};
        for(int i=1;i<arr.length;i++){
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }else break;
            }
        }
        for (int j : arr) System.out.println(j);
    }
}
