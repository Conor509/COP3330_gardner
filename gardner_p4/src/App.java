import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.io.FileWriter;

public class App {
    static BufferedReader read;
    static FileWriter w;

    public static void main(String[] args) {
        PrintMenu();
        Scanner scnr = new Scanner(System.in);
        int choice = 0;
        choice = scnr.nextInt();
        while (choice != 3) {
            boolean saved = false;
            int option = 0;
            String fileName;

            switch(choice) {
                case 1:

                    Scanner createName = new Scanner(System.in);
                    System.out.println("Enter the name of the list you would like to create ->");
                    fileName = createName.nextLine();
                    CreateFile(fileName);
                    TaskList create_list = new TaskList(fileName);
                    while(option != 8) {
                        option = PrintListOp();

                        switch(option) {
                            case 1:
                                create_list.viewList();
                                break;
                            case 2:
                                create_list.addItem();
                                break;
                            case 3:
                                create_list.editItem();
                                break;
                            case 4:
                                create_list.removeItem();
                                break;
                            case 5:
                                create_list.itemCompleted();
                                break;
                            case 6:
                                create_list.itemIncompleted();
                                break;
                            case 7:
                                saved = create_list.saveList();
                                break;
                        }
                    }

                    break;

                case 2:
                    Scanner loadName = new Scanner(System.in);
                    System.out.println("Enter the name of the file (without .txt) -> ");
                    fileName = loadName.nextLine();
                    TaskList load_list = new TaskList(fileName);
                    while(option != 8) {
                        option = PrintListOp();

                        switch(option) {
                            case 1:
                                load_list.viewList();
                                break;
                            case 2:
                                load_list.addItem();
                                break;
                            case 3:
                                load_list.editItem();
                                break;
                            case 4:
                                load_list.removeItem();
                                break;
                            case 5:
                                load_list.itemCompleted();
                                break;
                            case 6:
                                load_list.itemIncompleted();
                                break;
                            case 7:
                                saved = load_list.saveList();
                                break;
                        }
                    }

            }
            PrintMenu();
            choice = scnr.nextInt();
        }
    }
    public static int PrintListOp(){
        System.out.println("");
        System.out.println("List Operation Menu");
        System.out.println("-------------------");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu");
        System.out.println("-------------------");
        Scanner create = new Scanner(System.in);
        int choice_create = create.nextInt();
        return choice_create;
    }

    public static void PrintMenu(){
        System.out.println("");
        System.out.println("Main Menu");
        System.out.println("-------------------");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
        System.out.println("-------------------");
    }

    public static void CreateFile(String fileName){
        File currList = new File(fileName + ".txt");
        try {
            if(currList.createNewFile()) {
                System.out.println("File created: " + currList.getName());
            } else {
                System.out.println("File already exists");
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /*public static File LoadFile(String fileName) {
      File currList = new File(fileName + ".txt");
      return currList;
    }*/


}