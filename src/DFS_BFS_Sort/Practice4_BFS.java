package DFS_BFS_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice4_BFS {
    public static class curPos {
        int x;
        int y;

        public curPos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    public static int n, m;
    public static int[][] graph = new int[200][200];
    public static int []dx = {1,-1,0,0}; //네가지 방향 정의
    public static int []dy = {0,0,-1,1};
    public static int bfs(int x, int y) {
        Queue<curPos> queue = new LinkedList<>();
        queue.add(new curPos(x,y));
        curPos curpos;
        int a,b, nx, ny ;
        while (!queue.isEmpty()) {
            curpos= queue.poll();
            a = curpos.getX();
            b = curpos.getY();

            for (int i = 0; i < 4; i++) {
                nx = a+dx[i];
                ny = b+dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; //범위를 벗어나는 경우, 건너뛰기
                if (graph[nx][ny] == 1) {
                    graph[nx][ny]=graph[a][b]+1;
                    queue.add(new curPos(nx,ny));
                }

            }
        }
        return graph[n-1][m-1]; //문제에서 입력예시로 주어지는게 모두 다 연결돼있음 bfs 탐색을 하면 최종목적지에 이동거리 최솟값으로 갱신됨

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        String []temp;
        int []line;
        for (int i = 0; i < n; i++) {//graph 값 입력받아 초기화 해주기
            s=br.readLine();
            temp = s.split("");
            line = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
            graph[i] = Arrays.copyOfRange(line,0,m);
        }
        int answer = bfs(0,0);
        System.out.println(answer);


    }


}
