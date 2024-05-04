import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Files {
    public static void showFile(File file, HashMap<String, JTextArea> textAreasz){
        try {

            for (HashMap.Entry<String, JTextArea> entry : textAreasz.entrySet()) {
                JTextArea textArea = entry.getValue();
                textArea.setText("");
            }
            Scanner scanner = new Scanner(file);
                for(HashMap.Entry<String, JTextArea> entry : textAreasz.entrySet()){
                    if(scanner.hasNextLine()){
                    JTextArea textArea = entry.getValue();
                    textArea.setText(scanner.nextLine());
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeToFile(File file, HashMap<String, JTextArea> textAreas) {
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file));
            for (HashMap.Entry<String, JTextArea> entry : textAreas.entrySet()) {
                JTextArea textArea = entry.getValue();
                writer.write(textArea.getText());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
