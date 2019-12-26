/**
 * 文件名：MainMenu.java
 * 功能描述：菜单及功能类文件
 */

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;

public class MainMenu {
    private JFrame mainFrame = null;
    private JTextArea textArea = null;

    private String currentFileName = ""; //当前文件名
    private String currentFileCharset = "UTF-8";//当前文件字符编码
    private boolean isModified = false;//文件是否已修改

    public Clipboard clipboard = new Clipboard("系统剪切板");//剪贴板

    public boolean isModified() {
        return isModified;
    }

    public void setModified(boolean modified) {
        isModified = modified;
    }




    public MainMenu(JFrame owner,JTextArea textArea) {
        this.mainFrame = owner;
        this.textArea = textArea;
        initMenu();
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

        //---------------------------BEGIN 【文件】菜单-----------------------//
        JMenuItem miNew = new JMenuItem("新建(N)");
        miNew.setMnemonic('O');
        miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK)); //设置快捷键Ctrl_N
        miNew.addActionListener(this::menuFileActionPerformed);

        JMenuItem miOpen = new JMenuItem("打开(O)");
        miOpen.setMnemonic('O');
        miOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK)); //设置快捷键Ctrl_O
        miOpen.addActionListener(this::menuFileActionPerformed);

        JMenuItem miSave=new JMenuItem("保存(S)");
        miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK)); //设置快捷键Ctrl_S
        miSave.addActionListener(this::menuFileActionPerformed);

        JMenuItem miSaveAs = new JMenuItem("另存为(A)");
        miSaveAs.addActionListener(this::menuFileActionPerformed);

        JMenuItem miExit=new JMenuItem("退出(X)");
        miExit.addActionListener(this::menuFileActionPerformed);

        menuFile.add(miNew);
        menuFile.add(miOpen);
        menuFile.add(miSave);
        menuFile.add(miSaveAs);
        menuFile.addSeparator(); //分隔线
        menuFile.add(miExit);
        //---------------------------END 【文件】菜单-----------------------//

        //---------------------------BEGIN 【编辑】菜单-----------------------//
        JMenuItem miSelectAll = new JMenuItem("全选(A)");
        miSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
        miSelectAll.addActionListener(this::menuEditActionPerformed);

        JMenuItem miCut=new JMenuItem("剪切(X)");
        miCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
        miCut.addActionListener(this::menuEditActionPerformed);

        JMenuItem miCopy = new JMenuItem("复制(C)");
        miCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
        miCopy.addActionListener(this::menuEditActionPerformed);

        JMenuItem miPaste=new JMenuItem("粘贴(V)");
        miPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
        miPaste.addActionListener(this::menuEditActionPerformed);

        menuEdit.add(miSelectAll);
        menuEdit.addSeparator();
        menuEdit.add(miCut);
        menuEdit.add(miCopy);
        menuEdit.addSeparator();
        menuEdit.add(miPaste);
        //---------------------------END 【编辑】菜单-----------------------//

        //---------------------------BEGIN 【格式】菜单-----------------------//
        JCheckBoxMenuItem miAutoLine=new JCheckBoxMenuItem("自动换行(W)");
        textArea.setLineWrap(true);        //激活自动换行功能
        textArea.setWrapStyleWord(true);   //激活断行不断字功能
        miAutoLine.setState(textArea.getLineWrap());
        miAutoLine.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
        miAutoLine.addActionListener(this::menuFormatActionPerformed);

        JMenuItem miFontSet = new JMenuItem("字体(F)");
        miFontSet.setMnemonic('F');
        miFontSet.addActionListener(this::menuFormatActionPerformed);

        menuFormat.add(miAutoLine);
        menuFormat.add(miFontSet);
        //---------------------------END 【格式】菜单-----------------------//

        //---------------------------BEGIN 【查看】菜单-----------------------//
        JCheckBoxMenuItem miStatusBar=new JCheckBoxMenuItem("状态栏(T)");
        miFontSet.setMnemonic('F');
        miStatusBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //自已加状态栏自已写
            }
        });

        menuView.add(miStatusBar);
        //---------------------------END 【查看】菜单-----------------------//


        //---------------------------BEGIN 【帮助】菜单-----------------------//
        JMenuItem miHelpContent = new JMenuItem("帮助信息……");
        miHelpContent.addActionListener(this::menuHelpActionPerformed);

        JMenuItem miAbout = new JMenuItem("关于……");
        miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,Modifier.FINAL));
        miAbout.addActionListener(this::menuHelpActionPerformed);

        menuHelp.add(miHelpContent);
        menuHelp.addSeparator();
        menuHelp.add(miAbout);
        //---------------------------END 【帮助】菜单-----------------------//

        mainFrame.setJMenuBar(menubar);
        mainFrame.validate();
    }

    public void menuFileActionPerformed(ActionEvent e) {
        if (((JMenuItem)e.getSource()).getText().equals("新建(N)")) {
            if (canCloseFile()) {
                initVar();
            }
        }
        else if (((JMenuItem)e.getSource()).getText().equals("打开(O)")) {
            if (canCloseFile()) {
                openFile();
            }
        }
        else if (((JMenuItem)e.getSource()).getText().equals("保存(S)")) {
            saveFile(currentFileName);
        }
        else if (((JMenuItem)e.getSource()).getText().equals("另存为(A)")) {
            saveFile("");
        }
        else if (((JMenuItem)e.getSource()).getText().equals("退出(X)")) {
            if (canCloseFile()) {
                System.exit(0);
            }
        }
    }

    public void menuEditActionPerformed(ActionEvent e) {
        if (((JMenuItem)e.getSource()).getText().equals("全选(A)")) {
            textArea.selectAll();
        }
        else if (((JMenuItem)e.getSource()).getText().equals("复制(C)")) {
            copy();
        }
        else if (((JMenuItem)e.getSource()).getText().equals("剪切(X)")) {
            cut();
        }
        else if (((JMenuItem)e.getSource()).getText().equals("粘贴(V)")) {
            paste();
        }
    }

    public void menuFormatActionPerformed(ActionEvent e) {
        if (((JMenuItem)e.getSource()).getText().equals("自动换行(W)")) {
            boolean bl = ((JCheckBoxMenuItem)e.getSource()).getState();
            textArea.setLineWrap(bl);        //激活自动换行功能
            textArea.setWrapStyleWord(bl);   //激活断行不断字功能
        }
        else if (((JMenuItem)e.getSource()).getText().equals("字体(F)")) {
            Font myFont = FontDialog.showDialog(mainFrame);
            if (myFont != null) {
                textArea.setFont(myFont);
            }
        }
    }

    public void menuHelpActionPerformed(ActionEvent e) {
        if (((JMenuItem)e.getSource()).getText().equals("帮助信息……")) {
            String str = "这是江西科技师范大学软件动漫学院2018级计算机专业的实训作业之一！\r\n"+
                    "小宇飞刀(xieyunc)@江西南昌\r\n"+
                    "2019年12月25日 凌晨";
            JOptionPane.showMessageDialog(mainFrame, str,"帮助信息", 1);
        }
        else if (((JMenuItem)e.getSource()).getText().equals("关于……")) {
            String str = "小宇飞刀的记事本程序【实训作业三】，Ver 0.9.3 ......\r\n"+
                    "教学网址：http://blog.csdn.net/xieyunc\r\n"+
                    "小宇飞刀@江西南昌";
            JOptionPane.showMessageDialog(mainFrame, str,"关于本程序……", 1);
        }
    }

    public void cut() {
        copy();
        //标记开始位置
        int start = this.textArea.getSelectionStart();
        //标记结束位置
        int end = this.textArea.getSelectionEnd();
        //删除所选段
        this.textArea.replaceRange("", start, end);

    }

    public void copy() {
        //拖动选取文本
        String temp = textArea.getSelectedText();
        //把获取的内容复制到连续字符器，这个类继承了剪贴板接口
        StringSelection text = new StringSelection(temp);
        //把内容放在剪贴板
        this.clipboard.setContents(text, null);
    }

    public void paste() {
        //Transferable接口，把剪贴板的内容转换成数据
        Transferable contents = this.clipboard.getContents(this);
        //DataFalvor类判断是否能把剪贴板的内容转换成所需数据类型
        DataFlavor flavor = DataFlavor.stringFlavor;
        //如果可以转换
        if (contents.isDataFlavorSupported(flavor)) {
            String str;
            try {//开始转换
                str = (String) contents.getTransferData(flavor);
                //如果要粘贴时，鼠标已经选中了一些字符
                if (this.textArea.getSelectedText() != null) {
                    //定位被选中字符的开始位置
                    int start = this.textArea.getSelectionStart();
                    //定位被选中字符的末尾位置
                    int end = this.textArea.getSelectionEnd();
                    //把粘贴的内容替换成被选中的内容
                    this.textArea.replaceRange(str, start, end);
                } else {
                    //获取鼠标所在TextArea的位置
                    int mouse = this.textArea.getCaretPosition();
                    //在鼠标所在的位置粘贴内容
                    this.textArea.insert(str, mouse);
                }
            } catch (UnsupportedFlavorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private void initVar() { //初始化变量和文本框
        currentFileName = "";
        mainFrame.setTitle("记事本");
        isModified = false;
        currentFileCharset = "UTF-8";
        textArea.setText("");
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
            mainFrame.setTitle(new File(currentFileName).getName());

            isSucessed = true;
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return isSucessed;
    }

    private boolean canCloseFile() {
        boolean canClose = true;
        if (isModified) {
            int n = JOptionPane.showConfirmDialog(null, "文件已修改但未保存，要保存吗?", "确认对话框", JOptionPane.YES_NO_CANCEL_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                canClose = saveFile(currentFileName);
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
                mainFrame.setTitle(new File(currentFileName).getName());
            } else {
                JOptionPane.showMessageDialog(null, "文件保存失败！\r\n", "系统提示",JOptionPane.ERROR_MESSAGE);
            }

        }catch (Exception e) {
            //e.printStackTrace();
        }

        return saveOK;
    }

}
