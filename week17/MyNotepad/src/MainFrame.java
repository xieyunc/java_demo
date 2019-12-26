/**
 * 文件名：MenuFrame.java
 * 功能描述：菜单窗口类
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
    private MainMenu mainMenu;
    //private String currentFileName = ""; //当前文件名
    //private String currentFileCharset = "UTF-8";//当前文件字符编码
    //private boolean isModified = false;//文件是否已修改

    public MainFrame() {
        initFrame();
        initTextArea();
        initMenu();
    }

    private void initFrame() {
        setTitle("记事本");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置窗口关闭方式
        setSize(700,450);
        setLocationRelativeTo(null); //居中显示
    }

    private void initMenu() {
        mainMenu = new MainMenu(this,textArea);
    }

    private void initTextArea() {
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        //textArea = new TextArea();
        textArea.setFont(new Font(Font.MONOSPACED,Font.ROMAN_BASELINE,14));
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

        container.add(textArea);
        validate();
    }


}
