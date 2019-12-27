import javax.swing.*;
/**
 * 文件名：MainMenuTest.java
 * 功能描述：测试类文件
 */
class MainMenuTest {

    public static void main(String[] args) {
        try {
            //String lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();//可跨平台风格，忽略时的默认风格
            String lookAndFeel = UIManager.getSystemLookAndFeelClassName();//当前系统风格
            UIManager.setLookAndFeel(lookAndFeel);

        }catch (Exception e) {}

        MainMenu myFrame = new MainMenu();
        myFrame.setVisible(true);
    }
}