package ShortestPath_Graph.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Graph02 {
    private final int[] parent;

    public Graph02() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] input = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = input[0];
        int M = input[1];

        parent = IntStream.rangeClosed(0, N).toArray(); // parent 배열 초기화

        for (int i = 0; i < M; i++) {
            s = br.readLine();
            input = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

            int oper = input[0];
            int a = input[1];
            int b = input[2];

            if (oper == 0)
                unionParent(a, b);

            if (oper == 1) {
                if (findParent(a) == findParent(b))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }

    private void unionParent(int a, int b) { // 합집합
        a = findParent(a);
        b = findParent(b);

        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    private int findParent(int x) { // 루트 노드 찾기
        if (parent[x] == x) // 재귀 탈출 : 루트 노드일 경우 반환
            return x;

        return parent[x] = findParent(parent[x]);  // 향상된 버전 : 경로 압축
    }

    public static void main(String[] args) throws IOException {
        new Graph02();
    }
}
