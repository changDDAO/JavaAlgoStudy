package BinarySearch_DynamicProgramming.ChangHo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Practice5_DP {

    private final int INF = Integer.MAX_VALUE;
    private int m;
    private final ArrayList<Integer> units = new ArrayList<>();
    private int []dpTable;
    public Practice5_DP() {
        init();
        bottomUp();
        if(dpTable[m]!=INF) System.out.println(dpTable[m]);
        else System.out.println(-1);
    }
    public void init(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            //화폐단위 입력받기
           units.add(sc.nextInt());
        }
        dpTable = new int[m+1];
        Arrays.fill(dpTable, INF);// dpTable 초기화

    }
    public void bottomUp(){
        dpTable[0]=0;
        for (int unit : units) {//화폐단위를 하나씩 가져오면서
            for (int j = unit; j <= m; j++) {
                if(dpTable[j-unit]!=INF)
                    dpTable[j] = Math.min(dpTable[j], dpTable[j - unit] + 1);//화폐단위를 바꿔가면서  dpTable을 최솟값으로 갱신
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Practice5_DP();
    }


}
