/**
 * 文件名：FontDialog.java
 * 功能描述：字体选择对话框。
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
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
    Color[] colorArray = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY,
            Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA,
            Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
    String[] colorNameArray = {"BLACK", "BLUE", "CYAN", "DARK_GRAY", "GRAY",
            "GREEN", "LIGHT_GRAY", "MAGENTA", "ORANGE", "PINK", "RED", "WHITE",
            "YELLOW"};

    private JFrame frame;

    public FontDialog(JFrame owner, String title, boolean modal) {
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
                    labelExample.setFont(new Font(labelExample.getFont().getFontName(), labelExample.getFont().getStyle(), Integer.parseInt(editFontSize.getText())));
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
                        editFontStyle.setText((String) listFontStyle.getSelectedValue());
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
        Font[] fontArray = java.awt.GraphicsEnvironment
                .getLocalGraphicsEnvironment().getAllFonts();
        int fontArrayCount = fontArray.length;
        String[] fontNameArray = new String[fontArrayCount];
        for (int i = 0; i < fontArrayCount; i++) {
            fontNameArray[i] = fontArray[i].getName();
        }
        listFontName = new JList(fontNameArray);
        listFontName.setName("listFontName");
        listFontName.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listFontName.addListSelectionListener(selectionListener);
        listFontName.setVisibleRowCount(6);
        editFontName = new JTextField(fontNameArray[0]);
        editFontName.setName("editFontName");
        editFontName.addKeyListener(keyListener);
        JScrollPane jspFontName = new JScrollPane(listFontName);
        panelFontName.setLayout(new BoxLayout(panelFontName, BoxLayout.PAGE_AXIS));
        panelFontName.add(editFontName);
        panelFontName.add(jspFontName);

        // 样式
        JPanel panelFontstyle = new JPanel();
        border = BorderFactory.createLoweredBevelBorder();
        border = BorderFactory.createTitledBorder(border, "样式");
        panelFontstyle.setBorder(border);
        String[] fontStylesArray = {"PLAIN", "BOLD", "ITALIC", "BOLD ITALIC"};
        listFontStyle = new JList(fontStylesArray);
        listFontStyle.setName("listFontStyle");
        listFontStyle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listFontStyle.addListSelectionListener(selectionListener);
        listFontStyle.setVisibleRowCount(6);
        editFontStyle = new JTextField(fontStylesArray[0]);
        editFontStyle.setName("listFontStyle");
        editFontStyle.addKeyListener(keyListener);
        JScrollPane jspFontStyle = new JScrollPane(listFontStyle);
        panelFontstyle.setLayout(new BoxLayout(panelFontstyle, BoxLayout.PAGE_AXIS));
        panelFontstyle.add(editFontStyle);
        panelFontstyle.add(jspFontStyle);

        // 大小
        JPanel panelFontSize = new JPanel();
        border = BorderFactory.createLoweredBevelBorder();
        border = BorderFactory.createTitledBorder(border, "大小");
        panelFontSize.setBorder(border);
        String[] fontSizeArray = {"10", "14", "18", "22", "26", "30"};
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

    public static Font showDialog(JFrame owner) {
        FontDialog fontDialog = new FontDialog(owner, "字体设置", true);
        fontDialog.setVisible(true);
        return resultFont;
    }
}


