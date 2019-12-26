/**
 * 文件名：JFontDialogTest.java
 * 功能描述：
 */
//下面是测试程序代码

//JFontDialogTest.java

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * 作者：李　世贵
 * JDK: 1.6
 * 来源: http://blog.csdn.net/lishigui
 * 欢迎转接,请保留作者和来源,谢谢!
 * 2009-4-23 上午10:55:30
 */

public class JFontDialogTest extends JFrame {
    public JLabel testLabel = null;
    private JButton fontButton = null;

    public JFontDialogTest() {
        super("test");

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        testLabel = new JLabel("JFontDialog Test!", SwingConstants.CENTER);
        testLabel.setFont(new Font("", Font.BOLD, 26));
        container.add(testLabel, BorderLayout.CENTER);

        fontButton = new JButton("字体设置");
        fontButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              JFontDialog fontDialog = new JFontDialog(JFontDialogTest.this, "字体设置", true);
              fontDialog.setVisible(true);
            }

        });
        container.add(fontButton, BorderLayout.SOUTH);

        setSize(300, 200);
        setVisible(true);

    }

    public static void main(String[] lsg) {
        JFontDialogTest dialog = new JFontDialogTest();
        //dialog.setVisible(true);
        dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
