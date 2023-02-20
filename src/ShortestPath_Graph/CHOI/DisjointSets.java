package ShortestPath_Graph.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DisjointSets {
    private int V;
    private int[] parent;
    public DisjointSets() throws IOException {
        init();
        print();
    }

    private void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] input = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        V = input[0];
        int E = input[1];

        parent = IntStream.range(0, V + 1).toArray(); // 배열 초기화

        for (int i = 0; i < E; i++) {
            s = br.readLine();
            input = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            
            unionParent(input[0], input[1]);
        }
    }

    private void print() {
        System.out.print("각 원소가 속한 집합11 : ");
        for (int i = 1; i < V + 1; i++) {
            System.out.print(findParent(i)+" ");
        }

        System.out.println();

        System.out.print("부모 테이블 : ");
        IntStream.range(1, V + 1)
                .forEach(i -> {
                    int cur = parent[i];
                    System.out.print(cur + " ");
                });

        System.out.println("\n");
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
        new DisjointSets();
    }
}
