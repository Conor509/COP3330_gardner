import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.text.DecimalFormat;

public class App {
    private static DecimalFormat df2 = new DecimalFormat("#.#");

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }
    public static double getUserWeight() {
        Scanner in = new Scanner(System.in);
        System.out.print("How many pounds do you Weight? ");
        double userWeight = in.nextDouble();
        if(userWeight >0) {
            return userWeight;
        }
        else
            System.out.println("Error: Weight Cannot be less than 1.");
            return getUserWeight();
    }


    public static double getUserHeight() {
        Scanner in = new Scanner(System.in);
        System.out.print("What is your Height in inches? ");
        double userHeight = in.nextDouble();
        if(userHeight >0) {
            return userHeight;
        }
        else
            System.out.println("Error: Weight Cannot be less than 1.");
        return getUserHeight();
    }
    public static boolean moreInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("Would you like to add more input? (Y = Yes || N = No) : ");
        char choice = in.next().charAt(0);
        if (choice == 'y' || choice == 'Y'){
            return true;
        }
        else return false;
    }

    public static void displayBmiInfo(BodyMassIndex bmi){
        bmi.printBMIResult();
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){
        int i = 0;
        double sum = 0;
        double avg;
        Iterator<BodyMassIndex> iterate = bmiData.iterator();
        while(iterate.hasNext())
        {
            BodyMassIndex b = iterate.next();
            double info = bmiData.get(i).getInfo();
            sum += info;
            i++;
        }
        avg = sum/bmiData.size();
        System.out.print("The Average BMI of your inputs is: " + df2.format(avg));
    }
}
