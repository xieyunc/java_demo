import java.util.Comparator;

/**
 * 文件名：StudentComparator.java
 * 功能描述：
 */
public class StudentComparator implements Comparator<Student> {
    public int compare(Student o1,Student o2) {
        if(o1.getScore()>o2.getScore())
            return -1;
        else if(o1.getScore()<o2.getScore())
            return 1;
        else {
            if (o1.getAge() > o2.getAge())
                return 1;
            else if (o1.getAge() < o2.getAge())
                return -1;
            return 0;
        }
    }
}
