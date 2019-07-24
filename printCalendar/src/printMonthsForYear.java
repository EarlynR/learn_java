/**


 @Objective:
 Print all of the months for the year the user instructed to see.
 This assignment uses all the methods created for the first assignment,
 but it uses a loop to go through each month for the year.

 @Author: Earlyn Reinhardt
 */



import java.util.Scanner;

public class printMonthsForYear {

    public static void main ( String [] args ) {

        int yearToDisplay;

        // Ask person for month and year to print
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("We are going to print a calendar for you. " +
                "Please tell me the year you want to see.");

        System.out.print("Give me the year: ");
        yearToDisplay = input.nextInt();

        int i;

        for (i=1; i <= 12; i++)
        {
            printMonthCalendar(i, yearToDisplay);
        }
    }

    /**
     * @Objective Print the month per the user's instructions using all
     * helper functions.
     *
     * @param: month
     * @param: year
     *
     * @precondition all inputs are integers
     */
    public static void printMonthCalendar( int month, int year) {

        printMonthHeader(month, year);
        printMonthBody(month, year);
    }




    /**
     * @Objective Print the header for month and year. Each month and
     * year shares the same template.
     *
     * @param: month
     * @param: year
     *
     * @precondition all inputs are integers
     */
    public static void printMonthHeader ( int month, int year) {

        String monthName = getMonthName(month);
        String monthAndYear = monthName + " " + String.valueOf(year);

        // Format Header
        System.out.println( "\n\n" );
        System.out.format("%-7s%-10s%-7s%n","  ", monthAndYear,
                "  ");
        System.out.format("%-10s%n", "---------------------------");
    }


    /**
     * @Objective Print the body of the month, which includes the
     * abbreviated days of the week as well as the actual days.
     *
     * @param month
     * @param year
     *
     * @precondition all inputs are integers
     */
    public static void printMonthBody ( int month, int year) {

        int startDay = getStartDay( month, year );
        int numDaysInMonth = getNumDaysinMonth( month, year );

        int dayOfWeek;
        int dayOfMonth;

        // Format Days of Week
        System.out.format("%4s%4s%4s%4s%4s%4s%4s%n", "Sun", "Mon",
                "Tue", "Wed", "Thu", "Fri", "Sat");

        // Print a blank space underneath the days of the week
        // that do not have a number.

        if (startDay != 7)
        {
            for (dayOfWeek = startDay; dayOfWeek > 0; dayOfWeek--)
                System.out.format("%-4s", " ");
        }

        for (dayOfWeek = startDay + 1, dayOfMonth = 1; dayOfMonth <= numDaysInMonth; dayOfWeek++,
                dayOfMonth++)
        {
            if (dayOfWeek % 7 == 0)
            {
                System.out.format("%4d", dayOfMonth);
                System.out.println();
            }
            else
                System.out.format("%4d", dayOfMonth);
        }
        System.out.println();
    }





    /**
     * @Objective Map the month in integer to its string counterpart
     *
     * @param month
     * @return month in string form
     *
     * @precondition month is an integer
     */
    public static String getMonthName (int month) {

        String monthName = "";

        switch (month)
        {
            case 1:  monthName = "January";    break;
            case 2:  monthName = "February";   break;
            case 3:  monthName = "March";      break;
            case 4:  monthName = "April";      break;
            case 5:  monthName = "May";        break;
            case 6:  monthName = "June";       break;
            case 7:  monthName = "July";       break;
            case 8:  monthName = "August";     break;
            case 9:  monthName = "September";  break;
            case 10: monthName = "October";    break;
            case 11: monthName = "November";   break;
            case 12: monthName = "December";   break;
        }

        return monthName;
    }





    /**
     * @Objective From the year and month, this method returns
     * the day of the week that the first day of the month
     * is on. This method uses Zeller's algorithm and was given
     * by the instructor.
     *
     * @param month
     * @param year
     *
     * @return an integer representing the day of the week.
     * 1 = Monday, 2 = Tuesday, ...., 7 = Sunday
     *
     * @author JHU
     */
    public static int getStartDay (int month, int year) {

        final int day = 1; // Must be set to day 1 for this to work. JRD

        if ( month < 3 )
        { // Adjust month number & year to fit Zeller's numbering system
            month += 12;
            year -= 1;
        }

        int yearInCent = year % 100;
        int century = year / 100;
        int firstDay = 0;

        firstDay = (day + (13 * (month + 1) / 5) + yearInCent + (yearInCent /
                4) + (century / 4) + (5 * century)) % 7;

        int dayNum = ((firstDay + 5) % 7 + 1); //Convert Zeller's value to
        // ISO val (1 = Mon, 2 = Tues, ..., 7 = Sun)

        return dayNum;
    }




    /**
     * @Objective Get the number of days in a month. Makes sure
     * it returns the right number of days for the month. It also takes
     * leap year into account.
     *
     * @param month
     * @param year
     *
     * @return number of days in month
     */
    public static int getNumDaysinMonth (int month, int year)
    {

        if (month <= 7)
        {
            if (month % 2 == 0)
            {
                if (month == 2 && isLeapYear(year))
                    return 29;  // February on a leap year

                else if (month == 2)
                    return 28;  // February (non-leap year)

                else return 30; // April & June
            }
            else return 31;     // January, March, May, July
        }
        else
        {
            if (month % 2 == 0) return 31; // August, October, December
            else                return 30; // September, November
        }
    }



    /**
     * @Objective Take in the year as input and determine
     * whether or not it is a leap year
     *
     * @param year
     *
     * @return boolean for leapYear
     */
    public static boolean isLeapYear ( int year)
    {
        // Determine whether year is divisible by 4
        // https://www.mathsisfun.com/leap-years.html
        if (year % 4 == 0)
        {
            if (year % 100 == 0)
            {
                if (year % 400 == 0) return true;
                else                 return false;
            }
            else return true;
        }
        else return false;
    }
}
