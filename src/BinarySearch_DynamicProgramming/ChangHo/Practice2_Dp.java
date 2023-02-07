package BinarySearch_DynamicProgramming.ChangHo;

import java.util.Scanner;

public class Practice2_Dp {
    int n;//입력받는 수 n, dpTable 갱신하는 변수x
    int[] dpTable = new int[30001];
    public void input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
    }
    public void makeOne(int n){//dpTable에 연산횟수를 담는다 bottomUp방식으로
        for(int i=2;i<=n;i++){
            dpTable[i]=dpTable[i-1]+1;//x에서 1을 빼는경우

            if(i%2==0) dpTable[i]=Math.min(dpTable[i],dpTable[i/2]+1);
            if(i%3==0) dpTable[i]=Math.min(dpTable[i],dpTable[i/3]+1);
            if(i%5==0) dpTable[i]=Math.min(dpTable[i],dpTable[i/5]+1);
        }
        System.out.println(dpTable[n]);

    }
    public Practice2_Dp(){
        input();
        makeOne(n);
    }

    public static void main(String[] args) {
        new Practice2_Dp();
    }


}
