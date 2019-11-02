import java.util.Enumeration;
import java.util.Vector;

/**
 * 文件名：EnumerationDemo.java
 * 功能描述：枚举接口用法Demo
 */
public class EnumerationDemo {
    public static void main(String[] args) {
        Enumeration<String> weekDays; //声明一个枚举对象
        Vector<String> weekDayNames = new Vector<String>(); //Vector：向量类，相当于于一个可变数组

        weekDayNames.add("星期一");
        weekDayNames.add("星期二");
        weekDayNames.add("星期三");
        weekDayNames.add("星期四");
        weekDayNames.add("星期五");
        weekDayNames.add("星期六");
        weekDayNames.add("星期日");

        weekDays = weekDayNames.elements(); //取出向量对象中的所有元素，放置到枚举对象中

        while(weekDays.hasMoreElements()) {
            System.out.println(weekDays.nextElement());
        }
    }

}
