package BinarySearch_DynamicProgramming.ChangHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Practice3_DP {
    //dp로 해결할 경우 점화식을 세우는것이 상당히 중요하다.
    //bottomUp 방식으로 식량의 합을 누적해간다고 가정하면 홀수또는 짝수번째 index만 각각 합산이 가능하다.
    //
    private final int []dpTable = new int[100];
    private int[] foods;
    private int n;
    public Practice3_DP() throws IOException {
        input();
        bottomUp();
        System.out.println(dpTable[n-1]);
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        n = Integer.parseInt(s);
        s = br.readLine();
        //이거 좋다
        foods = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

    }
    public void bottomUp(){
        dpTable[0]=foods[0];
        dpTable[1]=Math.max(foods[0],foods[1]);
        for (int i = 2; i < n; i++) {
            dpTable[i]=Math.max(dpTable[i-1],dpTable[i-2]+foods[i]);//dpTable에 값을 계속 누적합하며 i번째까지 갱신
        }
    }

    public static void main(String[] args) throws IOException {
        new Practice3_DP();
    }



}
