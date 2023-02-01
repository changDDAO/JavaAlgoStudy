package Greedy_Imp_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Iex4_2 {
    public static boolean contain3(int h, int m, int s) {
        //24, 60, 60
        //각 24시 60 분 60분 기준으로 각자릿수마다 3이 포함되어있는지 확인
        //ex) 23시 33분 33초라고 예를 들면 시간의 경우 24시까지 가능하므로 첫번째 3 check 의미가없음
        //각 시 분 초 에서 /10은 첫번째 자릿수의 3을 check %10은 두번째 자릿수의 3을 check
        return h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        int answer =0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<60;j++){
                for(int k= 0;k<60;k++){
                    if(contain3(i,j,k)) answer++;
                }
            }
        }
        System.out.println(answer);


    }
}

