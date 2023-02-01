package Greedy_Imp_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Greedy02 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] form = s.split(" ");

        int N = Integer.parseInt(form[0]);
        int M = Integer.parseInt(form[1]);
        int K = Integer.parseInt(form[2]);
        System.out.println(N);
        System.out.println(M);
        System.out.println(K);

        s = br.readLine();
        String[] inputs = s.split(" ");
        LinkedList<Integer> input = new LinkedList<>();

        for (String pos : inputs) {
            input.add(Integer.parseInt(pos));
            System.out.println(pos);
            System.out.println(input);
        }

        input.sort(Collections.reverseOrder());

        int first = input.get(0);
        int second = input.get(1);
        int cnt = 0;
        int repeatCnt = 0;
        int result = 0;

        while (true)
        {
            while (true)
            {
                if (repeatCnt == K) {
                    repeatCnt = 0;
                    break;
                }

                if (cnt == M) {
                    break;
                }

                result += first;
                repeatCnt++;
                cnt++;
            }

            if (cnt == M) {
                break;
            }

            result += second;
            cnt++;
        }

        System.out.println(result);

    }
}
