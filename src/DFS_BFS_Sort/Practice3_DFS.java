package DFS_BFS_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice3_DFS {
    public static int n, m;
    public static int[][] graph = new int[1000][1000];
    public static boolean dfs(int x, int y) {
        //종료조건 명시
        if(x<0||y<0||x>=n||y>=m)
            return false;
        //수행동작
        if (graph[x][y] == 0) {//아이스크림을 만들수있는 칸이라면 방문처리 하고 dfs수행
            graph[x][y]=1;
            dfs(x - 1, y); //dfs 수행동작은 현재 칸에서 사방으로 아이스크림을 만들수 있는 칸인지 확인 후 만들수 있다면 수행
            dfs(x + 1, y);
            dfs(x , y+1);
            dfs(x , y-1);
            return true;
        }
        return false;
    }
    //어렵지않다. dfs수행은 아이스크림을 만들수 있는 칸이라면 방문처리 후 그지점으로부터 사방으로 다시 dfs를 수행한다.
    //이중 for문을 돌다가 처음으로 만나게 되는 0으로 부터 계속 재귀적으로 수행이 될텐데 그렇다면 graph[][]=0인지점이 다 1로 변해있어 count
    // 되지않는다. dfs문제를 다룰때는 수행동작과 종료조건에 집중해야지 과정을 세세하게 들어가다보면 도저히 따라갈 수가 없다.
    //겉에서 처리만 하자 내부동작은 컴퓨터에게 맡겨두고

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        String []temp;
        int []line;
        for (int i = 0; i < n; i++) {
            s= br.readLine();
            temp = s.split("");
            line = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
            graph[i]= Arrays.copyOfRange(line,0,m);//graph 입력받기

        }
        int answer =0;
        for(int i=0;i<n;i++){
            for (int j = 0; j < m; j++) {
                if(dfs(i,j)) answer++;//graph를 순회하다가 dfs(i,j)가 true라면 처음으로 0을 발견한 지점일테고 그지점부터
                //재귀적으로 dfs가 수행되면서 graph의 붙어있는 0의 지점이 다 1로 변했을꺼임. 고로 첫발견한 0만 카운트하면 전체 아이스크림을
                //만들수있는 영역을 count하는 맥락임 별거없음
            }
        }
        System.out.println(answer);


    }

}
