import javax.swing.*;
/**
 * 文件名：MenuFrameTest.java
 * 功能描述：测试类文件
 */
class MenuFrameTest {

    public static void main(String[] args) {
        try {
            //String lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();//可跨平台风格，忽略时的默认风格
            String lookAndFeel = UIManager.getSystemLookAndFeelClassName();//当前系统风格
            UIManager.setLookAndFeel(lookAndFeel);

        }catch (Exception e) {}

        MenuFrame myFrame = new MenuFrame();
        myFrame.setVisible(true);
    }
}