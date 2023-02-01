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

            if (newX > 5 || newX < 1 || newY > 5 || newY < 1)
                continue;
            else
                x = newX;
            y = newY;
        }

        System.out.print(x + ", " + y);
    }
}
