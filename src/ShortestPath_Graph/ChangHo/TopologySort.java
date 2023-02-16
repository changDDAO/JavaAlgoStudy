package ShortestPath_Graph.ChangHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TopologySort {
    public static int v, e;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int [] inDegree = new int[100001];

    public static void topologySort(){
        ArrayList<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= v; i++) {
            if(inDegree[i]==0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current);
            for (int i = 0; i < graph.get(current).size(); i++) {
                inDegree[graph.get(current).get(i)]-=1;
                //현재노드를 제거하면서 현재노드와 연결된 간선 제거 시키기
                if(inDegree[graph.get(current).get(i)]==0)
                    queue.offer(graph.get(current).get(i));
            }

        }
        order.forEach(orderNum-> System.out.print(orderNum+" "));
        //order list에 담겨있는 순서대로 가지고와서 출력하기
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        } //graph 초기화

        for (int i = 0; i < e; i++) {
            s = br.readLine();
            int []input = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = input[0];
            int b = input[1];
            graph.get(a).add(b);

            inDegree[b]+=1;
        }
        topologySort();
    }

}
