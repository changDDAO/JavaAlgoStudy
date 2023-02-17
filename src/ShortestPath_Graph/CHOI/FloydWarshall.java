package ShortestPath_Graph.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class FloydWarshall {
    private final int INF = (int)1e9;
    private int N, M;
    private int[][] graph = new int[501][501];

    public FloydWarshall() throws IOException {
        init();
        run();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] == INF)
                    System.out.print("INFINITY");
                else
                    System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        N = Integer.parseInt(s);

        s = br.readLine();
        M = Integer.parseInt(s);

        for (int i = 0; i < 501; i++) {
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
            int[] line = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

            graph[line[0]][line[1]] = line[2];
        }
    }

    private void run() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    // 바로가는 비용 vs 돌아서 가는 비용
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new FloydWarshall();
    }
}
