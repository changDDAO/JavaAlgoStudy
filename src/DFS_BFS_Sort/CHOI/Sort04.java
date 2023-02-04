package DFS_BFS_Sort.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Sort04 {
    private int K;
    private final ArrayList<Integer> arr1 = new ArrayList<>();
    private final ArrayList<Integer> arr2 = new ArrayList<>();

    public Sort04() throws IOException {
        init();
        sorting();

        for (int i = 0; i < K; i++) {
            if (arr1.get(i) < arr2.get(i))
                swap(i);
        }

        int result = 0;

        for (int i : arr1)
            result += i;

        System.out.println(result);
    }

    public void swap(int pos) { // 바꿔치기 스왑
        int tmp = arr1.get(pos);
        arr1.set(pos, arr2.get(pos));
        arr2.set(pos, tmp);
    }

    public void sorting() {
        arr1.sort(Comparator.comparingInt(o -> o));
        arr2.sort((o1, o2) -> o2 - o1);
    }

    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        String[] input;

        s = br.readLine();
        input = s.split(" ");

        int N = Integer.parseInt(input[0]); // 배열 내 원소 갯수
        K = Integer.parseInt(input[1]); // 최대 바꿔치기 연산 횟수

        s = br.readLine();
        input = s.split(" ");

        for (String t : input)
            arr1.add(Integer.parseInt(t));

        s = br.readLine();
        input = s.split(" ");

        for (String t : input)
            arr2.add(Integer.parseInt(t));

        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Sort04();
    }
}
