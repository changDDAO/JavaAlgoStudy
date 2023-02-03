package DFS_BFS_Sort;

import java.util.ArrayList;

public class DFS_ex1 {
    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    // dfs 정의 특정 시작 노드부터 깊이 우선 탐색을 진행
    public static void dfs(int x) {
        visited[x]= true; //방문처리
        System.out.print(x+" "); //console창 출력
        for (int i = 0; i < graph.get(x).size(); i++) {
            int temp = graph.get(x).get(i);
            if(!visited[temp]) dfs(temp);// 특정노드와 연결된 노드를 순회하면서 찾는데 찾은 노드가 방문하지 않았던 노드라면 탐색진행
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<>());
        } //그래프 초기화 해주기
        //1번노드부터 연결된 노드 표시해주기
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        graph.get(2).add(1);
        graph.get(2).add(7);

        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(4);
        graph.get(5).add(3);

        graph.get(6).add(7);

        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        graph.get(8).add(1);
        graph.get(8).add(7);

        dfs(3);

    }

}
