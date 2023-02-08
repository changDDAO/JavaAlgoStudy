package BinarySearch_DynamicProgramming.CHOI;

import java.util.Scanner;

public class DP02 {
    private long[] mem;
    private int cnt = 0;

    public DP02() {
        Scanner sc = new Scanner(System.in);
        mem = new long[30001];
        int X = sc.nextInt();
        fibo(X);
        System.out.println(mem[X]);
        sc.close();
    }

    public void fibo(int x) {
        for (int i = 2; i < x + 1; i++) {
            mem[i] = mem[i - 1] + 1; // -1 했을 때 경우의 수를 저장

            // 각 나눗셈 연산이 가능한 경우 연산하여 해당 인덱스에서의 값을 최소 값으로 갱신해줌
            if (i % 2 == 0)
                mem[i] = Math.min(mem[i], mem[i / 2] + 1);

            if (i % 3 == 0)
                mem[i] = Math.min(mem[i], mem[i / 3] + 1);

            if (i % 5 == 0)
                mem[i] = Math.min(mem[i], mem[i / 5] + 1);
        }
    }

    public static void main(String[] args) {
        new DP02();
    }
}
