package DFS_BFS_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {
    //속도 측면에서 비교할 대상을 첫번째로 둠 2번째로 두어도 비교가 가능하나 최적화 부분에서 비교대상을 첫번째 필드로 둠
    int score;
    String name;

    public Student(int score, String name) {
        this.score = score;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
        return this.score-o.score;
    }
}
public class Practice3_Sort {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> students = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력받기
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String []input;
        String name; int score;
        for(int i=0;i<n;i++){
            s= br.readLine();
            input = s.split(" ");
            name =input[0];
            score = Integer.parseInt(input[1]);
            students.add(new Student(score, name));
        }
        Collections.sort(students);
        students.forEach(std-> System.out.print(std.name+" "));

    }
}
