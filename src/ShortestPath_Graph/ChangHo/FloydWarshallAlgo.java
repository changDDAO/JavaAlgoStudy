package ShortestPath_Graph.ChangHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FloydWarshallAlgo {
    public static int n, m;
    public static int [][]graph = new int[501][501];
    public static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br. readLine();
        n = Integer.parseInt(s);
        s= br.readLine();
        m = Integer.parseInt(s);
        //graph 초기화 먼저
        for(int i =0;i<501;i++) Arrays.fill(graph[i],INF);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j)graph[i][j] = 0;//자기 자신으로 가는건 0으로 초기화
            }
        }
        for (int i = 0; i < m; i++) {
            s = br.readLine();
            int []input =Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = input[0];
            int b = input[1];
            int c = input[2];
            graph[a][b]=c;
        }
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b],graph[a][i]+graph[i][b]);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(graph[i][j]!=INF)
                System.out.print(graph[i][j]+" ");
                else System.out.println("INF");
            }
            System.out.println();
        }
    }

}
