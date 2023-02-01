package Greedy_Imp_Study;

import java.util.Scanner;

public class Implementation02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        int x = input.charAt(0) - 'a' + 1;
        int y = input.charAt(1) - '0';

        int min = 1;
        int max = 8;

        /*
            -2 -1
            -2 1
            -1 -2
            -1 2
            1 -2
            1 2
            2 -1
            2 1
         */

        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

        int cnt = 0;

        for (int i = 0; i < dx.length; i++) {
            if (x + dx[i] >= min && x + dx[i] <= max) {
                if (y + dy[i] >= min && y + dy[i] <= max) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
