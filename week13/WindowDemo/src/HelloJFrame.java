/**
 * 文件名：HelloJFrame.java
 * 功能描述：
 */
import javax.swing.*;
import java.awt.*;

public class HelloJFrame extends JFrame {

    public HelloJFrame() {
        setPreferredSize(new Dimension(600, 400));
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            String lookAndFeel =
                    UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception e) {}

        new HelloJFrame();
    }
}