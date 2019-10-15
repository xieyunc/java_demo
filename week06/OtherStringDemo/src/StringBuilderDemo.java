public class StringBuilderDemo {
    public static void main(String[] args) {
        String s1 = "Hello,World!";
        StringBuilder sb1 = new StringBuilder("Hello,World!");
        StringBuilder sb2 = new StringBuilder(s1);

        String s2 = sb2.toString();

        sb2.append("中国人民");
        System.out.println(sb2.toString());
        System.out.println(sb2.replace(0,5,"你好"));

        System.out.println(sb2.delete(1,4));
        System.out.println(sb2.toString());

        System.out.println(sb1.equals(s1));
        System.out.println(s1.equals(sb1));
        System.out.println(sb1.toString()==s1);

        System.out.println(s1.equals(sb1.toString()));
        System.out.println(sb1.toString().equals(s1));

        StringBuffer sb3 = new StringBuffer("abcd");
        sb3.append(101).append('m').append(true).append(56.78);

        System.out.println(sb3.toString());



    }
}
