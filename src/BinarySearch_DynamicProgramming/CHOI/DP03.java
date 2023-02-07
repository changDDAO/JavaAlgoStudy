package BinarySearch_DynamicProgramming.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class DP03 {
    private int N;
    private int[] mem;
    private int[] storage;

    public DP03() throws IOException {
        init();
        run();
        System.out.println(mem[N]);
    }

    // mem 배열에 각 위치까지 얻을 수 있는 최대 식량을 기록
    // [i - 1] => 직전 저장고까지 털었을 경우
    // [i - 2] + storage[i] => 현재 저장고에서 2번째 전의 저장고까지 털었을 경우 현재 저장고를 털 수 있음
    public void run() {
        for (int i = 2; i < N + 1; i++) {

            mem[i] = Math.max(mem[i - 1], mem[i - 2] + storage[i - 1]); // 둘 중 최댓값을 저장
        }
    }

    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        N = Integer.parseInt(s);
        mem = new int[N + 1];

        s = br.readLine();
        storage = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) throws IOException {
        new DP03();
    }
}
