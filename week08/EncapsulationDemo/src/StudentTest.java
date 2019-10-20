/**
 * 文件名：StudentTest.java
 * 功能描述：类的封装测试用例
 *
 */
public class StudentTest {
    public static void main(String[] args) {
    	
        String name = "张三丰";
        char sex = '男';
        int age = 21;
        
        Student stu1=new Student(name,sex,age);
        stu1.show();
    }
}
