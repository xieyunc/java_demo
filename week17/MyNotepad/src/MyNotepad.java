import javax.swing.*;
/**
 * 文件名：MenuFrameTest.java
 * 功能描述：记事本程序入口类文件
 */
class MyNotepad {

    public static void main(String[] args) {
        try {
            //String lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();//可跨平台风格，忽略时的默认风格
            String lookAndFeel = UIManager.getSystemLookAndFeelClassName();//当前系统风格
            UIManager.setLookAndFeel(lookAndFeel);

        }catch (Exception e) {}

        MainFrame myFrame = new MainFrame();
        myFrame.setVisible(true);
    }
}