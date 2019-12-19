import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcDemo extends JFrame implements ActionListener {
    // 属性
    JTextField txtResult;
    boolean firstDigit = true;//用于判断是否是数字
    String operator = "=";//先初始化为等号，等到执行相应运算时再更改
    boolean operateValidFlag = true;//判断除数是否为0
    double resultNum = 0.0;//可以暂存目前的最终结果

    // 方法
    public CalcDemo() {
        setTitle("计算器");
        setSize(240, 270);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout(5, 5));
        JPanel pnlNorth = new JPanel();
        JPanel pnlCenter = new JPanel();

        pnlNorth.setLayout(new BorderLayout());
        pnlCenter.setLayout(new GridLayout(4, 4, 3, 3));

        Font font = new Font("Consolas", Font.BOLD, 20);

        contentPane.add(BorderLayout.NORTH, pnlNorth);
        contentPane.add(BorderLayout.CENTER, pnlCenter);

        txtResult = new JTextField();
        txtResult.setFont(font);
        txtResult.setEnabled(false);
        JButton btnClear = new JButton("C");
        btnClear.setFont(font);
        btnClear.addActionListener(this);

        pnlNorth.add(BorderLayout.CENTER, txtResult);
        pnlNorth.add(BorderLayout.EAST, btnClear);

        String[] captions = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", ".", "/", "=",};
        for (int i = 0; i < captions.length; i++) {
            JButton btn = new JButton(captions[i]);
            btn.setFont(font);
            pnlCenter.add(btn);
            btn.addActionListener(this);

        }

    }

    public static void main(String[] args) {
        JFrame frame = new CalcDemo();
        frame.setVisible(true);
    }

    //对按钮进行的反应
    @Override
    public void actionPerformed(ActionEvent event) {
        String label = event.getActionCommand();
        if (label.equals("C")) {
            handleC();
        } else if ("0123456789.".indexOf(label) >= 0) {
//无论整数还是小数都一起提取出来
            handleNumber(label);
        } else {
//将当前要执行的运算的运算符赋给operator
            handleOperator(label);
        }
    }

    //提取数字
    void handleNumber(String key) {
        if (firstDigit) {
            txtResult.setText(key);//在文本框中显示数字的字符串
        } else if ((key.equals(".")) && (txtResult.getText().indexOf(".") < 0)) {

            txtResult.setText(txtResult.getText() + ".");//在文本框中显示整数数字的字符串
        } else if (!key.equals(".")) {

            txtResult.setText(txtResult.getText() + key);//在文本框中显示整数数字的字符串
        }
        firstDigit = false;//当数字显示完之后，即可重置为false
    }

    //实现清零
    void handleC() {

        txtResult.setText("0");
        firstDigit = true;
        operator = "=";
    }

    //进行运算
    void handleOperator(String key) {
        if (operator.equals("/")) {
//判断除数是否为0
            if (getNumberFromText() == 0.0) {
//以下代码很关键，不做多余说明，每次看都有不同的理解
                operateValidFlag = false;
                txtResult.setText("除数不能为零");
            } else {
                resultNum /= getNumberFromText();
            }
        } else if (operator.equals("+")) {

            resultNum += getNumberFromText();
        } else if (operator.equals("-")) {

            resultNum -= getNumberFromText();
        } else if (operator.equals("*")) {

            resultNum *= getNumberFromText();
        } else if (operator.equals("=")) {

            resultNum = getNumberFromText();
        }

        if (operateValidFlag) {
            long t1;
            double t2;
            t1 = (long) resultNum;
            t2 = resultNum - t1;
            if (t2 == 0) {
                txtResult.setText(String.valueOf(t1));
            } else {
                txtResult.setText(String.valueOf(resultNum));
            }
        }
        operator = key;
        firstDigit = true;
        operateValidFlag = true;
    }

    double getNumberFromText() {
        double result = 0;
        try {
            result = Double.valueOf(txtResult.getText()).doubleValue();//把String转化成Double类型的对象,并求double的原始值
        } catch (NumberFormatException e) {
        }
        return result;
    }
}
