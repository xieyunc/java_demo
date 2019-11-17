/**
 * 文件名：Student.java
 * 功能描述：实现了排序接口的Student类
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
    //排序需求，成绩由高到低排列，如果成绩相同，则按年龄由小到大排序
    public int compareTo(Student o) {
        if (this.score>o.score)
            return -1;//成绩由高到低
        else if (this.score<o.score)
            return 1;
        else { //如果成绩相同，年龄小者靠前
            if (this.age>o.age)
                return 1;//由小到大
            else if (this.age<o.age)
                return -1;
            else
                return 0;
        }
    }
}
