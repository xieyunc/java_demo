import java.text.SimpleDateFormat;
import java.util.Date;

public class StringFormatDemo {
    public static void main(String[] args) {
        int x = 16;
        char ch = 'A';
        byte bt = 97;
        double dd = 7851412.957418;

        System.out.println(x);
        System.out.println(ch);
        System.out.println(bt);
        System.out.println(dd);

        String s1 = String.format("%06d",x);
        System.out.println(s1);
        System.out.println(String.format("%-6d     ",x));
        System.out.println(String.format("%,3.2f",dd));
        System.out.printf("%c",ch); //使用printf()方法可以简化String.Format()的写法
        System.out.printf("\n%c\n",bt);

        Date dt = new Date(); //获取系统当前日期和时间
        //Date对象的格式化串必须以 "%t"开始 F参数表示日期格式为yyyy-MM-dd  T参数表示时间格式为HH:mm:ss
        System.out.printf("%tF %tT",dt,dt);

        System.out.println("\n===============================");


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String sdt = sdf.format(dt);
        System.out.println(sdt);


    }
}
