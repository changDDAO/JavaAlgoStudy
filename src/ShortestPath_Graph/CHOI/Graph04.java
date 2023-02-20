package ShortestPath_Graph.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Graph04 {
    private int N;
    private int[] indegree;
    private int[] time;
    private ArrayList<ArrayList<Integer>> graph;

    public Graph04() throws IOException {
        init();
        run();
    }

    private void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] input = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        N = input[0];

        indegree = new int[N + 1];
        time = new int[N + 1];

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 1; i < N + 1; i++) {
            s = br.readLine();
            input = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();

            time[i] = input[0];

            for (int j = 1; j < input.length; j++) {
                if (input[j] == -1)
                    break;

                indegree[i] += 1;
                graph.get(input[j]).add(i);
            }
        }
    }

    private void run() {
        int[] result = Arrays.copyOf(time, time.length); // 깊은 복사
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            graph.get(cur).forEach(n -> {
                result[n] = Math.max(result[n], result[cur] + time[n]); // 갱신
                indegree[n] -= 1;

                if (indegree[n] == 0)
                    queue.offer(n);
            });
        }

        IntStream.range(1, result.length).forEach(i -> System.out.println(result[i]));
    }

    public static void main(String[] args) throws IOException {
        new Graph04();
    }
}
