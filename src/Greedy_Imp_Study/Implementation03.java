package Greedy_Imp_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Implementation03 {
    final String[] direction = {"북", "동", "남", "서"};
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

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        String s = br.readLine();
        String[] line = s.split(" ");

        maxX = Integer.parseInt(line[0]);
        maxY = Integer.parseInt(line[1]);

        visited = new int[maxX][maxY];

        s = br.readLine();
        line = s.split(" ");
        userX = Integer.parseInt(line[0]);
        userY = Integer.parseInt(line[1]);
        userDir = Integer.parseInt(line[2]);

        map = new int[maxY][maxX];

        for (int i = 0; i < maxY; i++) {
            s = br.readLine();
            line = s.split(" ");

            for (int j = 0; j < maxX; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        int seaCnt = 0;
        int cnt = 1;
        visited[userY][userX] = 1;

        while (true) {
            System.out.println("현재 위치 : " + userX + ", " + userY);
            System.out.println("현재 방향 : " + direction[userDir]);
            System.out.print(direction[userDir] + " -> ");
            turnLeft();
            System.out.println(direction[userDir]);
            System.out.println("다음 방향 : " + direction[userDir]);

            nextX = userX + dx[userDir];
            nextY = userY + dy[userDir];
//            userX += dx[userDirection];
//            userY += dy[userDirection];
            System.out.println("다음 위치 : " + userX + ", " + userY);
            System.out.println();

            if (visited[nextY][nextX] == 0 && map[nextY][nextX] == 0) {
                cnt++;
                userX = nextX;
                userY = nextY;
                visited[userY][userX] = 1;
                System.out.println("이동가능! 현재 위치 " + userX + ", " + userY);
                System.out.println("갯수 : " + cnt);
                System.out.println();
//                turnRight();
                seaCnt = 0;
                continue;
            } else {
                seaCnt++;
                System.out.println("벽 발견! SEA COUNT : " + seaCnt);
                System.out.println("이동 불가! 현재 위치 " + userX + ", " + userY);
                System.out.println();
//                userX -= dx[userDirection];
//                userY -= dy[userDirection];
            }

            if (seaCnt == 4) {
                System.out.println("사방이 벽! 현재 위치 " + userX + ", " + userY);
                nextX = userX - dx[userDir];
                nextY = userY - dy[userDir];
//                userX -= dx[userDirection];
//                userY -= dy[userDirection];
                System.out.println();

                if (map[nextY][nextX] == 1) {
                    break;
                }
                else {
                    userX = nextX;
                    userY = nextY;
                    System.out.println("되돌아 가기! 현재 위치 " + userX + ", " + userY);
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

    public void turnRight() {
        userDir += 1;

        if (userDir == 4)
            userDir = 0;
    }

    public static void main(String[] args) throws IOException {
        new Implementation03();
    }
}
