import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashMap;


public class create extends JFrame {
    public static JFrame frame;
    public static JPanel choosemenu;
    private static JPanel panel2;

    private static JButton button1;

    private static JButton button2;
    static GridBagConstraints gbc = new GridBagConstraints();

    static GridBagLayout layout = new GridBagLayout();

    private static HashMap<String, JButton> buttons = new HashMap<>();


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
    frame.setSize(1000, 1000);
    frame.setLayout(new BorderLayout(1, 1));
    frame.setVisible(true);
}
 public static void setPanel2(int width, int height) {
        panel2 = new JPanel();
        panel2.setSize(width, height);
        panel2.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        frame.add(panel2, BorderLayout.CENTER);
        panel2.setBackground(Color.BLUE);
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