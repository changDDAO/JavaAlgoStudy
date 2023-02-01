package Greedy_Imp_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class reSolveI3 {
    public static int [][] map = new int[50][50];
    public static int[][] checkMap = new int[50][50];
    public static int n, m, d;
    //0 북 1 동 2 남 3서
    public static int []dx = {-1,0,1,0}; //북 동 남 서
    public static int []dy = {0,1,0,-1};

    public static void turnLeft() {
        d-=1;
        if(d== -1) d =3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s =br.readLine();
        st = new StringTokenizer(s);//2번째 줄 입력받은 후 자르기
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        d =Integer.parseInt(st.nextToken());
        String []line;
        int []iLine;
        for (int i = 0; i < n; i++) {
            s=br.readLine();
            line=s.split(" ");
            iLine= Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
            map[i]=Arrays.copyOfRange(iLine,0,m);
        }//맵초기화
        checkMap[x][y]=1; //초기 캐릭터가 서있는 위치 방문처리
        int nx, ny, turnCnt=0,visited=1;
        while (true) {
            turnLeft();
            nx = x+dx[d];
            ny = y+dy[d];
            if (checkMap[nx][ny] == 0 && map[nx][ny] == 0) {
                checkMap[nx][ny]=1;//방문처리하고
                x = nx;
                y = ny;
                visited++;
                turnCnt=0;
                continue;
            }else turnCnt++;

            if (turnCnt == 4) {
                nx = x -dx[d];//사방이 갔던곳이었거나 바다라면 뒤로 돌아가기
                ny = y -dy[d];
                if(map[nx][ny]==1) break;
                x = nx;
                y = ny;
                turnCnt=0;
            }

        }
        System.out.println(visited);




    }


}
