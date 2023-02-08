package BinarySearch_DynamicProgramming.CHOI;

public class DP_Fibonacci {
    private long[] mem_TD;
    private long[] mem_BU;

    /*
        배열에 해당 피보나치 값을 저장
        계산 중 이미 계산한 값을 한번 더 계산하지 않고 값만 불러와서 속도 향상
     */
    public DP_Fibonacci() {
        mem_TD = new long[100];
        mem_BU = new long[100];

        System.out.println("fibo_TopDown(99) = " + fibo_TopDown(99));
        System.out.println("fibo_BottomUp(99) = " + fibo_BottomUp(99));
        // long 자료형 사용해도 범위를 벗어나 음수값이 출력됨 ????
    }

    private long fibo_TopDown(int x) {
        if (x == 1 || x == 2)
            return 1;

        if (mem_TD[x] != 0) // 이 전에 기록된 결과 반환
            return mem_TD[x];

        mem_TD[x] = fibo_TopDown(x - 1) + fibo_TopDown(x - 2);

        return mem_TD[x];
    }

    private long fibo_BottomUp(int x) {
        mem_BU[1] = 1;
        mem_BU[2] = 1;

        for (int i = 3; i < x + 1; i++) {
            mem_BU[i] = mem_BU[i - 1] + mem_BU[i - 2];
        }

        return mem_BU[x];
    }

    public static void main(String[] args) {
        new DP_Fibonacci();
    }
}
