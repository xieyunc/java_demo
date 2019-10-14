public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello,World!");
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Hello,World!").append("中国人民").append(12.56).append(true).append('m');
        StringBuffer sb9 = new StringBuffer("好人一生平安！abc");
        sb9.append("开心").append(45.678);

        System.out.println(sb9.toString());

        System.out.println(sb.toString());
        System.out.println(sb1.toString());

        //String s1 = sb.toString();
        //System.out.println(s1);

        System.out.println(sb == sb1);
        System.out.println(sb.equals(sb1));
        System.out.println(sb.toString().equals(sb1.toString()));

        StringBuilder sb2 = new StringBuilder("12.78");
        double dd = Double.parseDouble(sb2.toString());

        System.out.println(dd);

    }
}
