import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 文件名：SetCompareDemo.java
 * 功能描述：
 */
public class SetCompareDemo {
    public static void main(String[] args) {
        String[] coins = {"Penny","nickel","dime","Quarter","dollar"};
        //String[] coins = {"中国","日本","美国","澳大利亚","韩国"};
        Set<String> set = new HashSet<String>();
        for (int i = 0; i< coins.length; i++) {
            set.add(coins[i]);
        }

        System.out.println(Collections.min(set));
        System.out.println(Collections.min(set,String.CASE_INSENSITIVE_ORDER));
        System.out.println(Collections.min(set,String));

        System.out.println("--------------------------");
        System.out.println(Collections.max(set));
        System.out.println(Collections.max(set,String.CASE_INSENSITIVE_ORDER));
    }
}
