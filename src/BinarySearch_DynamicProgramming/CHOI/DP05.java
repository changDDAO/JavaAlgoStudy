package BinarySearch_DynamicProgramming.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DP05 {
    private final int INF = Integer.MAX_VALUE;
    private int[] mem; // 금액에 해당하는 최소 경우의 수
    private int[] wallet; // 가지고 있는 화폐
    private int N, M;


    public DP05() throws IOException {
        init();
        run();
        if (mem[M] == INF)
            System.out.println(mem[M]);
        else
            System.out.println(-1);
    }

    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] line = s.split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        mem = new int[M + 1];
        wallet = new int[N];

        Arrays.fill(mem, INF);

        int pos;

        mem[0] = 0;

        for (int i = 0; i < N; i++) {
            s = br.readLine();
            pos = Integer.parseInt(s);
            wallet[i] = pos;
        }
    }

    /*
        입력받은 화폐 중 작은 값부터(바텀업) 배열에 해당 인덱스에 필요한 최소한의 화폐 수 할당
        메모리 배열의 인덱스 넘버링은 금액을 의미
        [해당 금액에 - 입력된 화폐]가 해당하는 배열의 인덱스(금액)는 해당 화폐가 사용될 수 있음을 의미
        반복문을 돌면서 특정 금액에 연속으로 입력될 수 있음 -> 금액이 커질수록 최소값이 들어가게 min 연산을 수행
     */
    public void run() {
        for (int pos : wallet) {
            for (int j = pos; j < mem.length; j++) {
                if (mem[j - pos] != INF) // 현재 화폐를 사용할 수 있는 가장 근접한 금액을 만들 수 있는지 확인
                    mem[j] = Math.min(mem[j], mem[j - pos] + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new DP05();
    }
}
