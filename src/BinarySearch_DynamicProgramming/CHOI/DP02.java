package BinarySearch_DynamicProgramming.CHOI;

public class DP02 {
    private long[] mem;
    private int cnt = 0;
    public DP02() {
        /*
        x % 5 == 0 => / 5
        x % 3 == 0 => / 3
        x % 2 == 0 => / 2
        -1
         */

        mem = new long[30001];

    }

    public long fibo(int x) {
        cnt++;

        if (x % 2 == 0)
            return fibo(x - 1);
        return 1;
    }

    public static void main(String[] args) {
        new DP02();
    }
}
