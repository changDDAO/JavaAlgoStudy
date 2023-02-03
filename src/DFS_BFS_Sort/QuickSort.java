package DFS_BFS_Sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int []arr, int start, int end) {

        //책에서 구현하는 quick sort는 첫번째값을 pivot으로 둔다 그후 왼쪽부터는 pivot보다 큰값 오른쪽부터는 pivot보다 작은값을 찾아
        //swap 수행 left가 right와 엇갈린다면 right 즉 작은값을 pivot과 교체
        if(start>=end) return;//종료조건 명시 꼭하기
        int left = start+1;
        int right = end;
        while (left <= right) {
            while(left<=end&&arr[left]<=arr[start]) left++; //left인덱스가 end 끝지점보다 작고 arr[left] 값이 pivot 값 보다 작다면
            // pivot보다 큰 값을 찾을 때까지 left 인덱스 증가
            while(right>start&&arr[right]>=arr[start])right--; //right index가 start+1지점이상이면서 arr[right]값이 pivot값 보다
            //크다면 pivot보다 작은 값을 찾을때 까지 인덱스 감소
            if (left > right) { //엇갈렸다면
                int temp = arr[start];
                arr[start] = arr[right];
                arr[right] = temp; //swaping 진행
            } else  { //엇갈린것이 아니라면
                int temp = arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
            quickSort(arr,start,right-1);
            quickSort(arr,right+1,end);


        }
    }

    public static void main(String[] args) {
        int []arr ={13,16,15,21,5,3,10,41,39,41,22,19, 49,83,23};
        quickSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(s-> System.out.print(s+" "));
    }
}

