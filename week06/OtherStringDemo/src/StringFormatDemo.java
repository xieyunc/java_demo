public class StringFormatDemo {
    public static void main(String[] args) {
        String ss = "abc";
        double dd = 78.56425478;
        boolean bl = false;
        int x = 97;
        byte ch = 65;

        System.out.println("格式化输出：");
        System.out.println(String.format("%s,%-6.2f,%b,%05d,%c",ss,dd,bl,x,x));

        System.out.printf("%s,%-6.2f,%b,%05d,%c,%d,%c",ss,dd,bl,x,x,ch,ch);
    }
}
