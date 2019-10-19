public class SingleTest {
    public static void main(String[] args) {
        Single single1 = Single.getSingle();
        Single single2 = Single.getSingle();

        if (single1.equals(single2)) {
            System.out.println("只有一个单例模式的实例对象！");
        } else {
            System.out.println("违背事实！");
        }

        System.out.printf("实例对象Single1的哈希码为：%d\n",single1.hashCode());
        System.out.printf("实例对象Single2的哈希码为：%d\n",single2.hashCode());

    }
}
