package BinarySearch_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice2_BS {
    //1. 전체 N종류의 부품 입력받기, M 종류의 부품 입력받기
    //2. 빠른 탐색을 위해 Binary Search 구현하기
    //3. check 함수 만들어서 최종 return 값이 true라면 yes false라면 no return 시키기
    public List<Integer> srcList;
    public List<Integer> targetList;
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        s= br.readLine();
        String [] line = s.split(" ");
        srcList=Arrays.stream(line).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        s = br.readLine();
        int m = Integer.parseInt(s);
        s = br.readLine();
        line = s.split(" ");
        targetList = Arrays.stream(line).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

    }
    public boolean biSearch(List<Integer> parts, int target, int start, int end) {
        if(start>end) return false;
        int mid = (start+end)/2;
        if(parts.get(mid)==target) return true;
        if(parts.get(mid)>target) return biSearch(parts,target,start,mid-1);
        else return biSearch(parts,target,mid+1,end);
    }

    public Practice2_BS() throws IOException {
        input();
        srcList.sort((a,b) -> a-b);//오름차순 정렬
        for (int i = 0; i < targetList.size(); i++) {
            if(biSearch(srcList,targetList.get(i),0,srcList.size()-1))
            System.out.print("yes ");
            else System.out.print("no ");
        }
    }

    public static void main(String[] args) throws IOException {
        new Practice2_BS();
    }


}
