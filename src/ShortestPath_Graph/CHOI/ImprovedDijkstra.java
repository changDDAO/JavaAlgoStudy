package ShortestPath_Graph.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class ImprovedDijkstra {
    private class Node implements Comparable<Node> {
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

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    private int N, M, start;
    private final int INF = Integer.MAX_VALUE;
    private int[] distance = new int[100001];
    private ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public ImprovedDijkstra() throws IOException {
        init();
        run(start);

        for (int i = 1; i <= N; i++) {
            if (distance[i] == INF)
                System.out.println("INFINITY");
            else
                System.out.println(distance[i]);
        }
    }

    private void init() throws IOException {
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

    private void run(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        distance[start] = 0;

        int now;
        int cost;
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            now = node.getIdx();
            cost = node.getDistance();

            if (distance[now] < cost)
                continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int tmp = distance[now] + graph.get(now).get(i).getDistance();

                if (distance[graph.get(now).get(i).getIdx()] > tmp) {
                    distance[graph.get(now).get(i).getIdx()] = tmp;
                    pq.offer(new Node(graph.get(now).get(i).getIdx(), tmp));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new ImprovedDijkstra();
    }
}

