package Greedy_Imp_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Iex4_1 {
    public static char[] dir = {'L', 'R', 'U', 'D'};
    public static int n;
    public static int[] dx = {0, 0, -1, 1};//y축 방향
    public static int[] dy = {-1, 1, 0, 0};//x축 방향
    public static int x = 1, y = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        n = Integer.parseInt(s);
        s = br.readLine();
        String[] temp = s.split(" ");//공백제거후
       char [] inputDir = new char[temp.length];
       for(int i= 0;i< temp.length;i++){
           inputDir[i]=temp[i].charAt(0);
       }//String 배열을 char배열로 전환
       int nx =0,ny =0;
        for (int i = 0; i < inputDir.length; i++) {
            // 전체 입력된 방향수만큼 루프를 돌면서
            for(int j = 0; j<dir.length;j++){
                if (dir[j] == inputDir[i]) {//입력된 문자와 정의된 방향 문자가 일치하다면
                    nx = x+dx[j];
                    ny = y+dy[j];
                }
                if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
                    x = nx;
                    y = ny;
                }
            }
        }
        System.out.println(x+" "+y);

    }
}
