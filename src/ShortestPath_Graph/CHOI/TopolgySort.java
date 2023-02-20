package ShortestPath_Graph.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class TopolgySort {
    private int V;
    private int[] indegree;
    private final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public TopolgySort() throws IOException {
        init();
        run();
    }

    private void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] input = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        V = input[0];
        int E = input[1];

        indegree = new int[V + 1];

        for (int i = 0; i < V + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            s = br.readLine();
            input = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

            graph.get(input[0]).add(input[1]);

            indegree[input[1]] += 1;
        }
    }

    private void run() {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < V + 1; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);

            graph.get(cur).forEach(n -> {
                indegree[n] -= 1;

                if (indegree[n] == 0)
                    queue.offer(n);
            });
        }

        result.forEach(i -> System.out.print(i + " "));
    }

    public static void main(String[] args) throws IOException {
        new TopolgySort();
    }
}
