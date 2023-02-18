package ShortestPath_Graph.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class ShortestPath02 {
    private final int INF = (int) 1e9;
    private int N, M, X, K;
    private int[][] graph = new int[101][101];

    public ShortestPath02() throws IOException {
        init();
        run();

        int result = graph[1][K] + graph[K][X]; // 1 -> K -> X

        if (result >= INF)
            System.out.println(-1);
        else
            System.out.println(result);
    }

    private void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] input = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        N = input[0];
        M = input[1];

        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                    break;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            s = br.readLine();
            input = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

            // 양방향
            graph[input[0]][input[1]] = 1;
            graph[input[1]][input[0]] = 1;
        }

        s = br.readLine();
        input = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        X = input[0];
        K = input[1];
    }

    private void run() {
        for (int a = 1; a <= N; a++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][a] + graph[a][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new ShortestPath02();
    }
}
