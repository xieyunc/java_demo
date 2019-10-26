/**
 * 文件名：DoorTest.java
 * 功能描述：Door测试类
 */
public class DoorTest {
    public static void main(String[] args) {
        Door aDoor = new RoomDoor(220,150,"红色",800.00);
        aDoor.summary();//简介
        aDoor.open();
        aDoor.close();

        aDoor = new PasswordDoor(260,180,"金色",3000);
        aDoor.summary();//简介

        aDoor.open();

        if (aDoor instanceof PasswordDoor) { //更换了防盗门的密码
            ((PasswordDoor)aDoor).setPassword("admin000");
            System.out.println("更换了防盗门的密码！");
        }
        aDoor.open();
        aDoor.close();

    }
}
