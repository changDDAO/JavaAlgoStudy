package BinarySearch_DynamicProgramming.ChangHo;

public class TopBottomDP {
    public static long []dpTable = new long[101];

    public static long fibo(int x){
        if(x==1||x==2)
            return 1;
        if(dpTable[x]!=0)
            return dpTable[x];
        else{
            dpTable[x]=fibo(x-1)+fibo(x-2);
            return dpTable[x];
        }

    }


    public static void main(String[] args) {
        System.out.println(fibo(100));
    }
}
