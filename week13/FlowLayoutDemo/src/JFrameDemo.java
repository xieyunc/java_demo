import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameDemo {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Swing窗口测试");
        jf.setLayout(new FlowLayout());
        jf.setBounds(500,300,450,300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton jb = new JButton("确定");
        jb.setPreferredSize(new Dimension(75,25));
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(((JButton)actionEvent.getSource()).getText());
            }
        });
        jf.add(jb);

        jf.setVisible(true);
    }
}
