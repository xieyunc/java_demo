/**
 * 文件名：MenuFrame.java
 * 功能描述：菜单窗口类
 */
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Modifier;
import javax.swing.*;
public class MenuFrame extends JFrame {
    private TextArea textArea;
    private String curentFileName = "";
    private String curentFileCharset = "UTF-8";

    public MenuFrame() {
        initFrame();
        initMenu();
        initTextArea();
    }

    private void initFrame() {
        setTitle("窗口及菜单Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置窗口关闭方式
        setSize(700,450);
        setLocationRelativeTo(null); //居中显示
    }

    private void initMenu() {
        JMenuBar menubar = new JMenuBar();//菜单条栏、菜单条：它是菜单的容器
        JMenu menuFile = new JMenu("文件(F)");
        JMenu menuEdit = new JMenu("编辑(E)");
        JMenu menuView = new JMenu("查看(L)");

        menuFile.setMnemonic('F'); //设置菜单的热键为字母键F，需按下Alt键和字母键F
        menuEdit.setMnemonic('E');
        menuView.setMnemonic('L');

        menubar.add(menuFile); //把主菜单条加入菜单栏容器中
        menubar.add(menuEdit);
        menubar.add(menuView);

        JMenuItem miOpen = new JMenuItem("打开(O)"); //文件菜单下的一个二级主菜单条
        miOpen.setMnemonic('O');
        miOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK)); //设置快捷键Ctrl_O
        miOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fn = FileOperator.selectFile(curentFileName,JFileChooser.OPEN_DIALOG);
                if (fn.equals("")) {
                    return;
                }
                try {
                    String content = FileOperator.readTxt(fn);
                    textArea.setText(content);
                    curentFileName = fn;
                    curentFileCharset = FileOperator.getFileCharsetName(fn);
                    setTitle(curentFileName);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JMenuItem miSave=new JMenuItem("保存(S)");
        miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK)); //设置快捷键Ctrl_S
        miSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JMenuItem miSaveAs = new JMenuItem("另存为(A)");

        miSaveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fn = FileOperator.selectFile(curentFileName,JFileChooser.SAVE_DIALOG);
                if (fn.equals("")) {
                    return;
                }

                try {
                    String content = textArea.getText();
                    FileOperator.writeTxt(fn,textArea.getText(),curentFileCharset);
                    if (curentFileName.equals(fn)) {
                        curentFileName = fn;
                        curentFileCharset = FileOperator.getFileCharsetName(fn);
                        setTitle(curentFileName);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        miSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileContent = "xieyunc";
                textArea.setText(fileContent);

                //String ss = textArea.getText();
                System.out.println(fileContent);
            }
        });

        JMenuItem miExit=new JMenuItem("退出(X)");
        miExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuFile.add(miOpen);
        menuFile.add(miSave);
        menuFile.add(miSaveAs);
        menuFile.addSeparator(); //分隔线
        menuFile.add(miExit);

        JMenuItem miCopy = new JMenuItem("复制(C)");
        miCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
        JMenuItem miCut=new JMenuItem("剪切(X)");
        miCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
        JMenuItem miPaste=new JMenuItem("粘贴(V)");
        miPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));

        menuEdit.add(miCopy);
        menuEdit.add(miCut);
        menuEdit.addSeparator();
        menuEdit.add(miPaste);

        JMenuItem miRefresh=new JMenuItem("刷新(R)");
        miRefresh.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5,Modifier.FINAL));
        JMenuItem miStop=new JMenuItem("停止(T)");
        miStop.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6,Modifier.FINAL));

        menuView.add(miRefresh);
        menuView.addSeparator();
        menuView.add(miStop);

        setJMenuBar(menubar);
        validate();
    }

    private void initTextArea() {
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        textArea = new TextArea();
        textArea.setFont(new Font(Font.MONOSPACED,Font.ROMAN_BASELINE,14));

        container.add(textArea);
        validate();
    }

}
