package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Connection {

    String filename1 = "Sign_up.txt";
    String filename2 = "Log_in.txt";
    String filename3 = "Student.txt";
    Scanner x;
    File tempFile;

    public void writetoSignup(String d) throws IOException {
        FileWriter file = new FileWriter(filename1, true);
        BufferedWriter w = new BufferedWriter(file);
        w.write(d);
        w.write("\n");
        w.close();
       
    }

    public void writetoLogin(String d) throws IOException {
        FileWriter file = new FileWriter(filename2, true);
        BufferedWriter w = new BufferedWriter(file);
        w.write(d);
        w.write("\n");
        w.close();
    }
    
    public void writetoStudent(String d) throws IOException {
        FileWriter file = new FileWriter(filename3, true);
        BufferedWriter w = new BufferedWriter(file);
        w.write(d);
        w.write("\n");
        w.close();
    }

    public void openLoginFile() {
        try {
            x = new Scanner(new File(filename2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void openStudentFile() {
        try {
            x = new Scanner(new File(filename3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   
    public boolean readLoginFile(String n, String p) {
        boolean status = false;
        String tempn = n;
        String tempp = p;
        while (x.hasNext()) {
            String a = x.next();
            String b = x.next();
            if (tempn.equals(a) && tempp.equals(b)) {
                status = true;
            }
        }
        x.close();
        return status;
    }
    
    public boolean readStudentFile(String del) {
        boolean status = false;
        String temp = del;
        while (x.hasNext()) {
            String a = x.next();
            if (temp.equals(a) ) {
                status = true;
            }
        }
        x.close();
        return status;
    }
    
  
    
    public void deleteTextFromFile(String textToDelete) throws FileNotFoundException {
        File file = new File(filename3);
        tempFile = new File("tempFile.txt");
        try (Scanner scanner = new Scanner(file);
             PrintWriter writer = new PrintWriter(tempFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.contains(textToDelete)) {
                    writer.println(line);
                }
                
                
            }
            scanner.close();
            writer.close();
            
            file.delete();
            tempFile.renameTo(file);
        }
    }
    
    public void searchTextFromFile(String text) throws FileNotFoundException {
        File file = new File(filename3);
        tempFile = new File("tempFile.txt");
        try (Scanner scanner = new Scanner(file);
             PrintWriter writer = new PrintWriter(tempFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(text)) {
                    writer.println(line);
                }
                
                
            }
            scanner.close();
            writer.close();
            
        }
    }
    
    public void deleteSearchFile() {
    	tempFile.delete();
    }

    public static void main(String[] args) throws IOException {
        
        
    }
}

