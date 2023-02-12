package ShortestPath_Graph.ChangHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class simpleDijkstraAlgo {
    static class Node{
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
    }//class 초기화

    public static final int INF = Integer.MAX_VALUE;
    public static int n, m, start;
    //각 노드에 연결돼있는 노드정보를 담는 리스트
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    //최단 거리 테이블
    public static int []dpTable = new int[100001];
    public static boolean []visited = new boolean[100001];//방문표시

    //방문하지 않은 노드중 가장 거리가짧은 노드번호 반환
    public static int getSNN(){
        int minValue = Integer.MAX_VALUE;
        int index =0;
        for (int i = 1; i <= n; i++) {
            if(dpTable[i]<minValue&&!visited[i]) {
                minValue = dpTable[i];
                index = i;
            }
        }
        return index;
    }
    public static void dijkstra(int start) {
        dpTable[start] =0;
        visited[start] = true;
        for (int i = 0; i < graph.get(start).size(); i++) {
            dpTable[graph.get(start).get(i).getIndex()]=graph.get(start).get(i).getDistance();
        }//시작 노드를 제외한 나머지노드에 대해 반복적으로 진행
        for (int i = 0; i < n - 1; i++) {
          int curNode = getSNN();
          visited[curNode] = true;
            for (int j = 0; j < graph.get(curNode).size(); j++) {
            int cost = dpTable[curNode]+graph.get(curNode).get(j).getDistance();
            if(cost<dpTable[graph.get(curNode).get(j).getIndex()])
                dpTable[graph.get(curNode).get(j).getIndex()] = cost;
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
            graph.add(new ArrayList<>());
        }//그래프 초기화

        //m이 간선
        for (int i = 0; i < m; i++) {
            s =br.readLine();
            int []input = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a  = input[0];
            int b  = input[1];
            int c  = input[2];
            graph.get(a).add(new Node(b,c));

        }
        Arrays.fill(dpTable,INF);//dpTable 초기화
        dijkstra(start);
        for (int i = 1; i <= n; i++) {
            System.out.print(i+"노드까지의 거리 : ");
            int dis = dpTable[i];
            if(dis == INF) System.out.println("INF");
            else System.out.println(dis);
        }
    }


}
