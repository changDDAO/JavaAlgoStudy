package DFS_BFS_Sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int []arr = {1,13,2,15,14,39,41,33,13,19,21};
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }else break;
            }
        }
        Arrays.stream(arr).forEach(s-> System.out.print(s+" "));
    }
}
