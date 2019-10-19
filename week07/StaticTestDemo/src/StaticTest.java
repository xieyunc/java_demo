/**
 * 文件名：StaticTest.java
 * 功能描述：static修饰符的测试类
 */
class StaticTest{
    private static int count = 0 ;//用于统计实例化了多少个本类的对象
    public StaticTest(){
        count ++;
        System.out.printf("正在实例化第%d个对象……\n",count);
    }

    public static void show() {
        System.out.println("count="+count);
    }
}