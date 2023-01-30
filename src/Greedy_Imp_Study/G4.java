package Greedy_Imp_Study;

import java.util.Scanner;

public class G4 {
    //n, k 입력받기
    public static int n, k;

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        n = sc.nextInt();//입력받기
        k = sc.nextInt();
        int answer= 0;
        while(true){
            if(n==1) break;//n이 1이라면 반복문 탈출

            if(n%k==0){
                n/=k;
                answer++;
            } else {
                n -= 1;
                answer++;
            }// 시행후 결과값을 증가시킨후 바로 break를 걸어서 탈출시켜도 되나 굳이?

        }
        System.out.println(answer);// 결과는 정상적으로 출력되나 제약조건이 필요하진 않은지 여러가지 테스트 케이스를 만들어서\
       //시행해봤지만 문제는 없음..

    }
}
