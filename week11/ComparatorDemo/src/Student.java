/**
 * 文件名：Student.java
 * 功能描述：未实现排序接口的Student类
 */
public class Student {
    private String name;
    private int age;
    private float score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Student(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String toString() {
        return String.format("%-10s%5d%15.1f",name,age,score);
    }
}

