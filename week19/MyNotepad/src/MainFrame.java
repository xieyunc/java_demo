/**
 * 文件名：MainFrame.java
 * 功能描述：程序主窗口类
 */
import javafx.geometry.HorizontalDirection;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.lang.reflect.Modifier;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MainFrame extends JFrame {

    private Container container = this.getContentPane();
    private JTextArea textArea = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    private JPanel panelStatusBar = new JPanel(new BorderLayout(10,5));
    private JLabel labelContent = new JLabel("1行, 1列");
    private JLabel labelEncoding = new JLabel("字符编码：UTF-8  ");

    private MainMenu mainMenu;

    public void setCurrentFileCharset(String currentFileCharset) {
        labelEncoding.setText("字符编码："+mainMenu.getCurrentFileCharset()+"  ");
    }

    private void updateStatusBar(CaretEvent e) {
        try {
            int caretPos = textArea.getCaretPosition(); //获取当前光标处出字符在textArea中的索引值
            int row = textArea.getLineOfOffset(caretPos); //算出行号
            int col = caretPos - textArea.getLineStartOffset(row); //算出列号

            labelContent.setText(String.format("%d行, %d列", row + 1, col + 1));
            //labelEncoding.setText("字符编码："+currentFileCharset+"  ");
            //System.out.println(labelContent.getText()+"|"+caretPos);
            labelContent.validate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public MainFrame() {
        container.setLayout(new BorderLayout());
        initFrame();
        initTextArea();
        initStatusBar();
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

        textArea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                updateStatusBar(e);
            }
        });

        /*
        container.add(textArea);
        VERTICAL垂直    HORIZONTAL水平
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        */

        container.add(scrollPane,BorderLayout.CENTER);

        validate();
    }

    private void initStatusBar() {
        JLabel labelLeft = new JLabel("提示信息：");
        labelLeft.setHorizontalAlignment(SwingConstants.LEFT);

        labelContent.setHorizontalAlignment(SwingConstants.RIGHT);

        labelContent.setHorizontalAlignment(SwingConstants.LEFT);

        panelStatusBar.add(labelLeft,BorderLayout.WEST);
        panelStatusBar.add(labelContent,BorderLayout.CENTER);
        panelStatusBar.add(labelEncoding,BorderLayout.EAST);

        container.add(panelStatusBar,BorderLayout.SOUTH);

        validate();
    }

    public void setPanelStatusBarVisible(boolean visible) {
        this.panelStatusBar.setVisible(visible);
    }
}
