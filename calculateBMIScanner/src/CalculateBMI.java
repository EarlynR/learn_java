
import java.util.Scanner;
import java.lang.Math;

public class CalculateBMI {

    public static void main( String [] args ) {

        final double POUNDS_IN_KILOGRAMS = 0.45359237;
        final double INCHES_IN_METERS = 0.0254;

        float personHeight = 0;
        float personWeight = 0;
        float personBMI = 0;

        Scanner input = new Scanner( System.in );
        System.out.println( "Body Mass Calculator\n" );

        System.out.print( "Enter height in inches: " );
        personHeight = input.nextFloat();     // Person's height

        while (personHeight <= 0) {
            System.out.println("The number you entered is invalid.\n" +
                               "Your height should be greater than 0 inches.");
            System.out.print("Enter height in inches: ");
            personHeight = input.nextFloat();
        }


        System.out.print( "Enter weight in pounds: " );
        personWeight = input.nextFloat();     // Person's weight

        while (personWeight <= 0) {
            System.out.println("The number you entered is invalid.\n" +
                    "Your weight should be greater than 0 pounds.");
            System.out.print("Enter weight in pounds: ");
            personWeight = input.nextFloat();
        }

        personBMI = (float) ((float) (personWeight * POUNDS_IN_KILOGRAMS) / Math.pow((personHeight * INCHES_IN_METERS), 2));
        System.out.print("Body Mass Index: " + personBMI);

        System.out.print("\n\n");
        System.out.println("\tUnderweight: less than 18.5");
        System.out.println("\tNormal: 18.5 - 24.9");
        System.out.println("\tOverweight: 25 - 29.9");
        System.out.println("\tObese: 30 or greater");

    }

}
