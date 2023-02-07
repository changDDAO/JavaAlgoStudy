package BinarySearch_DynamicProgramming.ChangHo;

import java.util.Scanner;

public class BottomUpFibo {
    int n;
    long []dpTable = new long[101];
    public void input(){
        System.out.println("몇번째 항의 피보나치 값을 원하는지 입력하시오.(100이하의 수 가능)");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
    }
    public void bottomUpFibo(int n){
        dpTable[1]=1;
        dpTable[2]=1;
        for (int i = 3; i <= n; i++) {
            dpTable[i]= dpTable[i-1]+dpTable[i-2];
        }
        long answer = dpTable[n];
        System.out.println(answer);
    }
    public BottomUpFibo(){
        input();
        bottomUpFibo(n);
    }

    public static void main(String[] args) {
        new BottomUpFibo();
    }
}
