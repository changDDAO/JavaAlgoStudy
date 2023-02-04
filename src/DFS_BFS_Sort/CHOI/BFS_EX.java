package DFS_BFS_Sort.CHOI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_EX {
    private boolean[] visited = new boolean[10];
    private ArrayList<ArrayList<Integer>> list;
    public BFS_EX() {
        init();
        bfs(1);
    }

    public void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        visited[n] = true;
        q.offer(n);

        while (!q.isEmpty()) {
            int pos = q.poll();
            System.out.print(pos + " ");

            for (int tmp : list.get(pos)) { // 시작 노드에서 인접한(= 연결된) 값들을 먼저 검사
                if (!visited[tmp]) { // 꺼낸 값이 방문하지 않은 노드일 경우
                    q.offer(tmp);
                    visited[tmp] = true;
                }
            }
        }
    }

    public void init() {
        list = new ArrayList<>();

        for (int i = 0; i <= 9; i++)
            list.add(new ArrayList<Integer>());

        list.get(1).add(2);
        list.get(1).add(3);
        list.get(1).add(8);

        list.get(2).add(1);
        list.get(2).add(7);

        list.get(3).add(1);
        list.get(3).add(4);
        list.get(3).add(5);

        list.get(4).add(5);
        list.get(4).add(3);

        list.get(5).add(3);
        list.get(5).add(4);

        list.get(6).add(7);

        list.get(7).add(2);
        list.get(7).add(6);
        list.get(7).add(8);

        list.get(8).add(1);
        list.get(8).add(7);
    }

    public static void main(String[] args) {
        new BFS_EX();
    }
}
