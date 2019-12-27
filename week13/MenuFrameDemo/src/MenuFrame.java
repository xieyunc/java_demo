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

public class MenuFrame extends JFrame {
    private JTextArea textArea;
    private String currentFileName = ""; //当前文件名
    private String currentFileCharset = "UTF-8";//当前文件字符编码
    private boolean isModified = false;//文件是否已修改

    public MenuFrame() {
        initFrame();
        initMenu();
        initTextArea();
    }

    private void initFrame() {
        setTitle("记事本程序 Step by Step ……");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置窗口关闭方式
        setSize(700,450);
        setLocationRelativeTo(null); //居中显示
    }

    private void initMenu() {
        JMenuBar menubar = new JMenuBar();//菜单条栏、菜单条：它是菜单的容器
        JMenu menuFile = new JMenu("文件(F)");
        JMenu menuEdit = new JMenu("编辑(E)");
        JMenu menuOpti = new JMenu("格式(O)");
        JMenu menuView = new JMenu("查看(V)");
        JMenu menuHelp = new JMenu("帮助(H)");

        menuFile.setMnemonic('F'); //设置菜单的热键为字母键F，需按下Alt键和字母键F
        menuEdit.setMnemonic('E');
        menuOpti.setMnemonic('O');
        menuView.setMnemonic('V');
        menuView.setMnemonic('H');

        menubar.add(menuFile); //把主菜单条加入菜单栏容器中
        menubar.add(menuEdit);
        menubar.add(menuOpti);
        menubar.add(menuView);
        menubar.add(menuHelp);

        JMenuItem miNew = new JMenuItem("新建(N)");
        miNew.setMnemonic('N');
        miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK)); //设置快捷键Ctrl_O
        miNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (canCloseFile()) {
                    textArea.setText("");
                    isModified = false;
                    currentFileCharset = "UTF-8";
                    currentFileName = "";
                    MenuFrame.this.setTitle("记事本程序 Step by Step ……");//请注意内部匿名类对外部对象变量的访问方法
                }

                //newFile();
            }
        });
        JMenuItem miOpen = new JMenuItem("打开(O)"); //文件菜单下的一个二级主菜单条
        miOpen.setMnemonic('O');
        miOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK)); //设置快捷键Ctrl_O
        miOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (canCloseFile()) {
                    openFile();
                }
            }
        });

        JMenuItem miSave=new JMenuItem("保存(S)");
        miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK)); //设置快捷键Ctrl_S
        miSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile(currentFileName);
            }
        });

        JMenuItem miSaveAs = new JMenuItem("另存为(A)");
        miSaveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile("");
            }
        });

        JMenuItem miExit=new JMenuItem("退出(X)");
        miExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (canCloseFile()) {
                    System.exit(0);
                }
            }
        });

        menuFile.add(miNew);
        menuFile.addSeparator();
        menuFile.add(miOpen);
        menuFile.add(miSave);
        menuFile.add(miSaveAs);
        menuFile.addSeparator(); //分隔线
        menuFile.add(miExit);

        JMenuItem miSelectAll = new JMenuItem("全选(A)");
        miSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
        miSelectAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.selectAll();
            }
        });
        JMenuItem miCopy = new JMenuItem("复制(C)");
        miCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
        JMenuItem miCut=new JMenuItem("剪切(X)");
        miCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
        JMenuItem miPaste=new JMenuItem("粘贴(V)");
        miPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));

        menuEdit.add(miSelectAll);
        menuEdit.addSeparator();
        menuEdit.add(miCopy);
        menuEdit.add(miCut);
        menuEdit.addSeparator();
        menuEdit.add(miPaste);

        JCheckBoxMenuItem miAutoLine=new JCheckBoxMenuItem("自动换行(W)");
        miAutoLine.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,InputEvent.CTRL_MASK));
        miAutoLine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setLineWrap(textArea.getLineWrap());
            }
        });

        JMenuItem miFontSet = new JMenuItem("字体(F)");
        miFontSet.setMnemonic('F');
        miFontSet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font font = new Font("微软雅黑",Font.PLAIN,14);
                if (font != null) {
                    textArea.setFont(font);
                }
            }
        });

        menuOpti.add(miAutoLine);
        menuOpti.add(miFontSet);

        JMenuItem miStatusBar=new JMenuItem("状态栏(T)");
        miFontSet.setMnemonic('F');

        menuView.add(miStatusBar);

        JMenuItem miHelpContent = new JMenuItem("帮助信息……");
        miHelpContent.addActionListener(this::menuHelpActionPerformed);

        JMenuItem miAbout = new JMenuItem("关于……");
        miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,InputEvent.CTRL_MASK));
        miAbout.addActionListener(this::menuHelpActionPerformed);

        menuHelp.add(miHelpContent);
        menuHelp.add(miAbout);

        setJMenuBar(menubar);
        validate();
    }

    public void menuHelpActionPerformed(ActionEvent e) {
        if (((JMenuItem)e.getSource()).getText().equals("帮助信息……")) {
            String str = "这是一个GUI窗口、菜单和文本域演示测试的Demo！\r\n"+
                    "小宇飞刀(xieyunc)@江西南昌\r\n"+
                    "2019年12月9日 凌晨";
            JOptionPane.showMessageDialog(this, str,"帮助信息", 1);
        }
        else if (((JMenuItem)e.getSource()).getText().equals("关于……")) {
            String str = "GUI窗口、菜单和文本域Demo，Ver 0.9.3\r\n"+
                    "教学网址：http://blog.csdn.net/xieyunc\r\n"+
                    "小宇飞刀@江西南昌";
            JOptionPane.showMessageDialog(this, str,"关于本程序……", 1);
        }
    }

    private void initTextArea() {
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setFont(new Font(Font.MONOSPACED,Font.ROMAN_BASELINE,14));
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                isModified = true;
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                isModified = true;
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                isModified = true;
            }
        });

        container.add(textArea);
        validate();
    }

    private boolean openFile() {
        boolean isSucessed = false;
        String fn = FileOperator.selectFile(currentFileName,JFileChooser.OPEN_DIALOG);
        if (fn.equals("")) {
            return false;
        }

        try {
            String content = FileOperator.readTxt(fn);
            textArea.setText(content);
            currentFileName = fn;
            currentFileCharset = FileOperator.getFileCharsetName(fn);
            isModified = false;
            setTitle(new File(currentFileName).getName());

            isSucessed = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isSucessed;
    }

    private boolean canCloseFile() {
        boolean canClose = true;
        if (isModified) {
            int n = JOptionPane.showConfirmDialog(null, "文件已修改但未保存，要保存吗?", "确认对话框", JOptionPane.YES_NO_CANCEL_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                saveFile(currentFileName);
                //JOptionPane.showMessageDialog(new JFrame(),"文件已保存！");
            } else if (n == JOptionPane.NO_OPTION) {
                //JOptionPane.showMessageDialog(new JFrame(),"已放弃保存！");
            } else {
                canClose = false;
            }
        }

        return canClose;
    }

    private boolean saveFile(String fn) {
        String fileName = fn;
        if (fileName.equals("")) {
            fileName = FileOperator.selectFile(currentFileName, JFileChooser.SAVE_DIALOG);
        }
        if (fileName.equals("")) {
            return false;
        }

        boolean saveOK = false;
        try {
            String content = textArea.getText();
            saveOK = FileOperator.writeTxt(fileName, content, currentFileName);
            if (saveOK) { // && !currentFileName.equals(fileName)) {
                currentFileName = fileName;
                isModified = false;
                currentFileCharset = FileOperator.getFileCharsetName(currentFileName);
                setTitle(new File(currentFileName).getName());
            }
        }catch (Exception e) {
            //e.printStackTrace();
        }

        return saveOK;
    }

}
