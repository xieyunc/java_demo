public class StringDemo1 {
    public static void main(String[] args) {
        String s1 = "Hello,World!";
        String s2 = "Hello,World!";
        String s3 = new String("Hello,World!");

        System.out.println("s1 == s2 :" + (s1 == s2));
        System.out.println("s1 == s3 :" + (s1 == s3));
        System.out.println(s1.equals(s3));

        byte[] bytes = {65,66,67,68}; //ASCII
        for(byte ch:bytes){
            System.out.print((char)ch+" ");
        }

        for(byte ch:bytes) {
            System.out.printf("\n%c ",ch);
        }

        System.out.println(bytes);

        String s4 = new String(bytes);

        System.out.println(s4);

        String s5 = new String(bytes,1,3);
        System.out.println(s5);

        char[] bArray ;

        bArray = s1.toCharArray();
        byte[] bArr = s1.getBytes();

        for(char ch:bArray) {
            System.out.print(ch+" ");
        }

        char[] cArray = {'中','a','3'};

        String s6 = new String(cArray);
        System.out.println("\n"+s6);

        System.out.println(s6.length());
        System.out.println(s1);
        System.out.println(s1.substring(3));
        System.out.println(s1.substring(3,5));

        System.out.println(s1.indexOf('H'));
        System.out.println(s1.toUpperCase());
        System.out.println(s1.toLowerCase());
        System.out.println(s1.replace("Hello","你好"));
        s1  = s1.replace('W','w');
        System.out.println(s1);

        String s7 = String.valueOf(12.35);

        double dd = Double.parseDouble(s7);

        int x = (int)Double.parseDouble(s7);

        System.out.println(s7);
        System.out.println(dd+10);
        System.out.println(x);

    }

}
