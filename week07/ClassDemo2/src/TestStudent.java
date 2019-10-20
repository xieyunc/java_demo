/**
 * 文件名：TestStudent.java
 * 功能描述：对Student类进行测试的类
 */
public class TestStudent {
    public static void main(String[] args) {

        System.out.println("调用Student.schoolName的结果："+Student.schoolName);//通过“类名.变量名”直接调用静态成员变量
        System.out.println("调用Student.getSchoolName()的结果："+Student.getSchoolName());//通过“类名.方法名”直接调用静态方法

        //Student.schoolName = "软件动漫学院"; //语法错误，schoolName为最终变量（常量）
        //Student.show();//语法错误，show()为普通成员方法，不能通过类名直接调用，必须通过对象名来调用

        System.out.println("-----------------------------------------------");
        Student stu1 = new Student();

        System.out.println("调用stu1.getSchoolName()的结果："+stu1.getSchoolName());//通过“对象名.方法名”直接调用静态方法
        stu1.show();//普通方法只能通过“对象名.方法名”的方式调用

        Student stu2 = new Student("张三丰",20);

        System.out.println("调用stu2.getSchoolName()的结果："+stu2.getSchoolName());//通过“对象名.方法名”直接调用静态方法
        stu2.show();//普通方法只能通过“对象名.方法名”的方式调用
    }
}