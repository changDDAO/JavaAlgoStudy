package Greedy_Imp_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class I3 {
    //1.맵 생성 입력받기
    //2. 반시계 방향으로 방향 설정하기 0 북쪽 3 서쪽 2 남쪽 1동쪽
    //3. 입력받은 맵에서 0은 육지이고 1은 바다이다.
    public static int [][] map = new int[50][50];// 맵초기화
    public static int [][] wentMap = new int[50][50];// 가본위치 표시
    public static int n, m, seeDir;//행과 열
    public static int[] dx = {-1,0,1,0};//북 서 남 동
    public static int[] dy = {0,-1,0,1};//북 서 남 동

    public static void turnLeft(){
        seeDir+=1;
        if(seeDir==4)
            seeDir=0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = br.readLine();
        st = new StringTokenizer(s);
        int x = Integer.parseInt(st.nextToken()); //행
        int y = Integer.parseInt(st.nextToken()); //열
        seeDir = Integer.parseInt(st.nextToken()); //보고있는 방향
        String [] input; //한줄을 입력받아 String 배열을 참조하기위한 변수 선언
        int [] tempLine; // int []을 참조하기 위한변수 (한줄)
        for(int i=0;i<n;i++){
            s=br.readLine();
            input = s.split(" ");
            tempLine= Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            map[i] = Arrays.copyOfRange(tempLine,0,m);//2차원배열 복사해주기
        }
        //처음 캐릭터가 지정되는 곳은 항상 육지이고 그곳은 항상 방문되므로 최솟값은 1
        //즉
        wentMap[x][y]=1;
        int answer=1, nx, ny,turnCnt =0;
        while (true) {
            turnLeft();
            nx = x+dx[seeDir];
            ny = y+dy[seeDir];
            //왼쪽으로 90도 회전 후 갈수있다면(육지이거나 방문한적이 없다면)
            if (wentMap[nx][ny] == 0 && map[nx][ny] == 0) {
                x = nx;
                y=ny;
                wentMap[nx][ny]=1;
                answer++;
                turnCnt =0;

            }else turnCnt++;// 방문한적이 있거나 바다라면 회전만 하기
            if (turnCnt == 4) { //back tracking 과정
                nx = x-dx[seeDir];
                ny = y-dy[seeDir];
                if (map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                }else break;//뒷면이 바다인 경우
                turnCnt=0;


            }

        }
        System.out.println(answer);


    }



}
