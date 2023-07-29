import java.text.DecimalFormat;
import java.util.Scanner;

public class BMIcalculator{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Weight in Kg: ");
        double weight = sc.nextDouble();

        System.out.println("Enter height feet: ");
        int heightFeet = sc.nextInt();

        System.out.println("Enter height in Inches: ");
        int heightInches = sc.nextInt();

        int totalHeightInches = (heightFeet * 12) + heightInches;

        double bmi = weight / Math.pow(totalHeightInches, 2) * 703;

        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println("Your BMI is: " + df.format(bmi));

        
    }
}