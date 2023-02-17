package ShortestPath_Graph.ChangHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Practice4_Topology {
    public int v;
    public ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public int[] times = new int[501];
    public int[] inDegree = new int[501];
    public Practice4_Topology() throws IOException {
        init();
        topologySort();
    }

    public void topologySort(){
        int [] answer = new int[501];
        if (v >= 0) System.arraycopy(times, 1, answer, 1, v);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= v; i++) {
            if(inDegree[i]==0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int curOrder = queue.poll();
            for (int i = 0; i < graph.get(curOrder).size(); i++) {
                //현재강의까지 듣는데 걸리는 최장시간 저장
                answer[graph.get(curOrder).get(i)] = Math.max(answer[graph.get(curOrder).get(i)],answer[curOrder]+times[graph.get(curOrder).get(i)]);

                inDegree[graph.get(curOrder).get(i)]-=1;
                if(inDegree[graph.get(curOrder).get(i)]==0)
                    queue.offer(graph.get(curOrder).get(i));

            }
        }
    for(int i=1;i<=v;i++) System.out.println(answer[i]);

    }
    public void init() throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        v = Integer.parseInt(s);
        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<>());
        }
        for(int i =1; i<=v;i++){
            s = br.readLine();
            int [] input = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
          times[i] = input[0];
          for(int index =1; index<input.length;index++){
              if(input[index]==-1) break;
              graph.get(input[index]).add(i);
              inDegree[i]+=1; // 현재 순서의 진입차수 증가시키기

          }

        }

    }

    public static void main(String[] args) throws IOException {
        new Practice4_Topology();
    }

}
