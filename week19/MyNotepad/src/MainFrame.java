/**
 * 文件名：MainFrame.java
 * 功能描述：程序主窗口类
 */
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.lang.reflect.Modifier;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MainFrame extends JFrame {
    private JTextArea textArea = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    private MainMenu mainMenu;

    public MainFrame() {
        initFrame();
        initTextArea();
        initMenu();
    }

    private void initFrame() {
        setTitle("记事本");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置窗口关闭方式
        setSize(800,535);
        setLocationRelativeTo(null); //居中显示
    }

    private void initMenu() {
        mainMenu = new MainMenu(this,textArea);
    }

    private void initTextArea() {
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        //textArea = new TextArea();
        textArea.setFont(new Font("新宋体",Font.ROMAN_BASELINE,14));
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                mainMenu.setModified(true);
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                mainMenu.setModified(true);
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                mainMenu.setModified(true);
            }
        });

        //container.add(textArea);

        //VERTICAL垂直    HORIZONTAL水平
        //JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        container.add(scrollPane,BorderLayout.CENTER);

        validate();
    }


}
