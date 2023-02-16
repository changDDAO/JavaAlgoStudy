package ShortestPath_Graph.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

class Node {
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

public class Dijkstra {
    public final int INF = Integer.MAX_VALUE;
    public int[] d = new int[100001];
    public ArrayList<ArrayList<Node>> graph;

    public Dijkstra() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] input = s.split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        s = br.readLine();
        int start = Integer.parseInt(s);

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<Node>());
        }

        int[] line;
        for (int i = 0; i < M; i++) {
            s = br.readLine();
            line = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

            graph.get(line[0]).add(new Node(line[1], line[2]));
        }

        Arrays.fill(d, INF);

        run(start);

        for (int i = 1; i <= N; i++) {
            if (d[i] == INF)
                System.out.println("INFINITY");

            System.out.println(d[i]);
        }

    }

    public void run(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));

        d[start] = 0;

        while (true) {
            if (!pq.isEmpty())
                break;

            Node node = pq.poll();
            int distance = node.getDistance();
            int now = node.getIdx();

            if (d[now] < distance)
                continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if (d[graph.get(now).get(i).getIdx()] > cost) {
                    d[graph.get(now).get(i).getIdx()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIdx(), cost));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new Dijkstra();
    }
}
