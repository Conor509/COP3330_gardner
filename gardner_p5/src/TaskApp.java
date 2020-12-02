import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.io.FileWriter;

public class TaskApp {
    static BufferedReader read;
    static FileWriter w;

    public static void TaskApp() {
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
                        option = PrintTaskListOp();

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
                    File f = new File(fileName + ".txt");
                    if(!f.exists()) {
                        System.out.println("Error: This file does not exist.");
                        break;
                    }
                    TaskList load_list = new TaskList(fileName);
                    while(option != 8) {
                        option = PrintTaskListOp();

                        switch(option) {
                            case 1:
                                load_list.viewList();
                                break;
                            case 2:
                                load_list.addItem();
                                System.out.println("Successfully Added Item!");
                                break;
                            case 3:
                                load_list.editItem();
                                System.out.println("Successfully Edited Item!");
                                break;
                            case 4:
                                load_list.removeItem();
                                System.out.println("Successfullly Removed Item!");
                                break;
                            case 5:
                                load_list.itemCompleted();
                                System.out.println("Successfully Marked Item!");
                                break;
                            case 6:
                                load_list.itemIncompleted();
                                System.out.println("Successfully Unmarked Item!");
                                break;
                            case 7:
                                saved = load_list.saveList();
                                System.out.println("Successfully Saved List!");
                                break;
                        }
                    }

            }
            PrintMenu();
            choice = scnr.nextInt();
        }
    }
    public static int PrintTaskListOp(){
        System.out.println("");
        System.out.println("Task List Operation Menu");
        System.out.println("-------------------");
        System.out.println("1) view the Task list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as completed");
        System.out.println("6) un-mark an item as completed");
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
        System.out.println("1) create a new Task list");
        System.out.println("2) load an existing Task list");
        System.out.println("3) quit to app selection");
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
            //currList.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}