//如果一个类/成员变量/成员方法，没有明确声明访问修饰符，则为默认的访问修饰符 default，它们的作用域为本包。
class Student {
    //如果此处已为schoolName赋了初值，那么其它作任何地方都不允许再有对schoolName进行赋值的语句了。
    //static final String schoolName = "江西科技师范大学";//校名，静态成员变量
    static final String schoolName;//校名，静态成员变量
    String name;    //姓名
    int age;        //年龄

    {
        /*动态代码块，每创建(实例化)一个对象时均会执行*/
        name = "李寻欢";
        age = 28;
    }

    static {
        /*静态代码块，第一次使用类时才会执行，而且只会执行一次*/
        schoolName = "江西科技师范大学"; //也可以在声明schoolName变量的地方初始化，不能同时在这两个地方均有赋值语句，只能二选一。
        System.out.println("Student类的静态代码块被执行！");
    }

    public Student() {
    }

    public Student(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.printf("学校：%s\t姓名：%s\t年龄：%d\n",schoolName,name,age);
    }

    public static String getSchoolName() {
        return schoolName;
    }
}