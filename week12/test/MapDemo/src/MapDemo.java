import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 文件名：MapDemo.java
 * 功能描述：
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("001","张三");
        map.put("002","李四");
        map.put("003","王二小");
        map.put("003","谢力");//因为map.key不允许有重复值，已覆盖上一条语句

        for(String key:map.keySet()) {
            System.out.println("key:"+key+",value:"+map.get(key));
        }
        System.out.println("---------------------------------------");
        for(Map.Entry<String,String> entry: map.entrySet()) {
            System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
        }
        System.out.println("---------------------------------------");
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<String,String> entry = iterator.next();
            if(entry.getValue().equals("谢力")) {
                iterator.remove();
                System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
                continue;
            }
            System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
        }

    }
}
