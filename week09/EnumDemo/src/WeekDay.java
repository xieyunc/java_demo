/**
 * 文件名：WeekDay.java
 * 功能描述：
 */
public enum WeekDay {
    Mon("周一"), Tue("周二"), Wed("周三"), Thu("周四"), Fri("周五"), Sat("周六"), Sun("周日");
    //以上是枚举的成员，必须先定义，而且使用分号结束，每一个成员都会调用枚举类的构造方法进行初始化
    private final String day; //每一个枚举元素均有一个day成员
    private WeekDay(String day) {
        this.day = day;
    }

    public static void printDay(int i){
        if (i>=0 && i<WeekDay.values().length) {
            WeekDay weekDay = WeekDay.values()[i];
            System.out.printf("ordinal():%d,name():%s,getDay():%s\n",weekDay.ordinal(),weekDay.name(),weekDay.getDay());
        }
        else
            System.out.println("非法的索引值！");

        /*
        switch(i){
            case 1:
                System.out.println(WeekDay.Mon);
                break;
            case 2:
                System.out.println(WeekDay.Tue);
                break;
            case 3:
                System.out.println(WeekDay.Wed);
                break;
            case 4:
                System.out.println(WeekDay.Thu);
                break;
            case 5:
                System.out.println(WeekDay.Fri);
                break;
            case 6:
                System.out.println(WeekDay.Sat);
                break;
            case 7:
                System.out.println(WeekDay.Sun);
                break;
            default:
                System.out.println("wrong number!");
        }
         */
    }

    public String getDay() {
        return day;
    }
}