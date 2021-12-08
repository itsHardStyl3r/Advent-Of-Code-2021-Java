package me.hardstyl3r.aoc2021.day1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DayOne {

    public static void main(String[] args) {
        ArrayList<Integer> inputs = new ArrayList<>();
        try {
            File file = new File("dayone_input.txt");
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine()) inputs.add(readFile.nextInt());
        } catch (Exception e) {
            System.out.println("Could not read dayone_input.txt: " + e + ".");
        }
        System.out.println("Number of inputs: " + inputs.size() + "."); //ans: 2000
        int diffs = 0;
        for (int i = 0; i < (inputs.size() - 1); i++) {
            int current = inputs.get(i);
            int next = inputs.get(i + 1);
            if (current < next) diffs++;
        }
        System.out.println("How many measurements are larger than the previous measurement? " + diffs); //ans: 1387
        diffs = 0;
        for (int i = 0; i < (inputs.size() - 3); i++) {
            int a = inputs.get(i);
            int b = inputs.get(i + 1);
            int c = inputs.get(i + 2);
            int d = inputs.get(i + 3);
            if (a + b + c < b + c + d) diffs++;
        }
        System.out.println("How many sums are larger than the previous sum? " + diffs); //ans: 1362
    }
}
