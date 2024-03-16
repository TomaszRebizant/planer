import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashMap;

public class create extends JFrame {
    private static JFrame frame;
    private static JPanel chooseMenu;
    private static JPanel secondPanel;
    private static HashMap<String, JButton> buttons = new HashMap<>();

    public create() {
        setFrame();
        createAndShowGUI();
    }

    public static void createAndShowGUI() {

        setChooseMenu(frame.getWidth()/10, frame.getWidth()/10);
        setPanel2(frame.getWidth(), frame.getHeight());
        addWeekButtons();


        frame.add(chooseMenu, BorderLayout.WEST);
        frame.add(secondPanel);

        resize(chooseMenu, frame);
    }
    public static void resize( JPanel choosemenu, JFrame frame){
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                choosemenu.setPreferredSize(new Dimension(frame.getWidth()/10, frame.getHeight()));
                for (JButton button : buttons.values()) {
                    button.setPreferredSize(new Dimension(75*frame.getWidth()/1000, 50*frame.getHeight()/1000));
                }
                frame.revalidate();
                frame.repaint();
            }
        });
    }

    public static void setChooseMenu(int width, int height) {
        FlowLayout layout = new FlowLayout();
        chooseMenu = new JPanel();
        chooseMenu.setLayout(layout);
        chooseMenu.setPreferredSize(new Dimension(width, height));
        chooseMenu.setBackground(new Color(235, 230, 206));
    }
    public static void setFrame() {
        frame = new JFrame("Plan dnia");
        frame.setVisible(true);
        frame.setSize(1366, 768);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void setPanel2(int width, int height) {
        secondPanel = new JPanel();
        secondPanel.setSize(width, height);
        secondPanel.setBackground(Color.BLUE);
    }
    public static void addButton(JButton button) {
        button.setBackground(new Color(255, 208, 79));
        button.setPreferredSize(new Dimension(75*frame.getWidth()/1000, 50*frame.getHeight()/1000));
        button.setFocusPainted(false);
        button.setContentAreaFilled(true);
        button.setVisible(true);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        chooseMenu.add(button);
        buttons.put(button.getText(), button);
    }

    public static void addWeekButtons(){
        JButton monday = new JButton("Poniedziałek");
        addButton(monday);
        JButton tuesday = new JButton("Wtorek");
        addButton(tuesday);
        JButton thurdsay = new JButton("Środa");
        addButton(thurdsay);
        JButton wednesday = new JButton("Czwartek");
        addButton(wednesday);
        JButton friday = new JButton("Piątek");
        addButton(friday);
        JButton saturday = new JButton("Sobota");
        addButton(saturday);
        JButton sunday = new JButton("Niedziela");
        addButton(sunday);
    }
}