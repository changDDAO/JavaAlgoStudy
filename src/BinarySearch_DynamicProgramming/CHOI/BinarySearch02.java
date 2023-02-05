package BinarySearch_DynamicProgramming.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BinarySearch02 {
    private final int[] source;

    public BinarySearch02() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int N = Integer.parseInt(s);

        s = br.readLine();
        String[] line = s.split(" ");

        source = Stream.of(line).mapToInt(Integer::parseInt).toArray();

        s = br.readLine();
        int M = Integer.parseInt(s);
        int[] request;

        s = br.readLine();
        line = s.split(" ");

        request = Stream.of(line).mapToInt(Integer::parseInt).toArray();

        for (int tmp : request) {
            if (recursive(tmp, 0, request.length))
                System.out.print("yes ");
            else
                System.out.print("no ");
        }
    }

    public boolean recursive(int target, int start, int end) {
        if (start > end)
            return false;

        int mid = (start + end) / 2;

        if (source[mid] == target)
            return true;

        else if (source[mid] > target)
            return recursive(target, start, mid - 1);

        else
            return recursive(target, mid + 1, end);
    }

    public static void main(String[] args) throws IOException {
        new BinarySearch02();
    }
}
