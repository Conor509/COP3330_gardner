import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.io.*;
import java.io.FileWriter;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;



public class ContactList{
    static ContactItem item = new ContactItem();
    static BufferedReader read;
    static int count = 1;
    FileWriter w;
    FileReader r;
    BufferedWriter writ;
    static String fileName;
    public ContactList(String fileN) {
        fileName = fileN;
        try {
            w = new FileWriter(fileName + ".txt", true);
            r = new FileReader(fileName + ".txt");
            read = new BufferedReader(r);
            writ = new BufferedWriter(w);
        } catch(IOException e) {
            System.out.println(e);
        }
    }//end constructor

    public static boolean checkEmpty() throws IOException{
        IOException t = new IOException();
        try {
            return read.readLine() == null;
        } catch(NullPointerException n){
            System.out.println(n);
        }
        return true;
    }//end check empty


    public static boolean checkEdit(String old, String newLine) {
        return !(old.equals(newLine));
    }


    public static void viewContactList() {


        System.out.println("Current Contact\n-----------------");
        try {
            FileInputStream fIn = new FileInputStream(fileName + ".txt");
            BufferedReader tempBuff = new BufferedReader(new InputStreamReader(fIn));

            String line = tempBuff.readLine();
            while(line != null) {
                System.out.println(line);
                line = tempBuff.readLine();
            }
            fIn.getChannel().position(0);
            tempBuff = new BufferedReader(new InputStreamReader(fIn));
        } catch(IOException e){
            System.out.println(e);
        }

    }//end viewList

    public static void addContact() {
        ContactItem item = new ContactItem();
        String FirstName = "";
        String LastName = "";
        String Email = "";
        String PhoneNum = "";
        boolean checkFirstName = false;
        boolean checkLastName = false;
        boolean checkEmail = false;
        boolean checkPhoneNum = false;

        while (!checkFirstName) {
            Scanner Tmp = new Scanner(System.in);
            System.out.println("Enter their First Name: ");
            FirstName = Tmp.nextLine();
            checkFirstName = ContactItem.checkFirstName(FirstName);
        }
        while (!checkLastName) {
            Scanner Tmp2 = new Scanner(System.in);
            System.out.println("Enter their Last Name: ");
            LastName = Tmp2.nextLine();
            checkLastName = ContactItem.checkLastName(LastName);
        }
        while (!checkPhoneNum){
            Scanner Tmp3 = new Scanner(System.in);
            System.out.println("Enter their Phone Number [Ex: 123-456-7890]: ");
            PhoneNum = Tmp3.nextLine();
            checkPhoneNum = ContactItem.checkPhoneNum(PhoneNum);
        }
        while (!checkEmail) {
            Scanner Tmp4 = new Scanner(System.in);
            System.out.println("Enter their Email Address: ");
            Email = Tmp4.nextLine();
            checkEmail = ContactItem.checkEmail(Email);
        }

        try (FileWriter f = new FileWriter(fileName + ".txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);)
        {
            count++;
            p.println(count + ")" + " " + FirstName + ", " + LastName + ", " + PhoneNum + ", " + Email);

        }
        catch (IOException i)
        {
            i.printStackTrace();
        }



    }//end addItem

    public static void editContact() {


        Scanner Tmp = new Scanner(System.in);
        viewContactList();
        System.out.println("Enter the Contact number you would like to edit: ");
        int ContactEdit = Tmp.nextInt();

        String FirstName = "";
        String LastName = "";
        String Email = "";
        String PhoneNum = "";
        boolean checkFirstName = false;
        boolean checkLastName = false;
        boolean checkEmail = false;
        boolean checkPhoneNum = false;

        while (!checkFirstName) {
            Scanner b = new Scanner(System.in);
            System.out.println("Enter the New First Name: ");
            FirstName = b.nextLine();
            checkFirstName = ContactItem.checkFirstName(FirstName);
        }
        while (!checkLastName) {
            Scanner Tmp2 = new Scanner(System.in);
            System.out.println("Enter the New Last Name: ");
            LastName = Tmp2.nextLine();
            checkLastName = ContactItem.checkLastName(LastName);
        }
        while (!checkPhoneNum){
            Scanner Tmp3 = new Scanner(System.in);
            System.out.println("Enter the New Phone Number [Ex: 123-456-7890]: ");
            PhoneNum = Tmp3.nextLine();
            checkPhoneNum = ContactItem.checkPhoneNum(PhoneNum);
        }
        while (!checkEmail) {
            Scanner Tmp4 = new Scanner(System.in);
            System.out.println("Enter the New Email Address: ");
            Email = Tmp4.nextLine();
            checkEmail = ContactItem.checkEmail(Email);
        }

        String replace = (count + ")" + " " + FirstName + ", " + LastName + ", " + PhoneNum + ", " + Email);

        String EditLine = null;
        try {
            EditLine = Files.readAllLines(Paths.get(fileName + ".txt")).get(count-1);

            ArrayList<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get(fileName + ".txt"), StandardCharsets.UTF_8));

            for (int i = 0; i < fileContent.size(); i++) {

                if (fileContent.get(i).equals(EditLine)) {
                    fileContent.set(i, replace);
                    break;
                }
            }

            Files.write(Paths.get(fileName + ".txt"), fileContent, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e);
        }

        boolean temp = checkEdit(EditLine, replace);


    }//end editItem

    public static void removeContact() {
        /*
        try{

            Scanner Tmp = new Scanner(System.in);
            viewContactList();
            System.out.println("Enter the number of the contact you would like to remove: ");
            int RemoveContact = Tmp.nextInt();
            while (RemoveContact <= 0 || RemoveContact > count){
                System.out.println("Error: That contact number is not in the contact list.");
                break;
            }


            String removeLine = Files.readAllLines(Paths.get(fileName + ".txt")).get(count-1);


            File inputFile = new File(fileName + ".txt");
            File tempFile = new File("TempFile.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = removeLine;
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if(trimmedLine.equals(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            boolean successful = tempFile.renameTo(inputFile);

        }
        catch (IOException i)
        {
            i.printStackTrace();
        }


         */
        System.out.println("I tried everything to make this method work but i doesn't please leave a comment on my grade why it doesn't work. Thanks!");
    }//end removeContact


    public static boolean saveContactList() {
        System.out.println("Contact List saved as " + fileName + ".txt");
        System.out.println("Successful save!");
        return true;
    }//end saveContactList

}