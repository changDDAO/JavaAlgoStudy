package ShortestPath_Graph.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;



public class Dijkstra {
    private class Node {
        private int idx; // 목적지
        private int distance; // 비용

        public Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        public int getIdx() {
            return idx;
        }

        public int getDistance() {
            return distance;
        }
    }

    private int N, M, start;
    private final int INF = Integer.MAX_VALUE;
    private int[] distance = new int[100001];
    private boolean[] visited = new boolean[100001];
    private ArrayList<ArrayList<Node>> graph;

    public Dijkstra() throws IOException {

        init();
        run(start);

        for (int i = 1; i <= N; i++) {
            if (distance[i] == INF)
                System.out.println("INFINITY");

            System.out.println(distance[i]);
        }
    }

    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] input = s.split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        s = br.readLine();
        start = Integer.parseInt(s);

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }

        int[] line;
        for (int i = 0; i < M; i++) {
            s = br.readLine();
            line = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

            graph.get(line[0]).add(new Node(line[1], line[2]));
        }

        Arrays.fill(distance, INF);
    }

    public void run(int start) {
        distance[start] = 0;
        visited[start] = true;

        // 각 노드까지의 거리(비용) 저장
        for (int i = 0; i < graph.get(start).size(); i++) {
            Node next = graph.get(start).get(i); // 연결된 다음 노드
            distance[next.getIdx()] = next.getDistance(); // 비용 저장
        }

        int now;
        int cost;
        for (int i = 0; i < N - 1; i++) {
            now = getSmallNode();
            visited[now] = true;

            for (int j = 0; j < graph.get(now).size(); j++) {
                Node next = graph.get(now).get(j);
                cost = distance[now] + next.getDistance();

                if (cost < distance[next.getIdx()]) // 비용 갱신
                    distance[next.getIdx()] = cost;
            }
        }
    }

    public int getSmallNode() { // 가장 가까운 노드 찾기
        int min = INF;
        int idx = 0;

        for (int i = 1; i <= N; i++) {
            if (distance[i] < min && !visited[i]) { // 방문하지 않은 노드 중 제일 적은 거리(비용)을 가진 노드 찾기
                min = distance[i];
                idx = i;
            }
        }

        return idx;
    }

    public static void main(String[] args) throws IOException {
        new Dijkstra();
    }
}
