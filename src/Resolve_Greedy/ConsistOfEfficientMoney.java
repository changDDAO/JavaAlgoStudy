package Resolve_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class ConsistOfEfficientMoney {
    private int n, m;
    List<Integer> moneyUnits = new ArrayList<>();
    public int []dpTable = new int[10001];
    ConsistOfEfficientMoney() throws IOException {
        init();
        dp();
    }
    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n =Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());
        Arrays.fill(dpTable, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            s= br.readLine();
            moneyUnits.add(Integer.parseInt(s));
        }
    }
    public void dp(){
        dpTable[0]=0;
        for (int unit : moneyUnits) {
            for (int i = unit; i <= m; i++) {
                if (dpTable[i - unit] != Integer.MAX_VALUE) {
                    dpTable[i]=Math.min(dpTable[i],dpTable[i-unit]+1 );
                }
            }
        }
        if (dpTable[m] != Integer.MAX_VALUE) {
            System.out.println(dpTable[m]);
        }else System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        new ConsistOfEfficientMoney();
    }
}
