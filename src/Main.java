import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.CENTER;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                create.createAndShowGUI();
            }
        });
    }


}