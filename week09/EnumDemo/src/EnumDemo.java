/**
 * 文件名：EnumDemo.java
 * 功能描述：枚举类型操作Demo
 */

public class EnumDemo {
    public static void main(String[] args)
    {
        System.out.println("WeekDay.Mon.getDay()："+WeekDay.Mon.getDay());
        WeekDay.printDay(3);

        for(WeekDay day:WeekDay.values())
        {
            System.out.println(day+"====>"+day.getDay());//输出中文星期信息
        }
    }
}
