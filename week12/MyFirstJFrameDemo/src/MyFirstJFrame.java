import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 文件名：My.java
 * 功能描述：
 */
public class MyFirstJFrame {
    public static void main(String[] args) {
        JFrame jf = new JFrame("JFrame窗口");
        jf.setLocation(300,300);//指定窗口出现的位置
        jf.setSize(300,150);//设置窗口大小

        jf.setBounds(300,300,300,150);//相当于setLocation()+setSize()

        jf.setBackground(Color.black);//设置背景颜色


        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        jf.setVisible(true);//设置窗口可见

        /*
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
         */
    }
}
