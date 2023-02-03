package DFS_BFS_Sort.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DBFS03 {
    private int N, M;
    private int[][] map; // 인접 행렬 사용 => 2차원 행렬 => 인접 리스트보다 빠른 접근

    public DBFS03() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] line = s.split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        map = new int[N][M];
        int result = 0;

        for (int i = 0; i < N; i++) {
            s = br.readLine();

            for (int j = 0; j < M; j++) {
                int tmp = s.charAt(j) - '0';
                map[i][j] = tmp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public boolean dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= M) // 좌표가 지도 밖을 넘어가는지 검사
            return false;

        if (map[x][y] != 0) // 방문한 좌표인지 검사
            return false;

        map[x][y] = 1;

        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x, y + 1);

        return true;
    }

    public static void main(String[] args) throws IOException {
        new DBFS03();
    }
}
