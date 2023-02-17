package ShortestPath_Graph.ChangHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice2_makeTeam {

    private final int []parent = new int[100001];


    public Practice2_makeTeam() throws IOException {
        combTeam();
    }
    //부모찾는 함수 만들기
    private int findParent(int x) {
        if(x==parent[x]) return x;
        return parent[x]=findParent(parent[x]);
    }
    //union 함수 만들기
    private void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a<b)parent[b]=a;
        else parent[a]=b;
    }


    private void combTeam() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br. readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n =Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            parent[i]=i; //부모테이블을 자기 자신으로 초기화
        }
        for (int i = 0; i < m; i++) {
            s = br.readLine();
            int []input = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            int check = input[0];
            int num1 = input[1];
            int num2 = input[2];
            if (check == 0) {
                union(num1, num2);
            } else {
                int a = findParent(num1);
                int b = findParent(num2);
                if(a==b) System.out.println("YES");
                else System.out.println("NO");
            }


        }

    }

    public static void main(String[] args) throws IOException {
        new Practice2_makeTeam();
    }

}
