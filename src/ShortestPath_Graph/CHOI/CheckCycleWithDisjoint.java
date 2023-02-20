package ShortestPath_Graph.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CheckCycleWithDisjoint {
    private int[] parent;
    private boolean isCycle;

    public CheckCycleWithDisjoint() throws IOException {
        init();
        print();
    }


    private void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] input = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        int V = input[0];
        int E = input[1];
        isCycle = false;

        parent = IntStream.rangeClosed(0, V).toArray();

        for (int i = 0; i < E; i++) {
            s = br.readLine();
            input = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

            int a = input[0];
            int b = input[1];


            if (findParent(a) == findParent(b)) {
                isCycle = true;
                break;
            }

            unionParent(a, b);
        }
    }

    private void print() {
        if (isCycle)
            System.out.println("사이클 발생");
        else
            System.out.println("사이클 없음");
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

        // 루트 노드가 아니면 찾을 때까지 진행
//         return  findParent(parent[x]); // 기본 버전 : 거슬러 올라가면서 찾음 => O(V) 만큼의 시간 소요
        return parent[x] = findParent(parent[x]);  // 향상된 버전 : 경로 압축
    }

    public static void main(String[] args) throws IOException {
        new CheckCycleWithDisjoint();
    }
}
