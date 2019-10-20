/**
 * Singleton模式，即单例模式，在一个程序中只允许创建唯一一个实例的类，Singleton类的声明规则如下：
 * 1、类的构造方法的访问控制修饰符为 private，外界不能通过new创建该类的实例。
 * 2、在类的内部通过一个私有的静态属性引用该类的实例，禁止外界直接访问该属性。
 * 3、创建一个public static的get()方法，以使得外界能够获取该类的实例，由于该方法是静态的，因此
 *    可以通过 类名.方法名() 的方式来调用该方法。
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
        System.out.println("我是一个Singleton模式的类："+this.hashCode());
    }

    public static Singleton getInstance() {
        return instance;
    }
}
