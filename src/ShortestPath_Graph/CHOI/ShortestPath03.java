package ShortestPath_Graph.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class ShortestPath03 {
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

    private final int INF = (int) 1e9;
    private int N, M, C;
    private int[] distance = new int[30001];
    private ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public ShortestPath03() throws IOException {
        init();
        run(C);

        int cityCnt = 0; // 도시 수
        int maxDistance = 0; // 최대 거리 값

        for (int i = 1; i <= N; i++) {
            if (distance[i] != INF) {
                cityCnt++;
                maxDistance = Math.max(maxDistance, distance[i]);
            }
        }

        System.out.println((cityCnt - 1) + " " + maxDistance);
    }

    private void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] input = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        N = input[0];
        M = input[1];
        C = input[2];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        Arrays.fill(distance, INF);

        for (int i = 0; i < M; i++) {
            s = br.readLine();
            input = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

            graph.get(input[0]).add(new Node(input[1], input[2]));
        }
    }

    private void run(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curDistance = node.getDistance();
            int curIdx = node.getIdx();

            // 최단 거리가 아닐경우 패스
            if (distance[curIdx] < curDistance) {
                continue;
            }

            for (int i = 0; i < graph.get(curIdx).size(); i++) {
                int cost = distance[curIdx] + graph.get(curIdx).get(i).getDistance();

                if (cost < distance[graph.get(curIdx).get(i).getIdx()]) { // 최단 거리 갱신
                    distance[graph.get(curIdx).get(i).getIdx()] = cost;
                    pq.offer(new Node(graph.get(curIdx).get(i).getIdx(), cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new ShortestPath03();
    }
}
