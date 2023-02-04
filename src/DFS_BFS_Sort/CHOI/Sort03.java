package DFS_BFS_Sort.CHOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Sort03 {
    private ArrayList<Student> list;
    private class Student {
        private String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
    }

    public Sort03() throws IOException {
        init();

        list.sort(new Comparator<Student>() { // collection 정렬 : comparable 사용
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore() - o2.getScore(); // 성적 기준 오름차순으로 정렬
            }
        });

        for (Student st : list) { // 학생 이름 출력
            System.out.print(st.getName() + " ");
        }

    }

    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);

        list = new ArrayList<>();

        for (int i = 0; i < n; i++) { // 입력
            s = br.readLine();
            String[] input = s.split(" ");

            list.add(new Student(input[0], Integer.parseInt(input[1])));
        }

        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Sort03();
    }
}
