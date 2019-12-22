/**
 * 文件名：Student.java
 * 功能描述：
 */
public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private float score;

    public Student(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String toString() {
        return String.format("%-10s%5d%15.1f",name,age,score);
    }

    @Override
    public int compareTo(Student o) {
        if (this.score>o.score)
            return -1;
        else if (this.score<o.score)
            return 1;
        else {
            if (this.age > o.age)
                return 1;
            else if (this.age < o.age)
                return -1;
            else
                return 0;
        }
    }
}
