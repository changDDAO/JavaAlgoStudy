package DFS_BFS_Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice2_Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> intList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            intList.add(sc.nextInt());
        }
        intList.sort(Collections.reverseOrder());
        intList.forEach(value-> System.out.print(value+" "));
        //주석 달기도 부끄러운 문제...
    }
}
