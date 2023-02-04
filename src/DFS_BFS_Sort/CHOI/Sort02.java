package DFS_BFS_Sort.CHOI;

import java.util.Scanner;

public class Sort02 {
    private int[] list;
    public Sort02() {
        init();
        insertion();
        printArray();
    }

    public void init() { // 입력 받기와 배열 생성
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        sc.close();
    }

    public void insertion() { // 삽입 정렬
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0 && list[j - 1] < list[j]; j--) {  // j > 0 이고 j - 1 이 j 보다 크면 계속 : 내림차순
                list[j] = swap(list[j - 1], list[j - 1] = list[j]); // 스왑
            }
        }
    }

    public static int swap(int x, int y) {
        return x;
    }

    public void printArray() {
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        new Sort02();
    }
}
