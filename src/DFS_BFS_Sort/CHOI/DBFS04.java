package DFS_BFS_Sort.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.LinkedList;
import java.util.Queue;

public class DBFS04 {
    private int N, M;
    private int[][] map; // 인접 행렬 사용 => 2차원 행렬 => 인접 리스트보다 빠른 접근

    // 한 번에 한 칸 이동
    private int[] dx = {-1, 0, 0, 1};
    private int[] dy = {0, -1, 1, 0};

    public DBFS04() throws IOException {
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

        bfs(0, 0);
        System.out.println(map[N - 1][M - 1]);
    }

    public void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y}); // 좌표 배열 큐에 넣기

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            x = tmp[0];
            y = tmp[1];

            // 한 지점에서 상, 하, 좌, 우로 좌표 이동하려면..?
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i]; // 다음 좌표 구하기
                int nextY = y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) // 다음 좌표가 지도 범위를 벗어나는 경우
                    continue;

                if (map[nextX][nextY] == 1) { // 다음 좌표가 방문하지 않은 좌표일 경우
                    q.offer(new int[]{nextX, nextY}); // 좌표 추가
                    map[nextX][nextY] = map[x][y] + 1; // 다음 좌표에 해당하는 값을 이전 거리 값 + 1
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new DBFS04();
    }
}
