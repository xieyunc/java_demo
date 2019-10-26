/**
 * 文件名：Door.java
 * 功能描述：“门”的抽象类
 */
public abstract class Door {
    private int height; //门的高度
    private int width;  //门的宽度
    private String color;  //门的颜色
    private double price;  //门的单价

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Door(int height, int width, String color, double price) {
        this.height = height;
        this.width = width;
        this.color = color;
        //this.price = price;
        setPrice(price);
    }

    public void summary() { //门的简介
        System.out.println(String.format("高:%dcm,宽:%dcm,颜色:%s，单价：%,.2f元",height,width,color,price));
    }

    abstract void open();  //开门功能
    abstract void close(); //关门功能
}
