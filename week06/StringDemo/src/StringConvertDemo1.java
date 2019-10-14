/**
 * 本Demo是字符串和字符数组之间的相互转换功能的展示
 */

import java.util.Arrays;

public class StringConvertDemo1 {
    public static void main(String[] args) {
        String sVer = "小宇飞刀！";
        char[] cArray;

        //把一个字符串转换为字符数组
        cArray = sVer.toCharArray();//或者直接：cArray = "小宇飞刀".toCharArray();

        System.out.println("字符串sVer:"+sVer);

        //使用foreach遍历输出数组中的元素值
        System.out.print("数组cArray:");
        for (char ch: cArray) {
            System.out.print(ch);
        }

        //通过Arrays静态类提供的方法输出数组的内容：Arrays.toString(数组变量)
        System.out.println("\n数组cArray:"+Arrays.toString(cArray));

        System.out.println("-----------------------------------------------------------");

        char[] cArray2 = {'中','国','人','民'};

        String sVer2 = String.valueOf(cArray2);//或者：String sVer2 = new String(cArray2);

        System.out.println("数组cArray2的内容:"+Arrays.toString(cArray2));
        System.out.println("字符串sVer2的内容:"+sVer2);

        System.out.println("-----------------------------------------------------------");
        System.out.println("字符串sVer:"+sVer);
        System.out.print("原始数组内容cArray:");
        System.out.println(cArray);
        System.out.println("sVer.equals(cArray):"+sVer.equals(cArray));
        System.out.println("sVer.equals(String.valueOf(cArray)):"+sVer.equals(String.valueOf(cArray)));

    }
}
