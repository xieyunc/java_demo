import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutJFrame extends JFrame {
    private Container container;
    private CardLayout cardLayout;

    private void init() {
        setTitle("CardLayout测试");
        setSize(450,300);
        setLocationRelativeTo(null); //设置绝对布局管理
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        container = getContentPane();
        container.setLayout(cardLayout);

        JButton b1 = new JButton("第一页");
        JButton b2 = new JButton("第二页");
        JButton b3 = new JButton("第三页");

        container.add(b1,"第一页面");
        container.add(b2,"第二页面");
        container.add(b3,"第三页面");

        b1.addActionListener(new MyListener());
        b2.addActionListener(new MyListener());
        b3.addActionListener(new MyListener());
    }

    public CardLayoutJFrame() {
        init();
    }

    //定义一个内部监听器类
    class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.next(container);
        }
    }
}
