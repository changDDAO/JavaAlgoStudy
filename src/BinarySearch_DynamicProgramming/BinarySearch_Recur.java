package BinarySearch_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch_Recur {
    public static int biSearch(int []arr, int target, int start, int end) {
        if(start>end)return -1;//찾는값이 없어 그래서 재귀로 돌다보니 어랏 start가 end 쪽으로 넘어가던? 역으로 end가 start로 넘어오던
        int mid = (start+end)/2;
        if(arr[mid]==target) return mid; //찾는값 인덱스반환
        else if (arr[mid] < target) {
            return biSearch(arr, target, mid + 1, end);
        } else {
            return biSearch(arr,target,start,mid-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("arr값을 한칸간격으로 정수로 입력하시오");
        String s = br.readLine();
        String [] input = s.split(" ");
        int [] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        System.out.println("arr = " + arr.length);
        System.out.print("찾는 값을 입력하시오-> ");
        s= br.readLine();
        int target = Integer.parseInt(s);
        int targetIndex =biSearch(arr,target,0,arr.length-1);
        if(targetIndex==-1) System.out.println("찾는 값이 없습니다.");
        else System.out.println("target의 인덱스는 " +targetIndex+"입니다");

    }
}
