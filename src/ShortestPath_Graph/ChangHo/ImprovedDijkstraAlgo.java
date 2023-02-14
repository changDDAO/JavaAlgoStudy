package ShortestPath_Graph.ChangHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ImprovedDijkstraAlgo {
    public static class Node{
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
    }
    public static Comparator<Node> nodeCom = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.distance-o2.distance;
        }
    };
    public static final int INF = Integer.MAX_VALUE;
    public static int n, m, start;
    public static ArrayList<ArrayList<Node>>graph = new ArrayList<>();
    public static int []dpTable = new int[100001];

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>(nodeCom);
        pq.add(new Node(start, 0));
        dpTable[start] =0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dis = node.getDistance();
            int curIdx = node.getIndex();
            if(dpTable[curIdx]<dis) continue;// 이미 갱신돼서 더 작은 값을 가지고있음
            for (int i = 0; i < graph.get(curIdx).size(); i++) {
                int cost = dpTable[curIdx]+graph.get(curIdx).get(i).getDistance();
                if(cost<dpTable[graph.get(curIdx).get(i).getIndex()]) {
                    dpTable[graph.get(curIdx).get(i).getIndex()] = cost;
                    pq.add(new Node(graph.get(curIdx).get(i).getIndex(), cost));
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
        s = br.readLine();
        start = Integer.parseInt(s);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>()); //0번째 노드는 사용안함
        }//graph 초기화 해주기
        //dpTable 초기화 해주기
        Arrays.fill(dpTable,INF);
        //간선 입력받기
        for (int i = 0; i < m; i++) {
            s = br.readLine();
            int []input = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = input[0];
            int b = input[1];
            int c = input[2];
            graph.get(a).add(new Node(b,c));
        }
        dijkstra(start);
        for (int i = 1; i <= n; i++) {
            int temp = dpTable[i];
            if(temp==INF) System.out.println("INF");
            else System.out.println(dpTable[i]);
        }




    }
}
