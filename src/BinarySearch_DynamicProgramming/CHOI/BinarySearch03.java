package BinarySearch_DynamicProgramming.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
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

        list = (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());

        target = Collections.max(list); // 가장 긴 길이를 기준으로

        System.out.println(binarySearch(0, target, M));
    }

    public int binarySearch(int start, int end, int M) {
        int mid;
        int sum; // 남은 길이 총 합
        int record = 0;

        while (true) {
            if (start > end)
                break;

            mid = (start + end) / 2;

            sum = calLength(mid);

            if (sum < M) { // 남은 길이의 합이 목표 값보다 작으면
                end = mid - 1; // 이진 탐색을 좌측 구간 실행
            }
            else {
                record = mid; // mid 값을 저장
                start = mid + 1; // 이진 탐색 우측 구간 실행
            }
        }

        return record;
    }

    public int calLength(int mid) { // 남은 길이 총 합 구하기
        int result = 0;

        for (int tmp : arr) {
            int n = tmp - mid;

            if (n > 0) {
                result += n;
            }
        }

        return result;
    }



    public static void main(String[] args) throws IOException {
        new BinarySearch03();
    }
}
