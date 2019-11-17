import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * 文件名：PropertiesDemo.java
 * 功能描述：
 */
public class PropertiesDemo {
    public static void main(String[] args) {
        Properties dbSrvConnInfo = new Properties();
        dbSrvConnInfo.put("SrvIp","172.18.4.13");
        dbSrvConnInfo.put("dbType","MySQL");
        dbSrvConnInfo.put("dbName","student");
        dbSrvConnInfo.put("loginName","root");
        dbSrvConnInfo.put("loginPwd","abc@123");

        System.out.println("使用Iterator读取信息：");

        Set set = dbSrvConnInfo.keySet();

        Iterator iterator = set.iterator();

        while(iterator.hasNext()) {
            String key = iterator.next().toString();
            String value = dbSrvConnInfo.get(key).toString();

            System.out.println(key+" : "+value);
        }

        System.out.println("---------------------------------------");
        System.out.println("使用Enumeration读取信息：");

        Enumeration keys = dbSrvConnInfo.keys();

        while (keys.hasMoreElements()) {
            String key = keys.nextElement().toString();
            System.out.println(key+":"+dbSrvConnInfo.get(key));
        }

    }
}
