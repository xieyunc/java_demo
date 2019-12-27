/**
 * 文件名：Calculator.java
 * 功能描述：
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

@SuppressWarnings("serial")
class CalculatorPanel extends JPanel {
    private Font font = new Font(Font.MONOSPACED,Font.BOLD,14);
    private JPanel jp; // 中间的面板
    private double result; // 计算结果
    private boolean start; // 用于判断是否是首次输入,true首次,false不是首次
    private boolean flag; // 用于判断是否清空显示区域的值,true需要,false不需要
    private String lastCommand; // 用于保存运算符
    JTextField display; // 显示区域

    public CalculatorPanel() {
        // 初始化各项值
        result = 0;
        start = true;
        flag = false;
        lastCommand = "=";

        // 设置CalculatorPanel这个面板的布局为框架布局
        setLayout(new BorderLayout());
        // 这个按钮用来显示值的区域
        display = new JTextField("0.0",30);
        display.setFont(font);
        //将文本内容设置在文本框的左边
        display.setHorizontalAlignment(display.RIGHT);
        display.setEnabled(false);// 按钮样式设置为禁用样式

        // 用来初始化,清除用的
        JButton clear = new JButton("清除");
        clear.setFont(font);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 作初始化的操作
                result = 0;
                start = true;
                flag = false;
                lastCommand = "=";
                display.setText("0.0");
            }
        });

        jp = new JPanel();
        // 将此面板布局设置为网格布局,4行4列
        jp.setLayout(new GridLayout(4, 4));

        // 实例化监听器对象
        NumberAction na = new NumberAction();
        CommandAction ca = new CommandAction();

        makeButton("7", na);
        makeButton("8", na);
        makeButton("9", na);
        makeButton("/", ca);

        makeButton("4", na);
        makeButton("5", na);
        makeButton("6", na);
        makeButton("*", ca);

        makeButton("1", na);
        makeButton("2", na);
        makeButton("3", na);
        makeButton("-", ca);

        makeButton("0", na);
        makeButton(".", na);
        makeButton("+", ca);
        makeButton("=", ca);

        // 将面板,两个按键加入到我的面板,实现计算器的界面
        add(display, BorderLayout.NORTH);
        add(jp, BorderLayout.CENTER);
        add(clear, BorderLayout.SOUTH);

    }

    private void makeButton(String buttonName, ActionListener al) {
        JButton jb = new JButton(buttonName);
        jb.setFont(font);
        jp.add(jb);
        jb.addActionListener(al);
    }

    // 数字监听器
    private class NumberAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton jb = (JButton) e.getSource(); // 获取事件源对象
            String input = jb.getText(); // 获取事件源对象上的标签
            if (start) { // 首次输入
                // 一上就".",就什么也不做
                if (input.equals(".")) {
                    return;
                }
                // 如果是"0.0"的话,就清空
                if (display.getText().equals("0.0")) {
                    display.setText("");
                }
                start = false;// 改变是否首次输入的标记值
            } else {
                // 判断显示区域的值里面是否已经有".",如果有,输入的又是".",就什么都不做
                if (display.getText().indexOf(".") != -1) {
                    if (input.equals(".")) {
                        return;
                    }
                }

                // 判断显示区域的值里面只有"-",输入的又是".",就什么都不做
                if (display.getText().equals("-")) {
                    if (input.equals(".")) {
                        return;
                    }
                }

                // 判断显示区域的值如果是"0",输入的不是".",就什么也不做
                if (display.getText().equals("0")) {
                    if (!input.equals(".")) {
                        return;
                    }
                }
            }
            // 如果我点击了运算符以后,再输入数字的话,就要清空显示区域的值
            if (flag) {
                display.setText("");
                flag = false;// 还原初始值,不需要清空
            }
            display.setText(display.getText() + input);// 设置显示区域的值
        }
    }

    // 运算符监听器
    private class CommandAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton jb = (JButton) e.getSource(); // 获取事件源对象
            String inputCommand = jb.getText(); // 获取事件源对象上的标签

            if (start) {// 首次输入
                // 一上就是"-"
                if (inputCommand.equals("-")) {
                    display.setText("-");// 显示区域的内容设置为"-"
                    start = false;// 改变首次输入的标记
                }
            } else {

                if (!flag) {// 如果flag=false不需要清空显示区的值,就调用方法计算
                    calculate(Double.parseDouble(display.getText()));// 保存显示区域的值,并计算
                }
                // 保存你点击的运算符
                lastCommand = inputCommand;
                flag = true;// 因为我这里已经输入过运算符,
            }
        }
    }

    // 计算用的方法
    private void calculate(double x) {
        if (lastCommand.equals("+")) {
            result += x;
        } else if (lastCommand.equals("-")) {
            result -= x;
        } else if (lastCommand.equals("*")) {
            result *= x;
        } else if (lastCommand.equals("/")) {
            result /= x;
        } else if (lastCommand.equals("=")) {
            result = x;
        }
        display.setText("" + result);
    }
}

class MyFrameUitl {
    public static void init(JFrame jFrame, Dimension frameSize, String title,
                            String iconFileName, boolean resizable) {
        // 系统工具包,可以读取系统信息
        Toolkit tk = Toolkit.getDefaultToolkit();
        // 获取屏幕大小
        Dimension screenSize = tk.getScreenSize();
        // 获取宽高
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // 找中心点
        int centerX = screenWidth / 2;
        int centerY = screenHeight / 2;

        // 解析窗体大小
        int frameWidth = frameSize.width;
        int frameHeight = frameSize.height;

        // 设置窗体位置
        jFrame.setBounds(centerX - frameWidth / 2, centerY - frameHeight / 2,
                frameWidth, frameHeight);
        jFrame.setTitle(title);// 设置标题
        if (iconFileName != null) {
            jFrame.setIconImage(tk.getImage(iconFileName));// 设置图标
        }

        // 设置皮肤com.sun.java.swing.plaf.windows.WindowsLookAndFeel
        /**/
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(jFrame);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(resizable);// 设置窗体是否可以改变大小
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置程序关闭动作
        jFrame.setVisible(true);// 显示窗体

    }
}

class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        add(new CalculatorPanel());
        MyFrameUitl.init(this, new Dimension(800, 600), "简易计算器", null,
                false);
        // 让组件按原始大小显示,并且窗体的大小刚好能够容纳所有的组件
        this.pack();
    }
}

public class Calculator {
    public static void main(String[] args) {
        new CalculatorFrame();
    }
}