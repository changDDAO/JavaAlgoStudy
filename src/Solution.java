import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solution {
    int n, m;
    public List<Integer> dduckList;

    public Solution() throws IOException {
        input();
        int answer = searchH(m);
        System.out.println(answer);
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = br.readLine();
        String[] dducks = s.split(" ");
        dduckList = Arrays.stream(dducks).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

    }

    public int getDduckSum(int mid) {
        int dducksum = 0;
        for (int dduckLen : dduckList) {
            if (dduckLen > mid) {
                dducksum += (dduckLen - mid);
            }
        }
        return dducksum;

    }

    public int searchH(int m) {
        int start = 0;
        int h = 0;
        int end = (int) 1e9;
        while (start <= end) {
            int mid = (start + end) / 2;
            int dduckSum = getDduckSum(mid);
            if (dduckSum < m)
                end = mid - 1;
            else {
                h = mid;
                start = mid + 1;
            }
        }
        return h;
    }
    public static void main(String[] args) throws IOException {
        new Solution();
    }
}
