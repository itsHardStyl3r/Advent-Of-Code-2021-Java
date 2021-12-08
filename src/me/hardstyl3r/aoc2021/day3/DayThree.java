package me.hardstyl3r.aoc2021.day3;

import java.io.File;
import java.util.Scanner;

// PART 1 only
public class DayThree {

    public static void main(String[] args) {
        StringBuilder gammaValue = new StringBuilder(), epsilonValue = new StringBuilder();
        try {
            File file = new File("daythree_input.txt");
            Scanner readFile = new Scanner(file);
            // hacking begins
            // So, essentially what we're doing here is read the first line, so we know how long the line is and restart
            int BIT_SIZE = readFile.nextLine().length();
            readFile = new Scanner(file);
            // and ends - this is probably the worst solution to the problem
            for (int i = 0; i < BIT_SIZE; i++) {
                int ones = 0, zeroes = 0;
                while (readFile.hasNextLine()) {
                    String line = readFile.nextLine();
                    if (line.charAt(i) == '1') ones++;
                    else zeroes++;
                }
                gammaValue.append((ones > zeroes ? "1" : "0"));
                epsilonValue.append((ones > zeroes ? "0" : "1"));
                readFile = new Scanner(file); //restart scanner - according to StackOverflow, this is the elegant way
            }
        } catch (Exception e) {
            System.out.println("Could not read daythree_input.txt: " + e + ".");
        }
        int gamma = getDecimal(gammaValue);
        int epsilon = getDecimal(epsilonValue);
        System.out.println("Current gamma (γ) binary: " + gammaValue + ", decimal: " + gamma); //ans: binary: 000101011101, decimal: 349
        System.out.println("Current epsilon (ε) binary: " + epsilonValue + ", decimal: " + epsilon); //ans binary: 111010100010, decimal: 3746
        System.out.println("What is the power consumption of the submarine? " + (gamma*epsilon)); // ans: 1307354
    }

    private static Integer getDecimal(StringBuilder s) {
        return Integer.parseInt(s.toString(), 2);
    }
}
