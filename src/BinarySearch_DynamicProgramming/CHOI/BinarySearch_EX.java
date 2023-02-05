package BinarySearch_DynamicProgramming.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BinarySearch_EX {
    private int[] arr;
    private final int target;
    public BinarySearch_EX() throws IOException {
        // 배열 내 target 값의 인덱스 번호를 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] line = s.split(" ");
        int[] input = Stream.of(line).mapToInt(Integer::parseInt).toArray();

        arr = new int[input[0]];
        target = input[1];

        s = br.readLine();
        line = s.split(" ");
        arr = Stream.of(line).mapToInt(Integer::parseInt).toArray();

        System.out.println("recursive 결과 = " + recursive(0, arr.length));
        System.out.println("iterative 결과 = " + iterative(0, arr.length));
    }

    public int recursive(int start, int end) { // 재귀
        if (start > end) // 찾지 못하는 경우
            return -1;

        int mid = (start + end) / 2;

        // 항상 미드 값을 타겟 값과 검사
        // 조건 1
        // 미드 값 == 타겟 값
        // 조건 2
        // 미드 값 > 타겟 값
        // 조건 3
        // 미드 값 < 타겟 값

        if (arr[mid] == target) // 배열 내 중간 값이 타겟 값일 경우
            return mid;

        else if (arr[mid] > target) // 배열 내 중간 값이 타겟 값보다 클 경우
            return recursive(start, mid - 1);

        else // 배열 내 중간 값이 타겟 값보다 작을 경우
            return recursive(mid + 1, end);
    }

    public int iterative(int start, int end) { // 반복문
        int mid;

        while (true) {
            if (start > end)
                break;

            mid = (start + end) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] > target)
                end = mid - 1;

            if (arr[mid] < target)
                start = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        new BinarySearch_EX();
    }
}
