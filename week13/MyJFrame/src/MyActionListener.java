/**
 * 文件名：MyActionListener.java
 * 功能描述：外部监听器实现类文件
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyActionListener implements ActionListener {

    //在这个方法中要操作某个窗体中的组件，我们不能为actionPerformed方法传参来操作它
    //我们可以类定义一个窗体的引用，然后通过构造方法传入到监听器当中
    private MyJFrame frame;
    private JLabel label;
    private int count;


    public MyActionListener(MyJFrame frame, JLabel label) {
        super();
        this.frame = frame;
        this.label = label;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        //我们没有办法直接访问MyJFrame中的私有属性，只能通过MyJFrame提供get方法或提升button的访问权限来访问它
        if(e.getSource() instanceof AbstractButton) {
            AbstractButton btn = (AbstractButton) e.getSource();
            label.setText(btn.getText() + " 已经被点击了 " + count + " 次！");
        } else {
            label.setText(e.getSource().toString() + " 组件已经被点击了 " + count + " 次！");
        }

    }
}