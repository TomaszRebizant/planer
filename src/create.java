import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;


public class create extends JFrame {
    public static JFrame frame;
    public static JPanel choosemenu;
    private static JPanel panel2;
    public static File currentFile = new File("src/files/monday.txt");

    static GridBagConstraints gbc = new GridBagConstraints();

    static GridBagLayout layout = new GridBagLayout();

    private static final HashMap<String, JButton> buttons = new HashMap<>();
    private static final HashMap<String, JTextArea> textAreas = new HashMap<String, JTextArea>();
    private static final JLabel label = new JLabel();

    private  static final JTextArea[] table = new JTextArea[48];




    public create() {
        setFrame();
        createAndShowGUI();
    }

    public static void createAndShowGUI() {
        setChooseMenu(frame.getWidth()/7, frame.getWidth()/7);
        setPanel2(frame.getWidth(), frame.getHeight());
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addWeekButtons();
        choosemenu.setLayout(layout);
        resize(choosemenu, frame);
        panel2.add(label);
        panel2.setLayout(layout);
        createTextArea();
        frame.revalidate();
        frame.repaint();


    }

        public static void resize(JPanel choosemenu, JFrame frame){

            frame.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    choosemenu.setPreferredSize(new Dimension(frame.getWidth()/7, frame.getHeight()));
                    for (JButton button : buttons.values()) {
                        button.setPreferredSize(new Dimension(90*frame.getWidth()/1000, 75*frame.getHeight()/1000));
                    }
                    frame.revalidate();
                    frame.repaint();
                }
            });
        }

    public static void setChooseMenu(int width, int height) {
        choosemenu = new JPanel();
        choosemenu.setPreferredSize(new Dimension(width, height));
        frame.add(choosemenu, BorderLayout.WEST);
        choosemenu.setBackground(new Color(235, 230, 206));

    }
public static void setFrame() {
    frame = new JFrame();
    frame.setTitle("Plan dnia");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1000, 700);
    frame.setLayout(new BorderLayout(1, 1));
    frame.setVisible(true);
}
 public static void setPanel2(int width, int height) {
        panel2 = new JPanel();
        panel2.setSize(width, height);
        panel2.setLayout(new BorderLayout(1, 1));
        frame.add(panel2, BorderLayout.CENTER);
        panel2.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        frame.add(scrollPane);

    }
    public static void addButton(JButton button) {
        button.setBackground(new Color(255, 208, 79));
        button.setFont(new Font("Arial", Font.PLAIN, 12));
        button.setPreferredSize(new Dimension(75*frame.getWidth()/1000, 50*frame.getHeight()/1000)  );
        button.setVisible(true);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        choosemenu.add(button);
        buttons.put(button.getText(), button);
        layout.setConstraints(button, gbc);
        button.addActionListener(e -> {
            currentFile = new File("src/files/" + button.getText() + ".txt");
            showFile(currentFile);
            panel2.add(label);
            panel2.revalidate();
            panel2.repaint();
        });


    }
    public static void addTextField(JTextField textField) {
        textField.setPreferredSize(new Dimension(75*frame.getWidth()/1000, 50*frame.getHeight()/1000));
        textField.setVisible(true);
        textField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel2.add(textField);
        layout.setConstraints(textField, gbc);
    }
    public static void addTextArea(JTextArea textArea) {
        textArea.setPreferredSize(new Dimension(75*frame.getWidth()/1000, 88*frame.getHeight()/1000));
        textArea.setRows(10);
        textArea.setColumns(10);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMinimumSize(new Dimension(75*frame.getWidth()/1000, 44*frame.getHeight()/1000));
        textArea.setBackground(new Color(208, 60, 187));
        panel2.add(textArea, gbc);
        textAreas.put(textArea.getText(), textArea);
    }
    public static void addWeekButtons(){
        JButton monday = new JButton("monday");
        addButton(monday);
        JButton tuesday = new JButton("tuesday");
        addButton(tuesday);
        JButton thurdsay = new JButton("wednesday");
        addButton(thurdsay);
        JButton wednesday = new JButton("thursday");
        addButton(wednesday);
        JButton friday = new JButton("friday");
        addButton(friday);
        JButton saturday = new JButton("saturday");
        addButton(saturday);
        JButton sunday = new JButton("sunday");
        addButton(sunday);
    }
    public static void createFile(String name) {
        File file = new File(name);
}
    public static void showFile(File file){
        try {
            for (int i = 0; i < 48; i++) {
                table[i].setText("");
            }
            int counter = 0;
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                table[counter].setText(line);
                counter++;

            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void createTextArea() {
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1); // Tworzymy ramkę
        for (int i = 0; i < 48; i++) {
            table[i] = new JTextArea();
            addTextArea(table[i]);
            table[i].setBorder(border); // Dodajemy ramkę do JTextArea
            panel2.add(table[i], gbc); // Dodajemy JTextArea do panelu z określonymi ograniczeniami
        }
        panel2.revalidate(); // Obliczamy na nowo rozmiary panelu
        panel2.repaint(); // Rysujemy na nowo panel
    }

}
