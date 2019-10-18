import java.util.Date;
import java.text.SimpleDateFormat;

public class StringFormatDemo {
    public static void main(String[] args) {
        char ch = 'A';
        byte bt = 97;
        int x = 99;
        double dd = 3213564.7851455;
        System.out.println(ch+","+bt+","+x);

        String ss = String.format("%c,%c,%c",ch,bt,x);
        System.out.println(ss);

        System.out.println(String.format("%06d",x));
        System.out.println(String.format("%,23.2f",dd));
        System.out.printf("%,23.2f",dd);

        Date toDay = new Date();

        System.out.println(toDay.toString());
        System.out.printf("%tF %tR\n",toDay,toDay);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        System.out.println(sdf.format(toDay));

    }
}
