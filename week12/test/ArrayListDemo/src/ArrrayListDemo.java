import java.util.*;

/**
 * 文件名：ArrrayListDemo.java
 * 功能描述：
 */
public class ArrrayListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("苹果");
        list.add("香焦");
        list.add("雪梨");
        list.add("香焦");

        for(String em:list) {
            System.out.println(em.toString());
        }

        String[] strArray = new String[list.size()];
        list.toArray(strArray);
        for(int i=0;i<strArray.length;i++) {
            System.out.println(strArray[i]);
        }

        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
