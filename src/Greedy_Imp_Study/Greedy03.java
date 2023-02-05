package Greedy_Imp_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Greedy03 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] form = s.split(" ");

        int N  = Integer.parseInt(form[0]);
        int M  = Integer.parseInt(form[1]);

        String[] inputs;

        LinkedList<Integer> tmp = new LinkedList<>();
        LinkedList<Integer> lastList = new LinkedList<>();

        for (int i = 0; i < N; i++)
        {
            s = br.readLine();
            inputs = s.split(" ");

            for (String pos : inputs)
                tmp.add(Integer.parseInt(pos));

            Collections.sort(tmp);
            lastList.add(tmp.getFirst());
            tmp.clear();
        }

        br.close();

        lastList.sort(Collections.reverseOrder());

        System.out.println(lastList.getFirst());
    }
}
