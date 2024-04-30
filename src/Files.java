import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Files {
    public static void showFile(File file, HashMap<String, JTextArea> textAreasz){
        try {

            for (int i = 0; i < textAreasz.size(); i++) {
                JTextArea textArea = textAreasz.get(String.valueOf(i+1));
                textArea.setText("");
            }
            int counter = 0;
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                JTextArea textArea = textAreasz.get(String.valueOf(counter+1));
                textArea.setText(line);
                counter++;

            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeToFile(File file, HashMap<String, JTextArea> textAreas) {
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file));
            for (int i = 0; i < textAreas.size(); i++) {
                JTextArea textArea = textAreas.get(String.valueOf(i+1));
                writer.write(textArea.getText());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
