import java.util.Arrays;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        String s1 = "";
        System.out.println(s1.isEmpty());
        sb.append("Hello");
        System.out.println("Hello".equals(sb.toString()));
        System.out.println(sb.toString().equals("Hello"));

        //sb.append(",");
        //sb.append("World!");

        sb.append(",").append("World!").append(100).append('中').append(false).append(3.14);
        System.out.println(sb.toString());
        sb.replace(5,9,"小宇飞刀");
        System.out.println(sb.toString());

        sb.insert(3,"人民abc");
        System.out.println(sb.toString());

        sb.delete(3,8);
        System.out.println(sb.toString());

        System.out.println(sb.charAt(3));
        System.out.println(sb.indexOf("刀",10));
        System.out.println(sb.toString());

        System.out.println(sb.substring(5,9));

        String s2 = "江西;山东,广东,内蒙古;湖北,福建";
        s2 = s2.replaceAll(";",",");
        String[] sfStr = s2.split(",");

        System.out.println(s2);
        System.out.println(Arrays.toString(sfStr));

    }
}
