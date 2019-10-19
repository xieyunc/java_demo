/**
 * 文件名：Student.java
 * 功能描述：演示如何定义一个类
 * 如果一个类的定义中，没有声明任何构造方法，则该类自动继承了Object类的一个无参数的构造方法，
 * 在本类中，Student类自动拥有了一个默认的构造方法：
 *          public Student() {
 *              super();
 *          }
 */

//如果一个类/成员变量/成员方法，没有明确声明访问修饰符，则为默认的访问修饰符 default，它们的作用域为本包。
class Student {
    static String schoolName; //校名
    String name;    //姓名
    int age;        //年龄

    /*动态代码块*/{
        name = "张三";
        age = 19;
    }

    static {
        schoolName = "江西科技师范大学";
        System.out.println("Student类的静态代码块被执行！");
    }

    public Student(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.printf("学校：%s\t姓名：%s\t年龄：%d",schoolName,name,age);
    }
}
