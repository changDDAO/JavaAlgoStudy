package BinarySearch_DynamicProgramming.CHOI;

import java.io.IOException;
import java.util.Scanner;

public class DP04 {
    private int N;
    private int[] mem;

    public DP04() {
        init();
        run();

        System.out.println(mem[N] % 796796);
    }

    /*
    전체 길이는
    가로는 N
    세로는 2 고정

    N의 최소는 1
    [i - 1] 까지의 타일이 이미 채워진 경우 : 최대 2 x 1 1개 가능 => 1가지
    [i - 2] 까지의 타일이 채워진 경우 : 최대 1 x 2 2개 or 2 x 2 1개 가능 => 2가지
     */
    public void run() {
        mem[1] = 1;
        mem[2] = 3;

        for (int i = 3; i < N + 1; i++) {
            mem[i] = mem[i - 1] + 2 * mem[i - 2];
        }
    }

    public void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        mem = new int[N + 1];
        sc.close();
    }

    public static void main(String[] args) throws IOException {
        new DP04();
    }
}
