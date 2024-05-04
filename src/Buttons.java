import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.HashMap;

public class Buttons {
    public static void addButton(JButton button, HashMap przycisk, HashMap Jtextarea, JFrame frame) {
        button.setBackground(new Color(255, 208, 79));
        button.setFont(new Font("Arial", Font.PLAIN, 12));
        button.setPreferredSize(new Dimension(75*frame.getWidth()/1000, 50*frame.getHeight()/1000)  );
        button.setVisible(true);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        create.choosemenu.add(button);
        przycisk.put(button.getText(), button);
        create.layout.setConstraints(button, create.gbc);
        button.addActionListener(e -> {
            create.currentFile = new File("src/files/" + button.getText() + ".txt");
            Files.showFile(create.currentFile,Jtextarea);
            create.panel2.add(create.label);
            create.panel2.revalidate();
            create.panel2.repaint();
        });


    }
    public static void addWeekButtons(HashMap przyciski, HashMap Jtextarea, JFrame frame){
        JButton monday = new JButton("monday");
        addButton(monday, przyciski, Jtextarea, frame);
        JButton tuesday = new JButton("tuesday");
        addButton(tuesday,przyciski , Jtextarea, frame);
        JButton thurdsay = new JButton("wednesday");
        addButton(thurdsay,przyciski, Jtextarea, frame);
        JButton wednesday = new JButton("thursday");
        addButton(wednesday, przyciski, Jtextarea, frame);
        JButton friday = new JButton("friday");
        addButton(friday , przyciski, Jtextarea, frame);
        JButton saturday = new JButton("saturday");
        addButton(saturday, przyciski, Jtextarea, frame);
        JButton sunday = new JButton("sunday");
        addButton(sunday, przyciski, Jtextarea, frame);
    }
    public static void saveButton(HashMap textareas){
        JButton save = new JButton("Save");
       save.addActionListener(e -> Files.writeToFile(create.currentFile, textareas));
        create.panel2.add(save);
    }
    public static void showFrame2(JFrame frame2){
        JButton show = new JButton("Show");
        show.addActionListener(e -> {
            frame2.setVisible(true);
            frame2.revalidate();
            frame2.repaint();
        });
        create.panel2.add(show);
    }
    public static void hideFrame2(JFrame frame2){
        JButton hide = new JButton("Hide");
        hide.addActionListener(e -> {
            frame2.setVisible(false);
            frame2.revalidate();
            frame2.repaint();
        });
        create.panel2.add(hide);
    }
}
