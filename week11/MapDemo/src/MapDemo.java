import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 文件名：MapDemo.java
 * 功能描述：Map类型数据的遍历Demo
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("001","张三");
        map.put("002","李四");
        map.put("003","王五");
        map.put("004","赵六");
        map.put("005","钱七");

        System.out.println("第1种方法，使用 for ... each 遍历：");
        for(String key: map.keySet()) {
            //此方法最常用，但需二次取值，故速度最慢，是第2、3种方法速度的一半
            System.out.println("key:"+key+",value:"+map.get(key));
        }

        System.out.println("\n第2种方法，使用 迭代器 遍历：");
        Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();
        System.out.println("使用 for ... each 遍历方式：");
        while(it.hasNext()) {
            //速度最快，且可以进行remove()这类的操作，it.remove();
            Map.Entry<String,String> entry = it.next();
            if(entry.getValue().equals("王五")) {
                it.remove();
                System.out.println("key:"+entry.getKey()+",value:"+entry.getValue()+" 已被删除！");
                continue;
            }

            System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
        }

        System.out.println("\n第3种方法，使用 Map.Entry (Iterator简化版) 遍历：");
        for(Map.Entry<String,String> entry: map.entrySet()) {
            //此方法与第2种方法的速度是一样的，由于使用 for ... each 方法，简化了迭代器的使用，
            //也正是因为使用 for ... each 方法，故无法进行remove()之类的操作
            System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
        }

        System.out.println("\n第4种方法，使用 map.values() 遍历：");
        for(String v : map.values()) {
            //速度快，无法取得相应的key值
            System.out.println("value:"+v);
        }

    }
}
