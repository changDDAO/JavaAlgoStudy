package DFS_BFS_Sort;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_ex1 {
    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    //bfs 정의하기
    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();//queue에 들어있는 element 빼기
            System.out.print(temp + " "); //console 창에 출력하기 queue에서 Fifo 방식으로 추출

            for (int i = 0; i < graph.get(temp).size(); i++) {
                int curNode = graph.get(temp).get(i);
                if (!visited[curNode]) {
                    queue.add(curNode);
                    visited[curNode] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        //일단 graph 초기화
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<>());
        }
        //dfs랑 구조가 동일하므로 그대로 가져다가 붙임
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

        graph.get(5).add(3);
        graph.get(5).add(4);

        graph.get(6).add(7);

        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        graph.get(8).add(1);
        graph.get(8).add(7);


        bfs(1);


    }

}
