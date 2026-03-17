import java.util.Scanner;

/** *****************************************************************
 conversion.java
 Converts various measures from one unit to another

 @author Jeff Offutt & Ren Li

 @version 1.0    October 2000
 @version 2.0    June 2015
 @version 2.1    January 2020
  ********************************************************************* */

// Import Java Libraries
// conversion class
//
// CONSTRUCTOR: no constructor specified (default)
//
// ****************  PUBLIC OPERATIONS  **********************************
// void  doGet()      --> Uses PrintHead() and PrintForm() to print the screen
// void  PrintHead()  --> Generates the head of the web page
// void  PrintForm()  --> Generates the form of the web page
// void  doPost()     --> Handles the conversions
// float convertX2Y() --> One for each conversion pair
//*************************************************************************
//
// The possible IOException on the PrintWriter is thrown up.

public class conversion
{
    /**
     * Helper method to round numbers to the specified number of decimal places
     * @param num the number being rounded
     * @param decimalPrecision the number of decimal places wanted
     * @return the rounded number
     */
    public static float roundNum(float num, int decimalPrecision) {
        float factor = (float)Math.pow(10,decimalPrecision);

        int n = Math.round(num * factor);

        float result = (float) (n / (float)factor);

        return result;
    }

    /**
     * Helper method to do conversions
     * @param XAsStr value being converted
     * @param conversionFormula number used to do conversion
     * @param decimalPrecision  number of decimal places
     * @return  the converted number rounded to the specified amount of decimal places
     */
    public static float genericConvert(String XAsStr, float conversionFormula, int decimalPrecision) {
        float num1, num2;

        num1 = (Float.valueOf(XAsStr).floatValue());
        num1 = roundNum(num1, decimalPrecision);

        num2 = (float)  (num1 * conversionFormula);

        num2 = roundNum(num2, decimalPrecision);
        return num2;
    }

    // Convert Fahrenheit to Celsius
    private static float convertF2C (String FAsStr, int decimalPrecision)
    {  // Convert farenheit to celsius
        float num1, num2; // temporary variables

        // Round to N digits past decimal
        num1 = (Float.valueOf(FAsStr).floatValue());
        num1 = roundNum(num1, decimalPrecision);
        // Convert
        num2 = (float) ( ( (num1-32.0) * 5.0) / 9.0);
        // Back to N digits
        return roundNum(num2, decimalPrecision);
    }

    // Convert Celsius to Fahrenheit
    private static float convertC2F (String CAsStr, int decimalPrecision)
    {  // Convert celsius to farenheit
        float num1, num2; // temporary variables

        // Round to N digits past decimal
        num1 = (Float.valueOf (CAsStr).floatValue ());
        num1 = roundNum(num1, decimalPrecision);
        // Convert
        num2 = (float) ( (num1 * 9.0 / 5.0) + 32.0);
        // Back to N digits
        return roundNum(num2, decimalPrecision);
    }

    // small distance

    // Convert Inches to Centimeters
    private static float convertIn2Cm (String inAsStr, int decimalPrecision)
    {
        return genericConvert(inAsStr, 2.54f, decimalPrecision);
    }

    // Convert Centimeters to Inches
    private static float convertCm2In (String cmAsStr, int decimalPrecision)
    {
        return genericConvert(cmAsStr, 0.3937f, decimalPrecision);
    }

    // medium distance

    // Convert Feet to Meters
    private static float convertF2M (String ftAsStr, int decimalPrecision)
    {
        return genericConvert(ftAsStr, 0.3048f, decimalPrecision);
    }

    // Convert Meters to Feet
    private static float convertM2F (String mAsStr, int decimalPrecision)
    {
        return genericConvert(mAsStr, 3.28084f, decimalPrecision);
    }

    // large distance

    // Convert Miles to Kilometers
    private static float convertM2K (String miAsStr, int decimalPrecision)
    {
        return genericConvert(miAsStr, 1.609f, decimalPrecision);
    }

    // Convert Kilometers to Miles
    private static float convertK2M (String kmAsStr, int decimalPrecision)
    {
        return genericConvert(kmAsStr, 0.6214f, decimalPrecision);
    }

    // volume

    // Convert Gallons to Liters
    private static float convertG2L (String galAsStr, int decimalPrecision)
    {
        return genericConvert(galAsStr, 3.785f, decimalPrecision);
    }

