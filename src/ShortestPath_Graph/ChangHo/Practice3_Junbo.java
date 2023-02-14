package ShortestPath_Graph.ChangHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Practice3_Junbo {
    public static class Node implements Comparable<Node>{
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
    public static int []dpTable = new int[30001];
    public static int n, m, start;

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static final int INF = (int)2e9; //무한대

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq= new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dpTable[start]=0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dis = node.getDistance();
            int curNode = node.getIndex();
            if(dpTable[curNode]<dis) continue;
            for (int i = 0; i < graph.get(curNode).size(); i++) {
                int cost = dpTable[curNode]+graph.get(curNode).get(i).getDistance();
                if (cost < dpTable[graph.get(curNode).get(i).getIndex()]) {
                    dpTable[graph.get(curNode).get(i).getIndex()]=cost;
                    pq.add(new Node(graph.get(curNode).get(i).getIndex(),cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        Arrays.fill(dpTable,INF);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }//graph 초기화
        for (int i = 0; i < m; i++) {
            s =br.readLine();
            int [] input =Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = input[0];
            int b = input[1];
            int c = input[2];
            graph.get(a).add(new Node(b,c));
        }
        dijkstra(start);
        int countrySum =0; int max =0;
        for (int i = 1; i <= n; i++) {
            if (dpTable[i] != INF) {
                countrySum++;
                max =Math.max(max, dpTable[i]);
            }
        }
        System.out.println((countrySum-1)+" "+max);





    }

}
