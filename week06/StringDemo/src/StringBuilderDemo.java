public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sBuilder = new StringBuilder("江西科技师范学院：");
        sBuilder.append("www.");
        sBuilder.append("jxstnu.");
        sBuilder.append("edu.");
        sBuilder.append("cn");

        System.out.println("sBuilder原始内容："+sBuilder);
        System.out.println("替换字符串后："+sBuilder.replace(6,8,"大学"));
        System.out.println("sBuilder容量："+sBuilder.capacity());
        System.out.println("sBuilder长度："+sBuilder.length());
        System.out.println("sBuilder子串："+sBuilder.substring(9));
        System.out.println("sBuilder.reverse()："+sBuilder.reverse());

        String sVer = new String(sBuilder.toString());
        System.out.println(sVer);
        System.out.println(sVer.length());
    }
}

