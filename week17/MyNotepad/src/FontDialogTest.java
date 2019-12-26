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

public class FontDialogTest extends JFrame {
    public JLabel testLabel = null;
    private JButton fontButton = null;

    public FontDialogTest() {
        super("字体设置测试");

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        testLabel = new JLabel("JFontDialog Test!", SwingConstants.CENTER);
        testLabel.setFont(new Font("", Font.BOLD, 26));
        container.add(testLabel, BorderLayout.CENTER);

        fontButton = new JButton("字体设置");
        fontButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Font myFont = FontDialog.showDialog(FontDialogTest.this);
                if (myFont != null)
                    testLabel.setFont(myFont);
            }

        });
        container.add(fontButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] lsg) {
        FontDialogTest dialog = new FontDialogTest();
        //dialog.setVisible(true);
    }

}