    // Convert Liters to Gallons
    private static float convertL2G (String LAsStr, int decimalPrecision)
    {
        return genericConvert(LAsStr, 0.2642f, decimalPrecision);
    }

    // small weight

    // Convert Ounces to Grams
    private static float convertOz2G (String ozAsStr, int decimalPrecision)
    {
        return genericConvert(ozAsStr, 28.35f, decimalPrecision);
    }

    // Convert Grams to Ounces
    private static float convertG2Oz (String gAsStr, int decimalPrecision)
    {
        return genericConvert(gAsStr, 0.03527f, decimalPrecision);
    }

    // medium weight

    // Convert Pounds to Kilograms
    private static float convertLb2K (String lbAsStr, int decimalPrecision)
    {
        return genericConvert(lbAsStr, 0.4536f, decimalPrecision);
    }

    // Convert Kilograms to Pounds
    private static float convertK2Lb (String kgAsStr, int decimalPrecision)
    {
        return genericConvert(kgAsStr, 2.205f, decimalPrecision);
    }

    // Convert Hours to Seconds
    private static float convertHr2Sec (String hrAsStr, int decimalPrecision)
    {
        return genericConvert(hrAsStr, 3600f, decimalPrecision);
    }

    // Convert Seconds to Hours
    private static float convertSec2Hr (String secAsStr, int decimalPrecision)
    {
        return genericConvert(secAsStr, 1f/3600f, decimalPrecision);
    }

    // Speed conversions - Added via TDD
    public static float convertMph2Kmh(String mphAsStr, int decimalPrecision) {
        // Convert miles per hour to kilometers per hour
        // Formula: km/h = mph × 1.60934
        return genericConvert(mphAsStr, 1.60934f, decimalPrecision);
    }

