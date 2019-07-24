
/*

Objective: Build a pyramid per user's preferences
Goals: Use control statements to efficiently build a pyramid

 */

import java.util.Scanner;

public class PyramidDisplay {

    public static void main(String args[]) {

        String pyramidChoice;
        int depthOfPyramid = 0;
        int i, j;

        Scanner input = new Scanner(System.in);
        System.out.println("\n\n");

        // Ask user what type of pyramid she/he wants
        System.out.println("Let's build a pyramid!");
        System.out.println("Would you like to view a top-heavy pyramid or a " +
                "bottom-heavy pyramid?");
        System.out.print("Type \"t\" if you would like to see a top-heavy pyramid " +
                "or \"b\" for a bottom-heavy pyramid: ");
        pyramidChoice = input.next();

        // Ask user how deep the pyramid should be
        System.out.print("How deep or how many layers should the pyramid have? ");
        depthOfPyramid = input.nextInt();

        // Use switch to display pyramid according to user's directions
        switch (pyramidChoice) {
            // Build top-heavy pyramid
            case "t":
            {
                for (i = 0; i < depthOfPyramid; i++)
                {
                    for (j = i; j < depthOfPyramid; j++)
                        System.out.print("+");
                    System.out.println();
                }
                break;
            }
            // Build bottom-heavy pyramid
            case "b":
            {
                for (i = 0; i < depthOfPyramid; i++)
                {
                    for (j = 0; j <= i; j++)
                        System.out.print("+");
                    System.out.println();
                }
                break;
            }
        }

    }
}
