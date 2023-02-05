package BinarySearch_DynamicProgramming.changHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch_For {
    public static int biSearch(int []arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start+end)/2;
            if(arr[mid]==target)
                return mid;
            else if(arr[mid]>target) end = mid-1;
            else start =mid+1;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("arr값을 한칸 간격으로 정수로 입력하시오");
        String s = br.readLine().trim();
        String [] input = s.split(" ");
        int [] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        System.out.print("찾는 값을 입력하시오-> ");
        s= br.readLine();
        int target = Integer.parseInt(s);
        int targetIndex =biSearch(arr,target,0,arr.length-1);
        if(targetIndex==-1) System.out.println("찾는 값이 없습니다.");
        else System.out.println("target의 인덱스는 " +targetIndex+"입니다");

    }


}
