package ShortestPath_Graph.ChangHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DetectCycle {
    public static int v, e;
    public static int[] parent = new int[100001];

    public static int findParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= v; i++) {
            parent[i]=i; //부모테이블을 자기자신으로 초기화
        }
        for (int i = 0; i < e; i++) {
            s = br.readLine();
            int[] input = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = input[0];
            int b = input[1];
            if (findParent(a) == findParent(b)) {
                System.out.println("cycle이 발생하였습니다.");
                break;
            } else {
                union(a, b);
            }

        }
    }
}
