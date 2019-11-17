import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 文件名：MyFirstFrame.java
 * 功能描述：
 */
public class MyFirstFrame {
    public static void main(String[] args) {

        Frame f = new Frame("Frame窗口");
        f.setLocation(300, 100);//指定窗口出现的位置
        f.setSize(300, 150);//设置窗口大小
        f.setBackground(Color.black);//设置背景颜色
        f.setVisible(true);//设置窗口可见

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }
}
