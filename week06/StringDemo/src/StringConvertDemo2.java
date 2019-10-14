public class StringConvertDemo2 {

    public static void main(String[] args) {

        // 字符串转成基本类型Xxx.parseXxx(String s);  xxx：基本数据类型

        String str="12";
        System.out.println(str+1); // 121
        int s1=Integer.parseInt(str); // str内容必须是int格式
        System.out.println(s1+1); // 13


        String str2="2.3";
        double s2=Double.parseDouble(str2);
        System.out.println(s2+1); // 3.3

        //基本类型 转 字符串

        String s=12+""; // 方法1
        System.out.println(s);

        String s3=String.valueOf(2.3); // 方法2
        System.out.println(10+s3); // 102.3


        String s4 = Integer.toString(12); // 方法3  有参数 不是重写obj
        System.out.println(s4+1); // 13

    }
}
