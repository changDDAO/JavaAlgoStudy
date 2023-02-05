package Greedy_Imp_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Implementation03 {
    final int maxX;
    final int maxY;
    private int userX;
    private int userY;
    private int userDir;
    private int nextX = 0;
    private int nextY = 0;
    private int[][] map;
    private int[][] visited;

    public Implementation03() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
            현재 0(북) 이면
            위로(y => -1)
            1(동) 이면
            오른쪽(x => 1)
         */

        // {북, 동, 남, 서} 방향 이동
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        String s = br.readLine();
        String[] line = s.split(" ");

        maxX = Integer.parseInt(line[0]);
        maxY = Integer.parseInt(line[1]);

        visited = new int[maxY][maxX];

        s = br.readLine();
        line = s.split(" ");

        userX = Integer.parseInt(line[0]);
        userY = Integer.parseInt(line[1]);
        userDir = Integer.parseInt(line[2]);

        map = new int[maxY][maxX];

        // 지도 생성
        for (int i = 0; i < maxY; i++) {
            s = br.readLine();
            line = s.split(" ");

            for (int j = 0; j < maxX; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        br.close();

        int seaCnt = 0;
        int cnt = 1;
        visited[userY][userX] = 1;

        while (true) {
            turnLeft();

            nextX = userX + dx[userDir];
            nextY = userY + dy[userDir];

            if (visited[nextY][nextX] == 0 && map[nextY][nextX] == 0) {
                cnt++;
                userX = nextX;
                userY = nextY;
                visited[userY][userX] = 1;
                seaCnt = 0;
                continue;
            } else {
                seaCnt++;
            }

            if (seaCnt == 4) {
                nextX = userX - dx[userDir];
                nextY = userY - dy[userDir];

                if (map[nextY][nextX] == 1) {
                    break;
                }
                else {
                    userX = nextX;
                    userY = nextY;
                }
                seaCnt = 0;
            }
        }
        System.out.println(cnt);
    }

    public void turnLeft() {
        userDir -= 1;

        if (userDir == -1)
            userDir = 3;
    }

    public static void main(String[] args) throws IOException {
        new Implementation03();
    }
}
