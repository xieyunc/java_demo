/**
 * 文件名：PasswordDoor.java
 * 功能描述：带密码和报警功能的防盗门
 */

import java.util.Scanner;

public class PasswordDoor extends Door implements Alarm {
    private String password; //用于存储的密码门的认证密码信息

    public void setPassword(String password) {
        this.password = password;
    }

    public PasswordDoor(int height, int width, String color, double price) {
        super(height, width, color, price);
        setPassword("000000");//防盗门的初始密码为6个“0”
    }

    @Override
    public void summary() {
        System.out.print("类型：防盗门，规格：");
        super.summary();
    }

    @Override
    public void alarm() {
        System.out.println("发出报警声音，同时自动拔打报警电话……");
    }

    @Override
    void open() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入密码：");
        String myPassword = input.nextLine();
        if (myPassword.equals(password)) {
            System.out.println("正在开门……");
        }
        else {
            System.out.println("非法用户正在试图开门……");
            alarm();//报警
        }
    }

    @Override
    void close() {
        System.out.println("正在关门……");
    }
}
