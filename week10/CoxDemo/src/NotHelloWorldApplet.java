import javax.swing.*;

/**
 * 文件名：NotHelloWorldApplet.java
 * 功能描述：
 */
public class NotHelloWorldApplet extends JApplet {
    public void init() {
        JLabel label = new JLabel("好的，Not a Hello, World applet",SwingConstants.CENTER);
        add(label);
    }
}
