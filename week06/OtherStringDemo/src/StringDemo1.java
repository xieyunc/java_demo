import java.util.Arrays;

public class StringDemo1 {
    public static void main(String[] args) {
        String s1 = "Hello,World!";
        String s2 = "Hello,World!";
        String s3 = new String("Hello,World!");

        System.out.println(s1==s2);
        System.out.println(s1==s3);

        byte[] bytes = {65,66,67,68};
        char[] intArray = {97,98,99,100};

        for(byte ch:bytes){
            System.out.print(ch+" ");
        }

        System.out.println("\n"+Arrays.toString(bytes));
        System.out.println(bytes.toString());

        String s4 = new String(bytes);
        String s5 = new String(bytes,1,2);
        String s6 = new String(intArray);

        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);

        byte[] bytes1 = s1.getBytes();
        char[] cArray = s1.toCharArray();

        System.out.println(Arrays.toString(bytes1));
        System.out.println(Arrays.toString(cArray));

        System.out.println(s1.length());
        System.out.println(s1.charAt(3));
        System.out.println(s1.indexOf("LLo"));
        System.out.println(s1.contains("LLo"));
        System.out.println(s1.startsWith("Hello"));
        System.out.println(s1.substring(3,5));
        System.out.println(s1.replace("World","Java"));
        s1 = s1.replace("World","Java");
        System.out.println(s1.toString());

        String ss = "江西;浙江;北京;天津,四川,广东;湖北,湖南,黑龙江,内蒙古";

        String[] strArray = ss.split(";");
        for(String str:strArray) {
            System.out.println(str);
        }


    }
}
