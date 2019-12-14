import javax.swing.*;
import java.awt.*;

/**
 * 文件名：MyJFrame.java
 * 功能描述：JFrame窗口类文件
 */
public class MyJFrame extends JFrame {
    private JLabel resultLabel;//用于显示执行结果的文本标签
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;

    public MyJFrame() throws HeadlessException {
        init();
    }

    private void init() {
        setSize(450,300);
        setLocationRelativeTo(null);
        setTitle("Java测试窗口");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        resultLabel = new JLabel("提示信息：");
        button1 = new JButton("按钮1");
        button2 = new JButton("按钮2");

        Container container = this.getContentPane();
        container.setLayout(null); //absolute layout:绝对布局管理器

        resultLabel.setBounds(50,20,200,35);
        button1.setBounds(20,100,100,35);
        button2.setBounds(200,100,100,35);

        container.add(resultLabel);
        container.add(button1);
        container.add(button2);

        button1.addActionListener(new MyActionListener(this,resultLabel));
        button2.addActionListener(new MyActionListener(this,resultLabel));
    }
}
