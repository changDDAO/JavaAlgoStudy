package Greedy_Imp_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2 {
    public static int n, m ,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        //n, m, k 입력받기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        long start = System.currentTimeMillis();

        s = br.readLine();
        String [] temp = s.split(" ");
        int []inputNums = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(inputNums);
        int bst = inputNums[inputNums.length-1];
        int second = inputNums[inputNums.length-2];

        //n의 수중 가장 큰값을 k번 더한후 한번 두번쨰로 큰수 더하기
        // m만큼 수행한 후 더해진 값 출력
        int answer =0;
      while(true){
          for(int i =0;i<k;i++){
              if(m==0) break;
              answer+=bst;
              m-=1;// 숫자 하나더해질때마다 m 1감소 시키기
          }
          if(m==0)break;
          answer+=second;//가장 큰수 k번 돈후 2번째 값 한번 더하기
          m-=1;
      }
        System.out.println(answer);
        long end = System.currentTimeMillis();
        System.out.println(end-start);


    }
}
