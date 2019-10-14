public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer sBuffer = new StringBuffer("软件动漫学院：");
        sBuffer.append("2018计算机1班,");
        sBuffer.append("2018计算机2班,");
        sBuffer.append("2018软件开发1班");

        System.out.println("sBuffer原始内容："+sBuffer);
        System.out.println("sBuffer容量："+sBuffer.capacity());
        System.out.println("sBuffer长度："+sBuffer.length());
        System.out.println("sBuffer子串："+sBuffer.substring(7,16));
        System.out.println("sBuffer.reverse()："+sBuffer.reverse());

        String sVer = new String(sBuffer);
        System.out.println(sVer);
        System.out.println(sVer.length());
    }
}
