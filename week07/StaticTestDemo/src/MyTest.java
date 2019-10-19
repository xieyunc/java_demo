/**
 * 文件名：MyTest.java
 * 功能描述：测试staticTest类中的静态方法
 */
public class MyTest{
    public static void main(String args[]){
        //1、通过类名调用静态方法，通过类名调用静态成员变量或静态成员方法并不会实例化对象
        StaticTest.show();
        StaticTest.show();

        System.out.println("-------------------------");

        //2、通过对象调用静态方法
        StaticTest myTest1 = new StaticTest();
        myTest1.show();
        StaticTest myTest2 = new StaticTest();
        myTest2.show();

        StaticTest.show();
    }
}