package ShortestPath_Graph.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Graph03 {
    private int[] parent;
    private final ArrayList<Edge> edgeList = new ArrayList<>();

    private static class Edge {
        private final int nodeA, nodeB, cost;

        public Edge(int nodeA, int nodeB, int cost) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.cost = cost;
        }

        public int getNodeA() {
            return nodeA;
        }

        public int getNodeB() {
            return nodeB;
        }

        public int getCost() {
            return cost;
        }
    }

    public Graph03() throws IOException {
        init();
        run();
    }


    private void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] input = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = input[0];
        int M = input[1];

        parent = IntStream.rangeClosed(0, N).toArray(); // parent 배열 초기화

        for (int i = 0; i < M; i++) {
            s =  br.readLine();
            input = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

            edgeList.add(new Edge(input[0], input[1], input[2]));
        }

        edgeList.sort(Comparator.comparingInt(o -> o.cost));
    }

    private void run() {
        int sum = 0;
        int max = 0;

        for (Edge e : edgeList)
            if (findParent(e.getNodeA()) != findParent(e.getNodeB())) { // 사이클 발생 X 경우
                unionParent(e.getNodeA(), e.getNodeB());
                sum += e.getCost();
                max = e.getCost();
            }

        System.out.println(sum - max);
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
        new Graph03();
    }
}
