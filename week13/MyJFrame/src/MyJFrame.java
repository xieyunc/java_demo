import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonActionListener implements ActionListener {

    //在这个方法中要操作某个窗体中的组件，我们不能为actionPerformed方法传参来操作它
    //我们可以类定义一个窗体的引用，然后通过构造方法传入到监听器当中
    private MyJFrame frame;
    private String button_Name;
    private int count;


    public ButtonActionListener(MyJFrame frame, String button_Name) {
        super();
        this.frame = frame;
        this.button_Name = button_Name;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        //我们没有办法直接访问MyJFrame中的私有属性，只能通过MyJFrame提供get方法或提升button的访问权限来访问它
        frame.button2.setText(button_Name + "被点击了" + count + "次");
    }
}