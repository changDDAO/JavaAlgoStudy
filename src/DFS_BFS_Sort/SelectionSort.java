package DFS_BFS_Sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int [] arr = {1,9, 37, 25,39,49,51,29,41,13};
        for (int i = 0; i < arr.length; i++) {
            int minIndex= i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;

        }
        Arrays.stream(arr).forEach(s-> System.out.print(s+" "));
        }
}
