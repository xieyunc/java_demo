/**
 * 文件名：StudentTest.java
 * 功能描述：
 */
public class StudentTest {
    public static void main(String[] args) {
        Student[] students = {
                new Student("张三",18,78f),
                new Student("李四",28,88f),
                new Student("王五",38,98.5f),
                new Student("赵六",48,58f),
                new Student("钱七",58,68.5f)
        };

        for(Student stu: students) {
            System.out.println(stu);
        }
        System.out.println("-----------------------------------");
        java.util.Arrays.sort(students);
        for(Student stu: students) {
            System.out.println(stu);
        }

    }
}
