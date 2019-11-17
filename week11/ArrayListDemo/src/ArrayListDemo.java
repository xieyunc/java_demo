import java.util.*;

/**
 * 文件名：ArrayListDemo.java
 * 功能描述：迭代器的使用
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("苹果");
        list.add("香焦");
        list.add("梨");

        System.out.println("for ... each 遍历方式：");
        for(String em:list) {
            System.out.println(em);
        }

        System.out.println("使用数组遍历方式：");
        String[] strArray = new String[list.size()];
        list.toArray(strArray);
        for(int i=0;i<strArray.length;i++) {
            System.out.println(strArray[i]);
        }

        System.out.println("使用Iterator 遍历方式：");

        Iterator<String> iterator = list.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
