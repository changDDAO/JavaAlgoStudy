package ShortestPath_Graph.ChangHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice2_Floyd {
    public static int [][] graph = new int[101][101];
    public static int n, m;
    public static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i],INF);
        } //graph 초기화
        //자기자신으로 가는거 0으로 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j)graph[i][j]=0;
            }
        }
        for (int i = 0; i < m; i++) {
            s = br.readLine();
            int []input = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = input[0];
            int b = input[1];
            graph[a][b]=1;
            graph[b][a]=1;//양방향성임

        }
        s = br.readLine();
        st = new StringTokenizer(s);
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
//impl FloydWarshall Algorithm
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][i]+graph[i][b]);
                }
            }
        }
        int answer = graph[1][k]+graph[k][x];
        if(answer >=INF) System.out.println(-1);
        else System.out.println(answer);




    }
}
