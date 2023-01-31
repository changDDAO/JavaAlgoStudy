package Greedy_Imp_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I2 {
    //1.문자열로 입력받기
    //2. 문자잘라서 첫번째문자는 열 2번째 문자는 행
    //3. 그지점으로부터 정의해둔 방향 check 후 이동 가능할때 cnt++
    public static int []dx={-2,2,-2,2,-1,1,-1,1};//왼1위2,왼1아래2,우1위2,우1아래2,왼2위1,왼2아래1,우2위1,우2아래1
    public static int []dy={-1,-1,1,1,-2,-2,2,2};

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String []temp = s.split("");
        int y = (temp[0].charAt(0)-'a')-1;//열의 문자를 int형으로 변환
        int x = Integer.parseInt(temp[1])-1;
        //정의해둔 이동가능한 수 만큼 돌면서 가능하면 cnt ++
        int answer =0;
        int nx, ny;
        for (int i = 0; i < 8; i++) {
            nx =x+dx[i];
            ny = y+dy[i];
            if(nx>=0&&ny>=0&&nx<8&&ny<8) answer++;
        }
        System.out.println(answer);
    }
}
