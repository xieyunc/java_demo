/**
 * 文件名：GenericClassTest.java
 * 功能描述：泛型类的测试
 */
public class GenericClassTest {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<Double> doubleBox = new Box<Double>();
        Box<String> stringBox = new Box<String>();

        integerBox.setT(10);
        doubleBox.setT(12.56);
        stringBox.setT("小宇飞刀");

        System.out.printf("整型值为：%d\n\n",integerBox.getT());
        System.out.printf("浮点型值为：%.2f\n\n",doubleBox.getT());
        System.out.printf("字符串为：%s\n\n",stringBox.getT());
    }
}
