package BinarySearch_DynamicProgramming.ChangHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Practice3_BiSearch {
    //1. 떡의 개수 입력받기 n, 목표하는 떡의길이 입력받기 m
    //2. 떡의 갯수대로 떡의 길이 입력받은 후에 h 절단기 높이를 이진탐색으로 찾으면서
    //자른후 오른쪽 남겨진 부분의 떡의 합이 m일 때, 절단기 높이 return;
    public static int n, m;
    public static List<Integer> dduckList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); //목표떡양
        s = br.readLine();
        String [] input = s.split(" ");
        dduckList  = Arrays.stream(input).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        //입력은 다받았으니 이진탐색으로 h길이를 찾으면서 h길이로 자른후 남은 오른쪽 떡의 양의 합이 m이랑 일치하는지 비교를 하자
        int start =0;
        int end = (int)1e9; //10억
        int answer = 0;
        while (start <= end) {

            int mid = (start+end)/2; // mid 값이 결국엔 찾을 h의 길이가 될것임.
            long dduckSum = dduckList.stream().filter(b->(b>mid)).mapToInt(d->d-mid).sum();
            /*for (int dduck : dduckList) {
                if(dduck>mid) dduckSum += (dduck-mid); //떡리스트 순회하면서 떡의길이가 절단기 길이보다 길다면 잘라서 오른쪽부분을 합해준다
                }*/
            if(dduckSum<m) end = mid-1;//목표하는양보다 오른쪽에 잘려진 떡의양이 작다면 절단기의 길이를 줄여 더많이 잘려지도록 해야한다.
            else{
                answer = mid;// 절단기 길이의 최댓값을 출력하는 문제이므로 떡이 잘려진 오른쪽 부분의 합이 목표하는 양보다 크거나 같다면 h증가
                start =mid+1;
            }
        }
        System.out.println(answer);


    }
}
