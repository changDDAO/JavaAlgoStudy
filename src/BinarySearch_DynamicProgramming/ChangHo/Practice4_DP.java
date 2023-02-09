package BinarySearch_DynamicProgramming.ChangHo;

import java.util.Scanner;

public class Practice4_DP {
    //타일링 문제 dpTable의 경우 항상 점화식을 생각하자.
    //i-1번째까지 타일이 채워져있을 때 가능한 경우의 수는 1가지 (2x1 타일사용)
    //i-2번째까지 타일이 채워져있을 때 채울수있는 타일 2가지 (2X2, 1x2(2개))
    private final int []dpTable = new int[1001];
    int n;
    public Practice4_DP(){
        input();
        bottomUp();
        System.out.println(dpTable[n]);
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
    }
    public void bottomUp(){
        dpTable[1] =1;
        dpTable[2]=3;

        for (int i = 3; i <= n; i++) {
            dpTable[i]=(dpTable[i-1]+dpTable[i-2]*2)%796796;
        }
    }

    public static void main(String[] args) {
        new Practice4_DP();
    }
}
