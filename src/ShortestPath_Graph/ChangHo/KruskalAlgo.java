package ShortestPath_Graph.ChangHo;
// 현재 크루스칼 알고리즘을 이용해서 모든 노드를 연결하는 최소비용을 구한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KruskalAlgo {
    public static class Edge{
        int nodeA;
        int nodeB;
        int distance;

        public Edge(int nodeA, int nodeB, int distance)  {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.distance = distance;
        }

        public int getNodeA() {
            return nodeA;
        }

        public int getNodeB() {
            return nodeB;
        }

        public int getDistance() {
            return distance;
        }

    }
    public static int []parent = new int[100001];
    public static int v, e;
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static int sumCost;

    public static int findParent(int x) {
        if(x==parent[x]) return x;
        return parent[x]= findParent(parent[x]);
    }

    public static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a<b) parent[b]=a;
        else parent[a]=b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= v; i++) {
            //부모테이블 초기화 (자기 자신으로)
            parent[i]=i;
        }
        for (int i = 0; i < e; i++) {
            s = br.readLine();
            int []input = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = input[0];
            int b = input[1];
            int c = input[2];
            edges.add(new Edge(a,b,c));
        }
        edges.sort((a,b)->a.distance- b.distance);// 간선 distance를 기준으로 오름차순 정렬

        for (Edge edge : edges) {
            int a = findParent(edge.getNodeA());
            int b = findParent(edge.getNodeB());
            if (a != b) {
                union(edge.getNodeA(), edge.getNodeB());
                sumCost+= edge.distance;
            }
        }
        System.out.print("크루스칼 알고리즘을 수행하며 찾은 사이클이 발생하지않으면서 모든 노드가 연결되는 최소비용은? ");
        System.out.println(sumCost);



    }

}
