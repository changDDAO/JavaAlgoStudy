package Greedy_Imp_Study;

import java.util.Scanner;

public class Greedy04 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int cnt = 0;

        while(N != 1) {
            if (N % K == 0) {
                while (true) {
                    if (N % K != 0) {
                        break;
                    }

                    if (N == 1) {
                        break;
                    }

                    N /= K;
                    cnt++;
                }
            } else {
                N -= 1;
                cnt++;

            }
        }

        System.out.println(cnt);
    }
}
