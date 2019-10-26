/**
 * 文件名：RoomDoor.java
 * 功能描述：普通房间门类
 */
public class RoomDoor extends Door {
    public RoomDoor(int height, int width, String color, double price) {
        super(height, width, color, price);
    }

    @Override
    void open() {
        System.out.println("正在开门……");
    }

    @Override
    public void summary() {
        System.out.print("类型：普通门，规格：");
        super.summary();
    }

    @Override
    void close() {
        System.out.println("正在关门……");
    }
}
