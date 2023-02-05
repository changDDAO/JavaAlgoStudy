package Greedy_Imp_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Stream;

public class Greedy02 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] line = s.split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int K = Integer.parseInt(line[2]);

        s = br.readLine();
        line = s.split(" ");

        br.close();

        int[] input = Stream.of(line).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(input);

        int n1 = input[input.length - 1];
        int n2 = input[input.length - 2];

        int cnt = 0; // 전체 횟수
        int repeatCnt = 0; // 반복 횟수(K번 반복)
        int result = 0;

        while (true) {
            if (cnt == M)
                break;

            if (repeatCnt == K) {
                result += n2;
                cnt++;
                repeatCnt = 0;
                continue;
            }

            repeatCnt++;
            result += n1;
            cnt++;
        }

        System.out.println(result);
    }
}
