/**
 * 文件名：MenuFrame.java
 * 功能描述：菜单窗口类
 */
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.lang.reflect.Modifier;
import javax.swing.*;
public class MenuFrame extends JFrame {
    private TextArea textArea;
    private String currentFileName = ""; //当前文件名
    private String currentFileCharset = "UTF-8";//当前文件字符编码
    private boolean isModified = false;//文件是否已修改

    public MenuFrame() {
        initFrame();
        initMenu();
        initTextArea();
    }

    private void initFrame() {
        setTitle("记事本");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置窗口关闭方式
        setSize(700,450);
        setLocationRelativeTo(null); //居中显示
    }

    private void initMenu() {
        JMenuBar menubar = new JMenuBar();//菜单条栏、菜单条：它是菜单的容器
        JMenu menuFile = new JMenu("文件(F)");
        JMenu menuEdit = new JMenu("编辑(E)");
        JMenu menuFormat = new JMenu("格式(O)");
        JMenu menuView = new JMenu("查看(V)");
        JMenu menuHelp = new JMenu("帮助(H)");

        menuFile.setMnemonic('F'); //设置菜单的热键为字母键F，需按下Alt键和字母键F
        menuEdit.setMnemonic('E');
        menuFormat.setMnemonic('O');
        menuView.setMnemonic('V');
        menuView.setMnemonic('H');

        menubar.add(menuFile); //把主菜单条加入菜单栏容器中
        menubar.add(menuEdit);
        menubar.add(menuFormat);
        menubar.add(menuView);
        menubar.add(menuHelp);

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

        JMenuItem miAutoLine=new JMenuItem("自动换行(W)");
        miAutoLine.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10,Modifier.FINAL));

        JMenuItem miFontSet = new JMenuItem("字体(F)");
        miFontSet.setMnemonic('F');
        miFontSet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font font = JFontChooser.showDialog(null, "字体选择 ");
                if (font != null) {
                    textArea.setFont(font);
                }
            }
        });

        menuFormat.add(miAutoLine);
        menuFormat.add(miFontSet);

        JMenuItem miStatusBar=new JMenuItem("状态栏(T)");
        miFontSet.setMnemonic('F');

        menuView.add(miStatusBar);

        JMenuItem miHelpContent = new JMenuItem("帮助信息……");
        JMenuItem miAbout = new JMenuItem("关于……");
        miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,Modifier.FINAL));

        menuHelp.add(miHelpContent);
        menuHelp.add(miAbout);


        setJMenuBar(menubar);
        validate();
    }

    private void initTextArea() {
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        textArea = new TextArea();
        textArea.setFont(new Font(Font.MONOSPACED,Font.ROMAN_BASELINE,14));
        textArea.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
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
