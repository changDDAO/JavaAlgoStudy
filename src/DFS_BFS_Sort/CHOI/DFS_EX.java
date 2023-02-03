package DFS_BFS_Sort.CHOI;

import java.util.ArrayList;

public class DFS_EX {
    private boolean[] visited = new boolean[10];
    private ArrayList<ArrayList<Integer>> list;
    public DFS_EX() {
        init();
        dfs(1);
    }

    public void dfs(int n) {
        System.out.print(n + " ");
        visited[n] = true;

        for (int tmp : list.get(n)) {
            if (!visited[tmp])
                dfs(tmp);
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
