import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.io.*;
import java.io.FileWriter;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;


public class TaskList{
    static TaskItem item = new TaskItem();
    static BufferedReader read;
    FileWriter w;
    FileReader r;
    BufferedWriter writ;
    static String fileName;
    public TaskList(String fileN) {
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

    public static boolean checkIncomplete(String old, String newLine) {
        return old.length() - 4 == newLine.length();
    }//end check incomplete

    public boolean checkEdit(String old, String newLine) {
        return !(old.equals(newLine));
    }


    public void viewList() {


        System.out.println("Current Tasks\n-----------------");
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

    public static void addItem() {
        Scanner Tmp = new Scanner(System.in);
        System.out.println("Enter the Task number: ");
        String TaskNum = Tmp.nextLine();
        String TaskDate = "";
        boolean validDate = false;
        while(!validDate) {
            Scanner Tmp2 = new Scanner(System.in);
            System.out.println("Enter the Due Date [YYYY-MM-DD]: ");
            TaskDate = Tmp2.nextLine();
            validDate = item.checkDate(TaskDate);
        }

        String TaskNote = "";
        boolean validNote = false;
        while(!validNote) {
            Scanner Tmp3 = new Scanner(System.in);
            System.out.println("Enter the Note: ");
            TaskNote = Tmp3.nextLine();
            validNote = item.checkTitle(TaskNote);
        }
        try (FileWriter f = new FileWriter(fileName + ".txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);)
        {
            p.println("Task" + TaskNum + ") " + TaskDate + " " + TaskNote);
        }
        catch (IOException i)
        {
            i.printStackTrace();
        }



    }//end addItem

    public void editItem() {

        Scanner Tmp = new Scanner(System.in);
        System.out.println("Enter the Task Number you Would Like to Re-type ex.'2': ");
        int TaskEdit = Tmp.nextInt();

        System.out.println("Enter the NEW Task number: ");
        String TaskNum = Tmp.nextLine();
        TaskNum = Tmp.nextLine();
        String TaskDate = "";
        boolean validDate = false;
        while (!validDate) {
            Scanner Tmp2 = new Scanner(System.in);
            System.out.println("Enter the NEW Due Date [YYYY-MM-DD]: ");
            TaskDate = Tmp2.nextLine();
            validDate = item.checkDate(TaskDate);
        }

        String TaskNote = "";
        boolean validNote = false;
        while (!validNote) {
            Scanner Tmp3 = new Scanner(System.in);
            System.out.println("Enter the NEW Note: ");
            TaskNote = Tmp3.nextLine();
            validNote = item.checkTitle(TaskNote);
        }

        String replace = "Task" + TaskNum + ") " + TaskDate + " " + TaskNote;
        String EditLine = null;
        try {
            EditLine = Files.readAllLines(Paths.get(fileName + ".txt")).get(TaskEdit - 1);

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

    public static void removeItem() {
        try{
            Scanner Tmp = new Scanner(System.in);
            System.out.println("Enter the Task you Would Like to Remove ex.'2': ");
            int TaskRem = Tmp.nextInt();

            String removeLine = Files.readAllLines(Paths.get(fileName + ".txt")).get(TaskRem - 1);


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

    }//end removeItem

    public void itemCompleted() {
        Scanner Tmp = new Scanner(System.in);
        System.out.println("Enter the Task Number you would like to complete ex.'2': ");
        int TaskEdit = Tmp.nextInt();
        try {
            String EditLine = Files.readAllLines(Paths.get(fileName + ".txt")).get(TaskEdit - 1);

            ArrayList<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get(fileName + ".txt"), StandardCharsets.UTF_8));

            for (int i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).equals(EditLine)) {
                    fileContent.set(i, "*** " + EditLine);
                    break;
                }
            }

            Files.write(Paths.get(fileName + ".txt"), fileContent, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e);
        }

    }//end itemCompleted()

    public void itemIncompleted() {
        Scanner Tmp = new Scanner(System.in);
        System.out.println("Enter the Task Number you would like to incomplete ex.'2': ");
        int TaskEdit = Tmp.nextInt();
        String EditLine = null;
        try {
            EditLine = Files.readAllLines(Paths.get(fileName + ".txt")).get(TaskEdit - 1);

            ArrayList<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get(fileName + ".txt"), StandardCharsets.UTF_8));


            for (int i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).equals(EditLine)) {
                    fileContent.set(i, EditLine.substring(4, EditLine.length()));
                    break;
                }
            }

            Files.write(Paths.get(fileName + ".txt"), fileContent, StandardCharsets.UTF_8);
            String NewLine = Files.readAllLines(Paths.get(fileName + ".txt")).get(TaskEdit - 1);
            boolean temp = checkIncomplete(EditLine, NewLine);
        } catch (IOException e) {
            System.out.println(e);
        }


    }//end itemIncompleted

    public static boolean saveList() {
        System.out.println("List saved as " + fileName + ".txt");
        return true;
    }//end saveList2

}