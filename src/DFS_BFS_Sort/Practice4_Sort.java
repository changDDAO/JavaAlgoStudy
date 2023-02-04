package DFS_BFS_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
import java.util.stream.Collectors;

public class Practice4_Sort {
    public static List<Integer> arrA;
    public static List<Integer> arrB;
    public static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        s = br.readLine();
        String []input = s.split(" ");
        arrA = Arrays.stream(input).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        s = br.readLine();
        input = s.split(" ");
        arrB =  Arrays.stream(input).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Collections.sort(arrA);// 오름차순 정렬
        arrB.sort(Collections.reverseOrder()); //내림차순 정렬
        for(int i=0;i<k;i++){
            arrA.set(i, arrB.get(i)); //arrA의 k-1번째 인덱스까지 값변경(arrA[i]=arrB[i])가 된다고 생각하면됨
        }

        int answer =arrA.stream().mapToInt(i->i).sum();
        System.out.println(answer);

    }
}
