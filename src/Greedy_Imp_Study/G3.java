package Greedy_Imp_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G3 {
    public static int n, m; //행 열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String [] temp = s.split(" ");
        int [] input = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
        n = input[0];// n, m 입력받기
        m = input[1];
        int [][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            s= br.readLine();
            temp = s.split(" ");
            input = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
            arr[i]=Arrays.copyOfRange(input,0, m);
        }//입력받아 배열만들기
        int answer = 0;
        int []compareLine;
        for(int i=0;i<n;i++){
            compareLine = Arrays.copyOfRange(arr[i],0,m);
            Arrays.sort(compareLine);//가장작은 수를 뽑기위해 배열 정렬
            int minValue = compareLine[0];
            answer = Math.max(answer,minValue);
        }
        System.out.println(answer);



    }

}
