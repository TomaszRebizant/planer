import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.HashMap;


public class create extends JFrame {
    public static JPanel choosemenu;
    public static JPanel panel2;
    public static final JLabel label = new JLabel();

    static GridBagConstraints gbc = new GridBagConstraints();
    static GridBagLayout layout = new GridBagLayout();

    public static File currentFile = new File("src/files/monday.txt");

    public static int textAreasSize = 0;
    public static int isClicked = 0;

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
        JTextArea[] table = new JTextArea[48];
        JTextArea[] table2 = new JTextArea[48];
        HashMap<String, JTextArea> textAreas = new HashMap<String, JTextArea>();
        HashMap<String, JTextArea> textAreasPanel2 = new HashMap<String, JTextArea>();
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
        // createTextArea(1, 6, panel2, textAreasPanel2, table2, frame);
       // createTextArea(2, 6, panel2, textAreasPanel2, table2, frame);
       // Buttons.saveButton();
        //Buttons.showFrame2(frame2);
       // Buttons.hideFrame2(frame2);
        //JPanel panel = new JPanel();
       // setPanel(panel, frame2, textAreas, table);
        JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setText("Poniedziałek");
        panel2.add(textField);
        panel2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                isClicked = 1;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isClicked = 0;
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
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if(isClicked == 1)
                textField.setText("Bagno");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                textField.setText("Poniedziałek");
            }
        });
        frame.revalidate();
        frame.repaint();
       // resizeJTextAreas(textAreas, frame2);
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

    public static void addTextFields(JTextField textField) {

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

    public static void setPanel(JPanel panel, JFrame frame, HashMap<String, JTextArea> textAreas, JTextArea[] table) {
        GridBagConstraints gbcPanel = new GridBagConstraints();
        GridBagLayout layoutPanel = new GridBagLayout();
        layoutPanel.addLayoutComponent(panel, gbcPanel);
        panel.setSize(frame.getWidth(), frame.getHeight());
        panel.setLayout(layoutPanel);
        createTextArea(1, 6, panel, textAreas, table, frame);
        createTextArea(2, 6, panel, textAreas, table, frame);
        createTextArea(3, 6, panel, textAreas, table, frame);
        frame.add(panel);
    }

    public static void addTextArea(JTextArea jTextAreay, HashMap<String, JTextArea> textAreasy, JFrame frame) {
        jTextAreay.setPreferredSize(new Dimension(75 * frame.getWidth() / 1000, 88 * frame.getHeight() / 1000));
        jTextAreay.setRows(10);
        jTextAreay.setColumns(10);
        jTextAreay.setLineWrap(true);
        jTextAreay.setWrapStyleWord(true);
        jTextAreay.setMinimumSize(new Dimension(75 * frame.getWidth() / 1000, 44 * frame.getHeight() / 1000));
        jTextAreay.setBackground(new Color(205, 195, 110));
        panel2.add(jTextAreay);
        textAreasSize++;
        textAreasy.put(String.valueOf(textAreasSize), jTextAreay);
    }
    public static void addTextAreaChooser(JTextArea jTextAreay, HashMap<String, JTextArea> textAreasy, JFrame frame) {
        jTextAreay.setPreferredSize(new Dimension(75 * frame.getWidth() / 1000, 88 * frame.getHeight() / 1000));
        jTextAreay.setRows(10);
        jTextAreay.setColumns(10);
        jTextAreay.setLineWrap(true);
        jTextAreay.setWrapStyleWord(true);
        jTextAreay.setMinimumSize(new Dimension(75 * frame.getWidth() / 1000, 44 * frame.getHeight() / 1000));
        jTextAreay.setBackground(new Color(205, 195, 110));
        panel2.add(jTextAreay);
        textAreasSize++;
        textAreasy.put(String.valueOf(textAreasSize), jTextAreay);
        chooser(jTextAreay, frame);
    }

    public static void createTextArea(int kolumna, int wiersze, JPanel panel, HashMap<String, JTextArea> textAreasx, JTextArea[] tablex, JFrame frame) {
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        int g = kolumna;
        for (int i = 0; i < wiersze; i++) {
            tablex[i] = new JTextArea();
            addTextArea(tablex[i], textAreasx, frame);
            gbc.gridy = i;
            tablex[i].setBorder(border);
            panel.add(tablex[i], new GridBagConstraints() {{
                gridx = g;
                insets = new Insets(0, 0, 5, 10);
            }});
        }
        panel.revalidate();
        panel.repaint();
    }

    public static void createTextAreaChooser(int kolumna, int wiersze, JPanel panel, HashMap<String, JTextArea> textAreasx, JTextArea[] tablex, JFrame frame) {
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        int g = kolumna;
        for (int i = 0; i < wiersze; i++) {
            tablex[i] = new JTextArea();
            addTextAreaChooser(tablex[i], textAreasx, frame);
            gbc.gridy = i;
            tablex[i].setBorder(border);
            panel.add(tablex[i], new GridBagConstraints() {{
                gridx = g;
                insets = new Insets(0, 0, 5, 10);
            }});
        }
        panel.revalidate();
        panel.repaint();
    }


    public static void resizeJTextAreas(HashMap<String, JTextArea> textAreas, JFrame frame) {
        for (JTextArea textArea : textAreas.values()) {
            textArea.setSize(new Dimension(400, 100));
            textArea.setMinimumSize(new Dimension(120, 50));

        }
        frame.revalidate();
        frame.repaint();
    }

    public static void chooser(JTextArea textArea, JFrame frame2) {
        int[] x = {0};
            textArea.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {
                    x[0] =1;
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    x[0] =0;
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                        textArea.setBackground(Color.RED);
                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });

    }
}
