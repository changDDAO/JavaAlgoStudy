package BinarySearch_DynamicProgramming.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class BinarySearch03 {
    private int[] arr;
    int target;

    ArrayList<Integer> list;

    /*
        4 6
        19 14 8 17
     */

    public BinarySearch03() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] line = s.split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        arr = new int[N];

        s = br.readLine();
        line = s.split(" ");

        arr = Stream.of(line).mapToInt(Integer::parseInt).toArray();

        target = Collections.max(list);
    }

    public void recursive(int start, int end) {
        int mid = (start - end) / 2;




    }



    public static void main(String[] args) throws IOException {
        new BinarySearch03();
    }
}
