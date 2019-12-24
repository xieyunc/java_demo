import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private void init() { //初始化窗口和控件
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "窗口风格设置失败！\r\n", "系统提示",JOptionPane.WARNING_MESSAGE);
        }

        setTitle("系统登录");
        setSize(450,300);
        setResizable(false);
        //this.setUndecorated(true); // 去掉窗口的装饰
        //this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);//采用指定的窗口装饰风格

        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelUser = new JLabel("用户名：");
        labelUser.setBounds(50,50,100,25);

        JLabel labelPwd = new JLabel("用户密码：");
        labelPwd.setBounds(50,90,100,25);

        JTextField textUser = new JTextField("",20);
        textUser.setBounds(160,50,180,25);

        JPasswordField textPwd = new JPasswordField("",20);
        textPwd.setBounds(160,90,180,25);

        JButton buttonCancel = new JButton("退出");
        buttonCancel.setBounds(160,150,75,25);

        JButton buttonLogin = new JButton("登录");
        buttonLogin.setBounds(260,150,75,25);

        buttonLogin.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = textUser.getText();
                String userPwd = textPwd.getText();

                if (userId.equals("") || userPwd.equals("")) {
                    JOptionPane.showMessageDialog(null, "信息输入不全！用户名和密码不能为空！\r\n请检查后重新登录！\r\n", "系统提示",JOptionPane.WARNING_MESSAGE);
                    textUser.grabFocus();
                    return;
                } else {
                    if (!DbOperator.connDB()) {
                        JOptionPane.showMessageDialog(null, "数据库连接失败，请稍候重试！", "系统提示",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (DbOperator.checkUser(userId,userPwd)) {
                        JOptionPane.showMessageDialog(null, "用户身份验证通过，登录成功！\r\n", "系统提示",JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "用户名和密码验证失败，登录被拒绝！\r\n", "系统提示",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.add(labelUser);
        this.add(textUser);
        this.add(labelPwd);
        this.add(textPwd);

        this.add(buttonCancel);
        this.add(buttonLogin);

        this.validate();
    }

    public LoginFrame() throws HeadlessException {
        init();
    }

    public static void main(String[] args) {
        LoginFrame login = new LoginFrame();
        login.setVisible(true);
    }
}
