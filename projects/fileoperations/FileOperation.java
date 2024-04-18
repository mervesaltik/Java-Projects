package fileoperations;

import java.io.*;
import java.util.Scanner;

public class FileOperation {
    public static void main(String[] args) {
        // Create a folder on the desktop
        String desktopPath = System.getProperty("user.home") + "/Desktop";
        String folderName = "MyFolder";
        File folder = new File(desktopPath, folderName);
        boolean folderCreated = folder.mkdir(); // Try to create the folder
        if (folderCreated) {
            System.out.println("Folder created: " + folder.getAbsolutePath());
        } else {
            System.out.println("Folder already exists or creation failed.");
        }

        // Create a text file in the folder
        String fileName = "UserData.txt";
        File file = new File(folder, fileName);
        try {
            boolean fileCreated = file.createNewFile();
            if (fileCreated) {
                System.out.println("File created: " + file.getAbsolutePath());
            } else {
                System.out.println("File already exists or creation failed.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file: " );
            throw new RuntimeException();
        }

        // Write data to the text file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)); // Append mode
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter data to write to the file:");
            String data = scanner.nextLine();
            writer.write(data);
            writer.newLine(); // Add a newline character
            writer.close();
            System.out.println("Data written to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred while creating the file: " );
            throw new RuntimeException();
        }

        // Read the contents of the text file
        try{
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            throw new RuntimeException();
        }

        // List all information about the file
        System.out.println("File information:");
        System.out.println("Name: " + file.getName());
        System.out.println("Path: " + file.getAbsolutePath());
        System.out.println("Size (in bytes): " + file.length());

        //Delete the file
        if (file.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.err.println("Failed to delete the file.");
        }
    }
}

