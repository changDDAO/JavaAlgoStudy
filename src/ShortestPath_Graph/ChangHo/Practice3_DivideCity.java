package ShortestPath_Graph.ChangHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Practice3_DivideCity {
    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost-o.cost;
        }
    }

    public int n, m;
    public ArrayList<Edge> edges = new ArrayList<>();
    public int []parent =new int[100001];

    public Practice3_DivideCity() throws IOException {
        init();
        kruskal();
    }
    public int findParent(int x) {
        if (x ==parent[x])  return x;
        return parent[x]=findParent(parent[x]);
    }
    public void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a<b) parent[b]=a;
        else parent[a]=b;
    }
    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s =br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //부모테이블 자기 자신으로 초기화 하기
        for (int i = 1; i <= n; i++) {
            parent[i]=i;
        }
        for (int i = 0; i < m; i++) {
            s = br.readLine();
            int []input = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            edges.add(new Edge(input[0],input[1],input[2] ));//간선정보 입력받기
        }
        Collections.sort(edges);//cost 기준 오름차순 정렬
    }
    public void kruskal(){
        int answer = 0;
        int maxCost = 0;
        for (Edge edge : edges) {
            int a = edge.getA();
            int b = edge.getB();
            int cost = edge.getCost();
            if (findParent(a) != findParent(b)) {
                union(a,b);
                answer+=cost;
                maxCost = cost;//정렬되어있으니까 반목문 가장 마지막 비용이 가장 큰값
            }
        }
        System.out.println(answer-maxCost);
    }

    public static void main(String[] args) throws IOException {
        new Practice3_DivideCity();
    }

}
