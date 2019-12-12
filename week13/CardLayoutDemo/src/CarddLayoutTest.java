import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarddLayoutTest extends JFrame {
    private CardLayout c1 = new CardLayout();
    private Container c = getContentPane();

    public CarddLayoutTest() {
        JButton b1 = new JButton("第一页");
        JButton b2 = new JButton("第二页");
        JButton b3 = new JButton("第三页");

        setLayout(c1);
        add(b1,"第一页面");
        add(b2,"第二页面");
        add(b3,"第三页面");

        b1.addActionListener(new MyListener());
        b2.addActionListener(new MyListener());
        b3.addActionListener(new MyListener());
    }

    class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            c1.next(c);
        }
    }

    public static void main(String[] args) {
        CarddLayoutTest jf = new CarddLayoutTest();
        jf.setTitle("CardLayout测试");
        jf.setLocation(300,150);
        jf.setSize(450,300);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
