/**
 * 文件名：StudentTest.java
 * 功能描述：测试Demo文件
 */

public class StudentTest {
    public static void main(String[] args) {
        Student[] students = {
                new Student("张三",8,78.0f),
                new Student("李四",20,100.0f),
                new Student("王五",19,78.0f),
                new Student("赵六",21,85.0f),
                new Student("钱七",23,63)
        };

        System.out.println("------------排序之前：-------------");
        for(Student stu: students) {
            System.out.println(stu);
        }

        java.util.Arrays.sort(students,new StudentComparator());

        System.out.println("------------排序之后：-------------");
        for(Student stu: students) {
            System.out.println(stu);
        }

    }
}
