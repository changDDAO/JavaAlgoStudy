package DFS_BFS_Sort.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Sort04 {
    private int K;
    private ArrayList<Integer> arr1 = new ArrayList<>();
    private ArrayList<Integer> arr2 = new ArrayList<>();

    public Sort04() throws IOException {
        init();
        for (int i = 0; i < K; i++) {
            sorting();
            swap();
        }

        int result = 0;

        for (int i : arr1) {
            result += i;
        }

        System.out.println(result);
    }

    public void swap() { // 바꿔치기 스왑
        int tmp = arr1.get(0);
        arr1.set(0, arr2.get(0));
        arr2.set(0, tmp);
    }

    public void sorting() {
        arr1.sort(new Comparator<Integer>() { // A 배열 오름차순으로 정렬
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        arr2.sort(new Comparator<Integer>() { // B 배열 내림차순으로 정렬
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
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
    }

    public static void main(String[] args) throws IOException {
        new Sort04();
    }
}
