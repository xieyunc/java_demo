public class StringDemo {
    public static void main(String[] args) {
        String sVer = "I love you!";
        String sVer2 = "i love you!";

        System.out.println("原始字符串内容sVer:"+sVer);
        System.out.println("sVer.length():"+sVer.length());
        System.out.println("sVer == sVer2 :"+(sVer == sVer2));
        System.out.println("sVer.equals(sVer2):"+sVer.equals(sVer2));
        System.out.println("sVer.equalsIgnoreCase(sVer2):"+sVer.equalsIgnoreCase(sVer2));

        System.out.println("sVer.subString(2):"+sVer.substring(2));//获得从索引2开始一直至最后的字符串

        System.out.println("下一行是获得从索引2开始至索引6(不包含6)的字符串：");
        System.out.println("sVer.subString(2,6):"+sVer.substring(2,6));//获得从索引2开始至索引6(不包含6)的字符串
        System.out.println("sVer.toLowerCase():"+sVer.toLowerCase());
        System.out.println("sVer.toUpperCase():"+sVer.toUpperCase());
        System.out.println("sVer.replace(\"you\",\"java\"):"+sVer.replace("java","java"));

        char cVer = '中';
        int iVer = 78;
        double dVer = 3.1415;

        String sFormatStr = String.format("%s,%c,%06d,%.3f",sVer,cVer,iVer,dVer);
        System.out.println(sFormatStr);

    }
}
