import java.text.Collator;

/**
 * 文件名：MaximumTest.java
 * 功能描述：有界的类型参数泛型测试例子
 * 使用说明：要申明是一个有界的类型参数，首先列出类型参数的名称，后跟extends关键字，最后紧跟它的上界
 */
public class MaximumTest {
    public static <T extends Comparable<T>> T maximum(T x,T y,T z) {
        T max = x;
        if (max instanceof String) {
            //Collator类可以使用本地化的语言规则比较字符串的大小
            Collator collator = Collator.getInstance();
            if (collator.compare(y, max) > 0)
                max = y;
            if (collator.compare(z, max) > 0)
                max = z;
        } else {
            if (y.compareTo(max)>0)
                max = y;
            if (z.compareTo(max)>0)
                max = z;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.printf("%d, %d 和 %d 中最大的数为 %d\n\n",3,4,5,maximum(3,4,5));

        System.out.printf("%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n",3.3,7.4,6.5,maximum(3.3,7.4,6.5));

        System.out.printf("%s, %s 和 %s 中最大的数为 %s\n\n","one","two","three",maximum("one","two","three"));

        System.out.printf("%s, %s 和 %s 中最大的数为 %s\n\n","李四","张三","王小",maximum("李四","张三","王二"));

    }
}
