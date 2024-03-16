import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class create {
    private static JFrame frame;
    private static JPanel choosemenu;
    private static JPanel panel2;

    private static JButton button1;

    public static void createAndShowGUI() {
        setFrame();
        setChoosemenu(frame.getWidth()/10, 50);
        setPanel2(frame.getWidth(), frame.getHeight());

        button1 = new JButton("Poniedziałek");
        choosemenu.add(button1);
        buttonstyle(button1);
        frame.setSize(700, 700);
        frame.setVisible(true);
        resize(button1, choosemenu, frame);
    }
        public static void resize(JButton button1, JPanel choosemenu, JFrame frame){
            button1.setPreferredSize(new Dimension(choosemenu.getWidth(), 100));
            frame.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    choosemenu.setPreferredSize(new Dimension(frame.getWidth() /10, frame.getHeight()));
                    button1.setPreferredSize(new Dimension(choosemenu.getWidth(), 50));
                    frame.revalidate();
                    frame.repaint();
                }
            });
        }

    public static void setChoosemenu(int width, int height) {
        choosemenu = new JPanel();
        choosemenu.setSize(width, height);
        choosemenu.setLayout(new BorderLayout(0, 0));
        frame.add(choosemenu, BorderLayout.WEST);
        choosemenu.setBackground(new Color(235, 230, 206));

    }
public static void setFrame() {
    frame = new JFrame();
    frame.setTitle("Plan dnia");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 600);
    frame.setLayout(new BorderLayout(0, 0));
}
 public static void setPanel2(int width, int height) {
        panel2 = new JPanel();
        panel2.setSize(width, height);
        panel2.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        frame.add(panel2, BorderLayout.CENTER);
        panel2.setBackground(Color.BLUE);
    }
    public static void buttonstyle(JButton button) {
        button.setMinimumSize(new Dimension(50, 50));
        button.setBackground(new Color(255, 208, 79));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setVisible(true);
    }
}