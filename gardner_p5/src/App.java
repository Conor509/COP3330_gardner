import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        PrintAppSelection();
        Scanner scnr = new Scanner(System.in);
        int choice = 0;
        choice = scnr.nextInt();
        while (choice != 3) {
            boolean saved = false;
            int option = 0;

            switch (choice) {
                case 1:
                    TaskApp.TaskApp();
                    break;
                case 2:
                    ContactApp.ContactApp();
                    break;
            }
            PrintAppSelection();
            choice = scnr.nextInt();
        }
    }

    public static void PrintAppSelection() {
        System.out.println("");
        System.out.println("Select Your Application");
        System.out.println("-------------------");
        System.out.println("1) Task list");
        System.out.println("2) Contact list");
        System.out.println("3) Quit");
        System.out.println("-------------------");
    }
}

