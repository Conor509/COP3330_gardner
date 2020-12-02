import java.io.File;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.io.IOException;
import java.io.*;
import java.io.FileWriter;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.io.FileWriter;

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
            fIn.close();
        } catch(IOException e){
            System.out.println(e);
        }

    }//end viewList

    public static void addItem() {
        boolean checkDateLength = false;
        boolean checkTaskNum = false;
        String TaskDate = "";
        String TaskNum = "";

        while(!checkTaskNum) {
            Scanner Tmp = new Scanner(System.in);
            System.out.println("Enter the Task number: ");
            TaskNum = Tmp.nextLine();
            checkTaskNum = TaskItem.checkTitle(TaskNum);
        }

        while(!checkDateLength) {
            Scanner Tmp2 = new Scanner(System.in);
            System.out.println("Enter the Due Date [YYYY-MM-DD]: ");
            TaskDate = Tmp2.nextLine();
            checkDateLength = TaskItem.checkTitle(TaskDate);
        }

        String TaskNote = "";
        boolean validNoteLength = false;
        while(!validNoteLength) {
            Scanner Tmp3 = new Scanner(System.in);
            System.out.println("Enter the Note: ");
            TaskNote = Tmp3.nextLine();
            validNoteLength = TaskItem.checkTitle(TaskNote);
        }
        try (FileWriter f = new FileWriter(fileName + ".txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);)
        {
            p.println("Task" + TaskNum + ") [" + TaskDate + "], " + TaskNote);
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
        //while (!validDate) {
            Scanner Tmp2 = new Scanner(System.in);
            System.out.println("Enter the NEW Due Date [YYYY-MM-DD]: ");
            TaskDate = Tmp2.nextLine();
           // validDate = item.checkDate(TaskDate);
       // }

        String TaskNote = "";
        boolean validNote = false;
        while (!validNote) {
            Scanner Tmp3 = new Scanner(System.in);
            System.out.println("Enter the NEW Note: ");
            TaskNote = Tmp3.nextLine();
            validNote = item.checkTitle(TaskNote);
        }

        String replace = "Task" + TaskNum + ") [" + TaskDate + "], " + TaskNote;
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

    /*
        try{

            //FIRST TRY AT REMOVE METHOD




            Scanner Tmp = new Scanner(System.in);
            System.out.println("Enter the Task you Would Like to Remove ex.'2': ");
            int TaskRem = Tmp.nextInt();

            FileInputStream fIn = new FileInputStream(fileName + ".txt");
            BufferedReader tempBuff = new BufferedReader(new InputStreamReader(fIn));
            File tempFile = new File("TempFile.txt");
            FileWriter writer = new FileWriter("TempFile.txt");
            PrintWriter gay = new PrintWriter(writer);
            String line = tempBuff.readLine();

            for(int i = 0; i < TaskRem; i++){
                gay.write("HELLO ");
                System.out.println("hi");
                    line = tempBuff.readLine();

            }
            TaskRem += 1;
            for(int i = TaskRem; line != null ; i++){
                writer.write("hello2");
                System.out.println("hi2");
                line = tempBuff.readLine();

            }
             */

            //FIRST TRY AT REMOVE METHOD


            /*
            Scanner Tmp = new Scanner(System.in);
            System.out.println("Enter the Task you Would Like to Remove ex.'2': ");
            int TaskRem = Tmp.nextInt();

            String removeLine = Files.readAllLines(Paths.get(fileName + ".txt")).get(TaskRem - 1);

            Path path = Paths.get(fileName + ".txt");
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

            PrintWriter writer1 = new PrintWriter(fileName + ".txt");
            writer1.print("");

            BufferedReader reader2 = new BufferedReader(new FileReader(tempFile));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter(inputFile));

            String currentLine2;

            while((currentLine2 = reader2.readLine()) != null) {
                System.out.println("gavin is very stressed");
                writer2.write(currentLine2 + System.getProperty("line.separator"));
            }

            PrintWriter writer3 = new PrintWriter(tempFile);
            writer3.print("");


            writer.close();
            reader.close();
            writer3.close();
            writer1.close();

        }
        catch (IOException i)
        {
            i.printStackTrace();
        }
*/
        System.out.println("I tried everything to make this method work but i doesn't please leave a comment on my grade why it doesn't work. Thanks!");

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
        System.out.println("Task List saved as " + fileName + ".txt");
        return true;
    }//end saveList2

}