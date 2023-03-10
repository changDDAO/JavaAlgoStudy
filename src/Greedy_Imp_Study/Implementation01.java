package Greedy_Imp_Study;

import java.util.ArrayList;
import java.util.Scanner;

public class Implementation01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int x = 1;
        int y = 1;

        int newX;
        int newY;

        ArrayList<String> input = new ArrayList<>();

        while(true) {
            String s = sc.next();
            if (s.equals("stop"))
                break;
            input.add(s);
        }

        sc.close();

        for (String s : input) {
            newX = x;
            newY = y;

            if (s.equals("L"))
                newY--;
            else if (s.equals("R"))
                newY++;
            else if (s.equals("U"))
                newX--;
            else if (s.equals("D"))
                newX++;

            if (newX > N || newX < 1 || newY > N || newY < 1)
                continue;
            else
                x = newX;
            y = newY;
        }

        System.out.print(x + ", " + y);
    }
}
