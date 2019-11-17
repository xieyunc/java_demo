import java.util.Comparator;

/**
 * 文件名：StudentComparator.java
 * 功能描述：从外部实现对Student类的排序
 */
class StudentComparator implements Comparator<Student> {
    @Override
    //排序需求：实现成绩由高到低排列，如果成绩相同，则按年龄由小到大排序
    public int compare(Student o1, Student o2) {
        if (o1.getScore()>o2.getScore())
            return -1; //排序需求：成绩由高到低
        else if (o1.getScore()<o2.getScore())
            return 1;
        else {
            if (o1.getAge()>o2.getAge())
                return 1; //排序需求：成绩相同的话，年龄由大到小排序
            else if(o1.getAge()<o2.getAge())
                return -1;
            else
                return 0;
        }
    }
}
