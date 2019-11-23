import java.lang.reflect.Array;
import java.util.*;

/**
 * 文件名：GenericTest.java
 * 功能描述：
 */
public class GenericTest {
    public static void printData(List<?> data) {
        //System.out.println("data : "+data.get(0));

        Iterator<?> iterator= data.iterator();
        while(iterator.hasNext()) {
            System.out.println("data :"+iterator.next());
        }
    }

    public static void printNumber(List<? extends Number> data) {
        //System.out.println("data :" + data.get(0));

        Iterator<?> iterator = data.iterator();
        while (iterator.hasNext()) {
            System.out.println("data :" + iterator.next());
        }
    }

    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> height = new ArrayList<Number>();

        name.add("小宇飞刀");
        age.add(29);
        height.add(170f);

        name.add("张三丰");
        age.add(18);
        height.add(180.0);

        //printNumber(name); //此语句无法编译，因为printNumber()方法中的参数已经限定了参数泛型上限为Number
        printData(age);
        printNumber(height);
    }
}
