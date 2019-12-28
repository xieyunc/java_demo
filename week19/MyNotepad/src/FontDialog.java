/**
 * 文件名：FontDialog.java
 * 功能描述：字体选择对话框。
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.event.*;
import javax.swing.border.*;

public class FontDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    private static Font resultFont = null;

    JList listFontName, listFontStyle, listFontSize, listFontColor;
    JTextField editFontName, editFontStyle, editFontSize, editFontColor;
    JButton[] ColorButton;
    String demoString;
    JLabel labelExample;
    JButton btnOK, btnCancel;
    private Color[] colorArray = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY,
                Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA,
                Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
    private String[] colorNameArray = {"黑色", "蓝色", "青色", "深灰", "灰色",
            "绿色", "浅灰", "紫色", "橙色", "粉红", "红色", "白色", "黄色"};
    //Map<String,Color> colorHashMap = new HashMap<String,Color>();
    //colorHashMap.put("黑色",Color.BLACK);


    //private String[] fontStyleArray = {"PLAIN", "BOLD", "ITALIC", "BOLD ITALIC"};
    private String[] fontStyleArray = {"正常","加粗","倾斜","加粗+倾斜"};

    private JFrame frame;

    public FontDialog(JFrame owner,Font defaultFont, String title, boolean modal) {
        super(owner, title, modal);
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        this.frame = owner;
        setLocationRelativeTo(owner);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelMain = new JPanel();
        panelMain.setLayout(new GridLayout(2, 1));
        JPanel panelFontSet, panelFontView;
        panelFontSet = new JPanel(new GridLayout(1, 4));
        panelFontView = new JPanel(new GridLayout(1, 2));
        demoString = "AaBbCcDdEe";
        labelExample = new JLabel(demoString, JLabel.CENTER);
        labelExample.setBackground(Color.WHITE);

        ListSelectionListener selectionListener = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (((JList) e.getSource()).getName().equals("listFontName")) {
                    editFontName.setText((String) listFontName.getSelectedValue());
                    labelExample.setFont(new Font(editFontName.getText(), labelExample.getFont().getStyle(), labelExample.getFont().getSize()));
                }
                if (((JList) e.getSource()).getName().equals("listFontStyle")) {
                    editFontStyle.setText((String) listFontStyle.getSelectedValue());
                    labelExample.setFont(new Font(labelExample.getFont().getFontName(), listFontStyle.getSelectedIndex(), labelExample.getFont().getSize()));
                }
                if (((JList) e.getSource()).getName().equals("listFontSize")) {
                    editFontSize.setText((String) listFontSize.getSelectedValue());
                    try {
                        Integer.parseInt(editFontSize.getText());
                    } catch (Exception excepInt) {
                        editFontSize.setText(labelExample.getFont().getSize() + "");
                    }
                    labelExample.setFont(new Font(labelExample.getFont().getFamily(), labelExample.getFont().getStyle(), Integer.parseInt(editFontSize.getText())));
                }
                if (((JList) e.getSource()).getName().equals("listFontColor")) {
                    editFontColor.setText(colorNameArray[listFontColor.getSelectedIndex()]);
                    labelExample.setForeground(colorArray[listFontColor.getSelectedIndex()]);
                }
            }
        };

        KeyListener keyListener = new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    if (((JTextField) e.getSource()).getName().equals("listFontName")) {
                        labelExample.setFont(new Font(editFontName.getText(), labelExample.getFont().getStyle(), labelExample.getFont().getSize()));
                    }
                    if (((JTextField) e.getSource()).getName().equals("listFontStyle")) {
                        //int x = listFontStyle.getSelectedIndex();
                        //String fsName = fontStyleCnArray[x];
                        //editFontStyle.setText((String) listFontStyle.getSelectedValue());

                        if (defaultFont.getStyle()>=0)
                            editFontStyle.setText(fontStyleArray[defaultFont.getStyle()]);
                        //editFontStyle.setText((String) listFontStyle.getSelectedValue());
                        labelExample.setFont(new Font(labelExample.getFont().getFontName(), listFontStyle.getSelectedIndex(), labelExample.getFont().getSize()));
                    }
                    if (((JTextField) e.getSource()).getName().equals("listFontSize")) {
                        try {
                            Integer.parseInt(editFontSize.getText());
                        } catch (Exception excepInt) {
                            editFontSize.setText(labelExample.getFont().getSize() + "");
                        }
                        labelExample.setFont(new Font(labelExample.getFont().getFontName(), labelExample.getFont().getStyle(), Integer.parseInt(editFontSize.getText())));
                    }
                }
            }

            public void keyReleased(KeyEvent e) {
            }

            public void keyTyped(KeyEvent e) {
            }
        };

        // 字体
        JPanel panelFontName = new JPanel();
        Border border = BorderFactory.createLoweredBevelBorder();
        border = BorderFactory.createTitledBorder(border, "字体");
        panelFontName.setBorder(border);
        /*
        Font[] fontArray = java.awt.GraphicsEnvironment
                .getLocalGraphicsEnvironment().getAllFonts();
        int fontArrayCount = fontArray.length;
        //String[] fontNameArray = new String[fontArrayCount];
        for (int i = 0; i < fontArrayCount; i++) {
            fontNameArray[i] = fontArray[i].getFontName();// .getName();
        }
        */

        String[] fontNameArray = java.awt.GraphicsEnvironment
                .getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        listFontName = new JList(fontNameArray);
        listFontName.setName("listFontName");
        listFontName.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        String fontName = defaultFont.getFamily();
        listFontName.addListSelectionListener(selectionListener);
        listFontName.setVisibleRowCount(6);

        editFontName = new JTextField(defaultFont.getFontName());
        editFontName.setName("editFontName");
        editFontName.setText(fontName);
        editFontName.addKeyListener(keyListener);
        JScrollPane jspFontName = new JScrollPane(listFontName);
        panelFontName.setLayout(new BoxLayout(panelFontName, BoxLayout.PAGE_AXIS));
        panelFontName.add(editFontName);
        panelFontName.add(jspFontName);

        /*
        ArrayList<String> aList = new ArrayList<String>();
        for(String em: fontNameArray) {
            aList.add(em);
        }
        int x = aList.indexOf(fontName);
        if (x>-1) {
            //listFontName.setSelectedIndex(x);
            //listFontName.ensureIndexIsVisible(listFontName.getSelectedIndex()); //把索引处的项目显示出来
        }
        */
        //设置默认字体为主窗口传递过来的文本框的现有字体信息
        listFontName.setSelectedValue(fontName,true);
        //listFontName.ensureIndexIsVisible(listFontName.getSelectedIndex()); //把索引处的项目显示出来
        //监听器会自动从列表框的已选中的项目更新文本框中的内容

        // 样式
        JPanel panelFontstyle = new JPanel();
        border = BorderFactory.createLoweredBevelBorder();
        border = BorderFactory.createTitledBorder(border, "样式");
        panelFontstyle.setBorder(border);
        listFontStyle = new JList(fontStyleArray);
        listFontStyle.setName("listFontStyle");
        listFontStyle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listFontStyle.addListSelectionListener(selectionListener);
        listFontStyle.setVisibleRowCount(6);

        editFontStyle = new JTextField(fontStyleArray[defaultFont.getStyle()]);
        editFontStyle.setName("listFontStyle");
        editFontStyle.addKeyListener(keyListener);
        JScrollPane jspFontStyle = new JScrollPane(listFontStyle);
        panelFontstyle.setLayout(new BoxLayout(panelFontstyle, BoxLayout.PAGE_AXIS));
        panelFontstyle.add(editFontStyle);
        panelFontstyle.add(jspFontStyle);

        //设置默认字体为主窗口传递过来的文本框的现有字体信息
        listFontStyle.setSelectedIndex(defaultFont.getStyle());
        //监听器会自动从列表框的已选中的项目更新文本框中的内容

        // 大小
        JPanel panelFontSize = new JPanel();
        border = BorderFactory.createLoweredBevelBorder();
        border = BorderFactory.createTitledBorder(border, "大小");
        panelFontSize.setBorder(border);
        String[] fontSizeArray = {"8", "9", "10", "11", "12", "14", "16", "18",
                "20", "22", "24", "26", "30", "32", "34", "36"};
        listFontSize = new JList(fontSizeArray);
        listFontSize.setName("listFontSize");
        listFontSize.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listFontSize.addListSelectionListener(selectionListener);
        listFontSize.setVisibleRowCount(6);
        editFontSize = new JTextField(fontSizeArray[0]);
        editFontSize.setName("listFontSize");
        editFontSize.addKeyListener(keyListener);
        JScrollPane jspFontSize = new JScrollPane(listFontSize);
        panelFontSize.setLayout(new BoxLayout(panelFontSize, BoxLayout.PAGE_AXIS));
        panelFontSize.add(editFontSize);
        panelFontSize.add(jspFontSize);

        //设置默认字体为主窗口传递过来的文本框的现有字体信息
        String fontSize = String.valueOf(defaultFont.getSize());
        listFontSize.setSelectedValue(fontSize,true);
        //editFontSize.setText(fontSize);//监听器会自动从列表框的已选中的项目更新文本框中的内容

        // 颜色
        JPanel panelFontColor = new JPanel();
        Border borderColor = BorderFactory.createLoweredBevelBorder();
        borderColor = BorderFactory.createTitledBorder(borderColor, "颜色");
        panelFontColor.setBorder(borderColor);
        listFontColor = new JList(colorNameArray);
        listFontColor.setName("listFontColor");
        listFontColor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listFontColor.addListSelectionListener(selectionListener);
        listFontColor.setVisibleRowCount(6);
        editFontColor = new JTextField(colorNameArray[0].toString());
        editFontColor.setName("editFontColor");
        editFontColor.addKeyListener(keyListener);
        JScrollPane jspFontColor = new JScrollPane(listFontColor);
        panelFontColor.setLayout(new BoxLayout(panelFontColor, BoxLayout.PAGE_AXIS));
        panelFontColor.add(editFontColor);
        panelFontColor.add(jspFontColor);

        panelFontSet.add(panelFontName);
        panelFontSet.add(panelFontstyle);
        panelFontSet.add(panelFontSize);
        //panelFontSet.add(panelFontColor);

        panelFontView.add(labelExample);
        panelMain.add(panelFontSet);
        panelMain.add(panelFontView);

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout());
        btnOK = new JButton("确定");
        btnCancel = new JButton("取消");

        panelButton.add(btnOK);
        panelButton.add(btnCancel);

        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultFont = labelExample.getFont();
                FontDialog.this.setVisible(false);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultFont = null;
                FontDialog.this.setVisible(false);
            }
        });

        container.add(panelMain, BorderLayout.CENTER);
        container.add(panelButton, BorderLayout.SOUTH);
        setSize(400, 300);
        //this.setVisible(true);
    }

    public static Font showDialog(JFrame owner,Font defaultFont) {
        FontDialog fontDialog = new FontDialog(owner, defaultFont,"字体设置", true);
        fontDialog.setVisible(true);
        return resultFont;
    }
}


