package me.hardstyl3r.aoc2021.day2;

import java.io.File;
import java.util.Scanner;

public class DayTwo {

    @SuppressWarnings("ConstantConditions")
    // I want to be able to switch between debug true and false when something goes wrong.
    // I placed @SW just so that IDE doesn't annoy me.
    // Probably shouldn't have mixed two parts in one, but who cares.
    public static void main(String[] args) {
        int horizontal = 0, depth = 0, depthTwo = 0, aim = 0;
        boolean debug = false;
        try {
            File file = new File("daytwo_input.txt");
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine()) {
                String line = readFile.nextLine();
                String command = line.split(" ")[0];
                int argument = Integer.parseInt(line.split(" ")[1]);
                if (line.startsWith("forward")) {
                    horizontal += argument; //first part
                    depthTwo += (aim * argument); //second part
                    if(debug) System.out.println("I. '" + command + " " + argument + "' adds " + argument + " to your horizonal position, a total of " + horizontal + ".");
                    if(debug) System.out.println("II. Because your aim is " + aim + ", your depth increases by " + argument + "*" + aim + "=" + depthTwo);
                } else if (line.startsWith("down")) {
                    depth += argument; //first part
                    aim += argument; //second part
                    if(debug) System.out.println("I. '" + command + " " + argument + "' adds " + argument + " to your depth, a total of " + depth + ".");
                    if(debug)  System.out.println("II. '" + command + " " + argument + "' adds " + argument + " to your aim, resulting in a value of " + aim + ".");
                } else if (line.startsWith("up")) {
                    depth -= argument; //first part
                    aim -= argument; //second part
                    if(debug) System.out.println("I. '" + command + " " + argument + "' decreases your depth by " + argument + ", resulting in a value of " + depth + ".");
                    if(debug) System.out.println("II. '" + command + " " + argument + "' decreases your aim by " + argument + ", resulting in a value of " + aim + ".");
                } else System.out.println("Unknown command " + command + " with argument " + argument + ".");
            }
        } catch (Exception e) {
            System.out.println("Could not read daytwo_input.txt: " + e + ".");
        }
        System.out.println("I. Horizontal: " + horizontal + " and depth: " + depth + "."); //ans: 1970 & 916
        System.out.println("What do you get if you multiply your final horizontal position by your final depth? " + horizontal * depth + "\n"); //ans: 1804520

        System.out.println("II. Horizontal: " + horizontal + " and depthTwo: " + depthTwo + "."); //ans: 1970 & 1000556
        System.out.println("What do you get if you multiply your final horizontal position by your final depth? " + horizontal * depthTwo); //ans: 1971095320
    }
}