    public static void main(String[] args) {

        // Read user input
        Scanner scanner = new Scanner(System.in);
        boolean continueConverting = true;


        // Display welcome message
        System.out.println("====== Unit Converter ======\n");

        System.out.println("Enter decimal precision (0-4): ");
        int decimalPrecision = scanner.nextInt();

        if (decimalPrecision < 0 || decimalPrecision > 4) {
            System.out.println("Invalid value. Using default: 2");
            decimalPrecision = 2;
        }

        // Main program loop
        while (continueConverting) {
            // Display main menu with categories
            System.out.println("Choose an operation category:");
            System.out.println("1. Temperatures");
            System.out.println("2. Short Distance");
            System.out.println("3. Medium Distance");
            System.out.println("4. Large Distance");
            System.out.println("5. Volume");
            System.out.println("6. Small Weight");
            System.out.println("7. Medium Weight");
            System.out.println("8. Time");
            System.out.println("9. Exit");
            System.out.print("Enter choice (1-9): ");

            // Get user's category choice
            int choice = scanner.nextInt();

            // Check if exit option was selected
            if (choice == 9)
            {
                continueConverting = false;
                System.out.println("Goodbye!");
                continue;
            }

            // Route to conversion category
            switch (choice)
            {
                case 1: // Temperature conversions
                    System.out.println("1. Fahrenheit to Celsius");
                    System.out.println("2. Celsius to Fahrenheit");
                    System.out.print("Enter choice: ");
                    int tempChoice = scanner.nextInt();

                    System.out.print("Enter temperature value: ");
                    String tempValue = scanner.next();

                    // Perform selected conversion
                    if (tempChoice == 1)
                    {
                        float result = convertF2C(tempValue, decimalPrecision);
                        System.out.println(tempValue + "F = " + result + "C");
                    } else if (tempChoice == 2)
                    {
                        float result = convertC2F(tempValue, decimalPrecision);
                        System.out.println(tempValue + "C = " + result + "F");
                    }
                    break;
                case 2: // Short distance conversions
                    System.out.println("1. Inches to Centimeters");
                    System.out.println("2. Centimeters to Inches");
                    System.out.print("Enter choice: ");
                    int shortDistChoice = scanner.nextInt();

                    System.out.print("Enter distance value: ");
                    String shortDistValue = scanner.next();

                    if (shortDistChoice == 1)
                    {
                        float result = convertIn2Cm(shortDistValue, decimalPrecision);
                        System.out.println(shortDistValue + "in. = " + result + "cm.");
                    } else if (shortDistChoice == 2)
                    {
                        float result = convertCm2In(shortDistValue, decimalPrecision);
                        System.out.println(shortDistValue + "cm. = " + result + "in.");
                    }
                    break;
                case 3: // Medium distance conversions
                    System.out.println("1. Feet to Meters");
                    System.out.println("2. Meters to Feet");
                    System.out.print("Enter choice: ");
                    int medDistChoice = scanner.nextInt();

                    System.out.print("Enter distance value: ");
                    String medDistValue = scanner.next();

                    if (medDistChoice == 1)
                    {
                        float result = convertF2M(medDistValue, decimalPrecision);
                        System.out.println(medDistValue + "ft. = " + result + "m.");
                    } else if (medDistChoice == 2)
                    {
                        float result = convertM2F(medDistValue, decimalPrecision);
                        System.out.println(medDistValue + "m. = " + result + "ft.");
                    }
                    break;
                case 4: // Long distance conversions
                    System.out.println("1. Miles to Kilometers");
                    System.out.println("2. Kilometers to Miles");
                    System.out.print("Enter choice: ");
                    int largeDistChoice = scanner.nextInt();

                    System.out.print("Enter distance value: ");
                    String largeDistValue = scanner.next();

                    if (largeDistChoice == 1)
                    {
                        float result = convertM2K(largeDistValue, decimalPrecision);
                        System.out.println(largeDistValue + "mi. = " + result + "km.");
                    } else if (largeDistChoice == 2)
                    {
                        float result = convertK2M(largeDistValue, decimalPrecision);
                        System.out.println(largeDistValue + "km. = " + result + "m.");
                    }
                    break;
                case 5: // Volume conversions
                    System.out.println("1. Gallons to Liters");
                    System.out.println("2. Liters to Gallons");
                    System.out.print("Enter choice: ");
                    int volChoice = scanner.nextInt();

                    System.out.print("Enter volume value: ");
                    String volValue = scanner.next();

                    if (volChoice == 1)
                    {
                        float result = convertG2L(volValue, decimalPrecision);
                        System.out.println(volValue + "gal. = " + result + "L.");
                    } else if (volChoice == 2)
                    {
                        float result = convertL2G(volValue, decimalPrecision);
                        System.out.println(volValue + "L. = " + result + "gal.");
                    }
                    break;
                case 6: // Small weight conversions
                    System.out.println("1. Ounces to Grams");
                    System.out.println("2. Grams to Ounces");
                    System.out.print("Enter choice: ");
                    int smallweightChoice = scanner.nextInt();

                    System.out.print("Enter weight value: ");
                    String smallweightValue = scanner.next();

                    if (smallweightChoice == 1)
                    {
                        float result = convertOz2G(smallweightValue, decimalPrecision);
                        System.out.println(smallweightValue + "oz. = " + result + "g.");
                    } else if (smallweightChoice == 2)
                    {
                        float result = convertG2Oz(smallweightValue, decimalPrecision);
                        System.out.println(smallweightValue + "g. = " + result + "oz.");
                    }
                    break;
                case 7: // Medium weight conversions
                    System.out.println("1. Pounds to Kilograms");
                    System.out.println("2. Kilograms to Pounds");
                    System.out.print("Enter choice: ");
                    int medweightChoice = scanner.nextInt();

                    System.out.print("Enter weight value: ");
                    String medweightValue = scanner.next();

                    if (medweightChoice == 1)
                    {
                        float result = convertLb2K(medweightValue, decimalPrecision);
                        System.out.println(medweightValue + "lbs. = " + result + "kg.");
                    } else if (medweightChoice == 2)
                    {
                        float result = convertK2Lb(medweightValue, decimalPrecision);
                        System.out.println(medweightValue + "kg. = " + result + "lbs.");
                    }
                    break;  // Invalid inputs
                case 8:
                    System.out.println("1. Hours to Seconds");
                    System.out.println("2. Seconds to Hours");
                    System.out.print("Enter choice: ");
                    int timeChoice = scanner.nextInt();

                    System.out.print("Enter time value: ");
                    String timeValue = scanner.next();

                    if (timeChoice == 1)
                    {
                        float result = convertHr2Sec(timeValue, decimalPrecision);
                        System.out.println(timeValue + "hr. = " + result + "sec.");
                    } else if (timeChoice == 2) {
                        float result = convertSec2Hr(timeValue, decimalPrecision);
                        System.out.println(timeValue + "sec. = " + result + "hr.");
                    }
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
        // Close scanner
        scanner.close();
    }
}