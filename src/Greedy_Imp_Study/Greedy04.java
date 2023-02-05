package Greedy_Imp_Study;

import java.util.Scanner;

public class Greedy04 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        sc.close();

        int cnt = 0;

        while (true) {
            if (N == 1)
                break;

            if (N % K == 0) // N이 K로 나누어 떨어질 경우 최우선 수행(횟수를 최소)
            {
                while (true) {
                    if (N % K != 0)
                        break;

                    if (N == 1)
                        break;

                    N /= K;
                    cnt++;
                }

                continue;
            }

            N -= 1;
            cnt++;
        }

        System.out.println(cnt);
    }
}
