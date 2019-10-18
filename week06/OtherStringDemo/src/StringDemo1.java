import java.util.Arrays;

public class StringDemo1 {
    public static void displayArray(byte[] btArray) {
        System.out.print("[");
        for(int i=0;i<btArray.length;i++) {
            System.out.print(btArray[i]);
            if (i<btArray.length-1)
                System.out.print(", ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        String s1 = "Hello,World!";
        String s2 = "Hello,World!";
        String s3 = new String("Hello,World!");

        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s1.equals(s3));

        byte[] btArray = {65,66,67,68};

        System.out.println("=====================");
        displayArray(btArray);
        System.out.println("\n=====================");
        System.out.println(Arrays.toString(btArray));

        String s4 = new String(btArray);
        System.out.println(s4);

        char[] chArrray = {'中','a','3'};
        String s5 = new String(chArrray);
        System.out.println(s5);

        byte[] btArray2;
        btArray2 = s1.getBytes();
        System.out.println(Arrays.toString(btArray2));

        char[] chArray2;
        chArray2 = s1.toCharArray();
        System.out.println(Arrays.toString(chArray2));

        System.out.println(s1.length());
        System.out.println(s1.charAt(5));

        System.out.println(s1);
        System.out.println(s1.indexOf("lo"));  //如果没有"lo"这一子串，返回-1，否则返回"lo"在s1中的起始位置
        System.out.println(s1.contains("lo"));

        String s6 = "Hello,world!";

        System.out.println(s1.equals(s6)); //false
        System.out.println(s1.equalsIgnoreCase(s6));//true

        System.out.println("-----------------------------------------------");
        System.out.println(s6);
        System.out.println(s6.replace("w","W"));
        s6 = s6.replace("w","W");
        System.out.println(s6);

        s6 = "  ab cd efg     ";
        System.out.println(s6.trim());
        System.out.println(s6);
    }
}
