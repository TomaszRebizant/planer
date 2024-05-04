import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class create extends JFrame {
    public static final JLabel label = new JLabel();
    public static JPanel choosemenu;
    public static JPanel panel2;
    public static File currentFile = new File("src/files/monday.txt");
    public static int textAreasSize = 0;
    public static int textFieldsSize = 0;
    public static int isClicked = 0;
    static GridBagConstraints gbc = new GridBagConstraints();
    static GridBagLayout layout = new GridBagLayout();

    public create() {
        JFrame frame = new JFrame();
        JFrame frame2 = new JFrame();
        setFrame(frame, "Planer", new Dimension(1000, 800));
        setFrame(frame2, "Wybierz", new Dimension(500, 500));
        createAndShowGUI(frame, frame2);
    }

    public static void createAndShowGUI(JFrame frame, JFrame frame2) {
        frame2.setVisible(false);
        HashMap<String, JButton> buttons = new HashMap<>();
        HashMap<Integer, JTextArea> textAreas = new HashMap<>();
        HashMap<Integer, JTextArea> textAreasPanel2 = new HashMap<>();
        HashMap<Integer, JTextField> textFields = new HashMap<>();
        setChooseMenu(frame.getWidth() / 7, frame.getWidth() / 7, frame);
        setPanel2(frame.getWidth(), frame.getHeight(), frame);
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Buttons.addWeekButtons(buttons, textAreasPanel2, frame);
        choosemenu.setLayout(layout);
        resize(choosemenu, frame, buttons);
        panel2.add(label);
        panel2.setLayout(layout);
        layout.setConstraints(label, gbc);
        createTextArea(1, 6, panel2, textAreasPanel2, frame);
        createTextArea(2, 6, panel2, textAreasPanel2, frame);
        Buttons.saveButton(textAreasPanel2);
        Buttons.showFrame2(frame2);
        Buttons.hideFrame2(frame2);
        JPanel panel = new JPanel();
        setPanel(panel, frame2);
        JButton button = new JButton("Reset");
        JButton visibility = new JButton("Set visibility");
        panel.add(button, new GridBagConstraints(
                0, 12, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0
        ));
        panel.add(visibility, new GridBagConstraints(
                1, 12, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0
        ));
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (HashMap.Entry<Integer, JTextField> entry : textFields.entrySet()) {
                    JTextField textField = entry.getValue();
                    textField.setBackground(Color.WHITE);

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        visibility.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (HashMap.Entry<Integer, JTextArea> entry : textAreasPanel2.entrySet()) {
                    JTextArea textArea = entry.getValue();
                    textArea.setVisible(true);
                    for (HashMap.Entry<Integer, JTextField> entry2 : textFields.entrySet()) {
                        JTextField textField = entry2.getValue();
                        if (entry2.getKey().equals(entry.getKey()) && textField.getBackground() == Color.RED){
                            textArea.setVisible(false);
                        }
                    }

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        frame.revalidate();
        frame.repaint();
        createTextField(8, 2, textFields, panel);
        resizeJTextAreas(textAreas, frame2);
    }

    public static void resize(JPanel choosemenu, JFrame frame, HashMap<String, JButton> buttons) {

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                choosemenu.setPreferredSize(new Dimension(frame.getWidth() / 7, frame.getHeight()));
                for (JButton button : buttons.values()) {
                    button.setPreferredSize(new Dimension(90 * frame.getWidth() / 1000, 75 * frame.getHeight() / 1000));
                }
                frame.revalidate();
                frame.repaint();
            }
        });
    }

    public static void setChooseMenu(int width, int height, JFrame frame) {
        choosemenu = new JPanel();
        choosemenu.setPreferredSize(new Dimension(width, height));
        frame.add(choosemenu, BorderLayout.WEST);
        choosemenu.setBackground(new Color(235, 230, 206));

    }

    public static void setFrame(JFrame frame, String title, Dimension size) {
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(size);
        frame.setLayout(new BorderLayout(1, 1));
        frame.setVisible(true);
    }

    public static void addTextFields(JTextField textField, JPanel panel, HashMap<Integer, JTextField> textFields) {
        textField.setPreferredSize(new Dimension(100, 100));
        textField.setMinimumSize(new Dimension(100, 40));
        textField.setEditable(false);
        textField.setVisible(true);
        chooser(textField, panel);
    }

    public static void createTextField(int wiersze, int kolumny, HashMap<Integer, JTextField> HashMap, JPanel panel) {

        for (int i = 1; i <= kolumny; i++) {
            for (int j = 1; j <= wiersze; j++) {
                JTextField textField = new JTextField();
                addTextFields(textField, panel, HashMap);
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridy = j;
                gbc.gridx = i;
                panel.add(textField, gbc);
                textFieldsSize++;
                HashMap.put(textFieldsSize, textField);
            }
        }
    }

    public static void setPanel2(int width, int height, JFrame frame) {
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

    public static void setPanel(JPanel panel, JFrame frame) {
        GridBagConstraints gbcPanel = new GridBagConstraints();
        GridBagLayout layoutPanel = new GridBagLayout();
        layoutPanel.addLayoutComponent(panel, gbcPanel);
        panel.setSize(frame.getWidth(), frame.getHeight());
        panel.setLayout(layoutPanel);
        frame.add(panel);
    }

    public static void addTextArea(JTextArea jTextAreay, HashMap<Integer, JTextArea> textAreasy, JFrame frame) {
        jTextAreay.setPreferredSize(new Dimension(75 * frame.getWidth() / 1000, 88 * frame.getHeight() / 1000));
        jTextAreay.setRows(10);
        jTextAreay.setColumns(10);
        jTextAreay.setLineWrap(true);
        jTextAreay.setWrapStyleWord(true);
        jTextAreay.setMinimumSize(new Dimension(75 * frame.getWidth() / 1000, 44 * frame.getHeight() / 1000));
        jTextAreay.setPreferredSize(new Dimension(75 * frame.getWidth() / 1000, 44 * frame.getHeight() / 1000));
        jTextAreay.setBackground(new Color(180, 134, 228));
        panel2.add(jTextAreay);
        textAreasSize++;
        textAreasy.put(textAreasSize, jTextAreay);
    }

    public static void createTextArea(int kolumna, int wiersze, JPanel panel, HashMap<Integer, JTextArea> textAreasx,  JFrame frame) {
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        for (int i = 1; i <= wiersze; i++) {
            JTextArea textArea = new JTextArea();
            addTextArea(textArea, textAreasx, frame);
            gbc.gridy = i;
            textArea.setBorder(border);
            panel.add(textArea, new GridBagConstraints() {{
                gridx = kolumna;
                insets = new Insets(0, 0, 5, 10);
            }});
        }
       textAreasx.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));
        panel.revalidate();
        panel.repaint();
    }

    public static void resizeJTextAreas(HashMap<Integer, JTextArea> textAreas, JFrame frame) {
        for (JTextArea textArea : textAreas.values()) {
            textArea.setSize(new Dimension(400, 100));
            textArea.setMinimumSize(new Dimension(120, 50));

        }
        frame.revalidate();
        frame.repaint();
    }

    public static void chooser(JTextField textField, JPanel panel) {
        int[] x = {0};
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                x[0] = 1;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x[0] = 0;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        textField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                x[0] = 1;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x[0] = 0;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (x[0] == 1) {
                    textField.setBackground(Color.RED);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }
}
