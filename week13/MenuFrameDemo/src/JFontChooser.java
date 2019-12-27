/**
 * 文件名：JFontChooser.java
 * 功能描述：
 */
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.event.*;
import javax.swing.event.*;

class JFontChooser extends JPanel implements ActionListener,ListSelectionListener {
    private JDialog dialog;// 用于显示模态的窗体
    private JComboBox fontNameComboBox;// 用于选择字体的下拉框
    private JList fontStyleList, fontSizeList;// 用于选择字形和字号的列表
    private JTextField fontSizeText;// 用于显示选中的字形和字号
    private JButton btnOK, btnCancel;// 表示选中和取消的按钮
    private Font currentFont;// 表示当然选中的字体
    private GraphicsEnvironment ge;// 表示当前的图形环境
    private JLabel demoLabel;// 表示预览的label
    private String fontName = "新宋体";
    private int fontStyle = Font.PLAIN, fontSize = 20;
    private Frame owner;// 表示父类的组件窗体
    private Hashtable<String, Integer> ht;// 名字到大小的映射

    /**
     * Creates a new instance of JFontChooser
     */
    private JFontChooser() {
        initOther();
    }

    private void initOther() {
        currentFont = new Font(fontName, fontStyle, fontSize);
        ht = new Hashtable<String, Integer>();
        fontSizeText = new JTextField("20 ");
        fontSizeText.setEditable(false);
        fontSizeText.setBounds(280, 40, 100, 20);
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] family = ge.getAvailableFontFamilyNames();
        fontNameComboBox = new JComboBox(family);
        fontNameComboBox.setEditable(false);
        fontNameComboBox.setMaximumRowCount(5);

        demoLabel = new JLabel("ABCD abcd 中文汉字", JLabel.CENTER);
        demoLabel.setFont(currentFont);
        String[] faceString = {"正常 ", "粗体 ", "斜体 ", "粗体+斜体 "};
        String[] sizeString = {"初号 ", "小初 ", "一号 ", "小一 ", "二号 ", "小二 ",
                "三号 ", "小三 ", "四号 ", "小四 ", "五号 ", "小五 ", "六号 ", "小六 ", "七号 ",
                "八号 ", "5 ", "8 ", "9 ", "10 ", "11 ", "12 ", "14 ", "16 ",
                "18 ", "20 ", "22 ", "24 ", "26 ", "28 ", "36 ", "48 ", "72 "};
        int[] sizeValue = {42, 36, 26, 24, 22, 18, 16, 15, 14, 12, 11, 9, 7,
                6, 5, 4, 5, 8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28,
                36, 48, 72};
        for (int i = 0; i < sizeString.length; i++) {
            ht.put(sizeString[i], sizeValue[i]);
        }
        fontStyleList = new JList(faceString);
        fontSizeList = new JList(sizeString);

        fontStyleList.setSelectedIndex(0);
        fontSizeList.setSelectedIndex(25);
        fontNameComboBox.setSelectedItem("新宋体");

        fontStyleList.setVisibleRowCount(4);
        fontSizeList.setVisibleRowCount(4);

        btnOK = new JButton("确定 ");
        btnCancel = new JButton("取消 ");

        btnOK.addActionListener(this);
        btnCancel.addActionListener(this);

        fontNameComboBox.addActionListener(this);
        fontStyleList.addListSelectionListener(this);
        fontSizeList.addListSelectionListener(this);
    }

    private void initWindow(String title) {
        this.setLayout(new BorderLayout());
        JLabel fontLabel = new JLabel("字体 ");
        JLabel faceLabel = new JLabel("字形 ");
        JLabel sizeLabel = new JLabel("字号 ");

        fontLabel.setForeground(Color.BLACK);
        faceLabel.setForeground(Color.BLACK);
        sizeLabel.setForeground(Color.BLACK);
        fontLabel.setBounds(20, 20, 100, 20);
        faceLabel.setBounds(180, 20, 100, 20);
        sizeLabel.setBounds(280, 20, 100, 20);

        fontNameComboBox.setBounds(10, 40, 150, 21);
        JScrollPane faceScroll = new JScrollPane(fontStyleList);
        JScrollPane sizeScroll = new JScrollPane(fontSizeList);
        faceScroll.setBounds(180, 40, 100, 115);
        sizeScroll.setBounds(280, 60, 100, 95);

        JPanel topPanel = new JPanel(null);
        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel bottomPanel = new JPanel();

        topPanel.setPreferredSize(new Dimension(345, 160));
        topPanel.add(fontLabel);
        topPanel.add(faceLabel);
        topPanel.add(sizeLabel);
        topPanel.add(fontNameComboBox);
        topPanel.add(faceScroll);
        topPanel.add(sizeScroll);
        topPanel.add(fontSizeText);
        //topPanel.setBorder(BorderFactory.createTitledBorder( "选择区 "));

        centerPanel.add(demoLabel, BorderLayout.CENTER);
        centerPanel.setBorder(BorderFactory.createTitledBorder("预览 "));

        bottomPanel.add(btnOK);
        bottomPanel.add(btnCancel);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

        dialog = new JDialog(owner, title, true);
        dialog.getContentPane().add(this, BorderLayout.CENTER);
        dialog.setSize(400, 300);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(owner);
        dialog.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent we) {
                currentFont = null;
                dialog.dispose();
            }

        });
        dialog.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fontNameComboBox) {
            fontName = (String) fontNameComboBox.getSelectedItem();
            currentFont = new Font(fontName, fontStyle, fontSize);
            demoLabel.setFont(currentFont);
            this.repaint();
        } else if (ae.getSource() == btnOK) {
            //dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dialog.dispose();
            dialog.setVisible(false);
        } else if (ae.getSource() == btnCancel) {
            currentFont = null;
            dialog.dispose();
            //dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dialog.setVisible(false);
        }
    }

    public void valueChanged(ListSelectionEvent le) {
        if (le.getSource() == fontStyleList) {
            String value = (String) fontStyleList.getSelectedValue();
            if (value.equals("正常 ")) {
                fontStyle = Font.PLAIN;
            } else if (value.equals("粗体 ")) {
                fontStyle = Font.BOLD;
            } else if (value.equals("斜体 ")) {
                fontStyle = Font.ITALIC;
            } else if (value.equals("粗体+斜体 ")) {
                fontStyle = Font.ITALIC | Font.BOLD;
            }
            currentFont = new Font(fontName, fontStyle, fontSize);
            demoLabel.setFont(currentFont);
            this.repaint();
        } else if (le.getSource() == fontSizeList) {
            String sizeName = (String) fontSizeList.getSelectedValue();
            fontSizeText.setText(sizeName);
            fontSize = ht.get(sizeName);
            currentFont = new Font(fontName, fontStyle, fontSize);
            demoLabel.setFont(currentFont);
            this.repaint();
        }
    }

    public static Font showDialog(Frame owner, String title) {
        JFontChooser jf = new JFontChooser();
        jf.owner = owner;
        jf.initWindow(title);
        return jf.currentFont;
    }
}
