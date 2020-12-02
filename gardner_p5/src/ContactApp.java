import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.io.FileWriter;

public class ContactApp {
    static BufferedReader read;
    static FileWriter w;

    public static void ContactApp() {
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
                    System.out.println("Enter the name of the Contact list you would like to create ->");
                    fileName = createName.nextLine();
                    CreateFile(fileName);
                    ContactList create_contact = new ContactList(fileName);
                    while(option != 6) {
                        option = PrintContactListOp();

                        switch(option) {
                            case 1:
                                create_contact.viewContactList();
                                break;
                            case 2:
                                create_contact.addContact();
                                break;
                            case 3:
                                create_contact.editContact();
                                break;
                            case 4:
                                create_contact.removeContact();
                                break;
                            case 5:
                                saved = create_contact.saveContactList();
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
                    ContactList load_list = new ContactList(fileName);
                    while(option != 6) {
                        option = PrintContactListOp();

                        switch(option) {
                            case 1:
                                load_list.viewContactList();
                                break;
                            case 2:
                                load_list.addContact();
                                break;
                            case 3:
                                load_list.editContact();
                                break;
                            case 4:
                                load_list.removeContact();
                                break;
                            case 5:
                                saved = load_list.saveContactList();
                                break;
                        }
                    }

            }
            PrintMenu();
            choice = scnr.nextInt();
        }
    }
    public static int PrintContactListOp(){
        System.out.println("Contact List Operation Menu");
        System.out.println("-------------------");
        System.out.println("1) view the Contact list");
        System.out.println("2) add a contact");
        System.out.println("3) edit a contact ");
        System.out.println("4) remove a contact");
        System.out.println("5) Save current contact list");
        System.out.println("6) quit to the main menu");
        System.out.println("-------------------");
        Scanner create = new Scanner(System.in);
        int choice_create = create.nextInt();
        return choice_create;
    }

    public static void PrintMenu(){
        System.out.println("Main Menu");
        System.out.println("-------------------");
        System.out.println("1) create a contact list");
        System.out.println("2) load an existing contact list");
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
}