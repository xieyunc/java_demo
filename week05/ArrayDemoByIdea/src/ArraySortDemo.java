import java.util.Random;
import java.util.Arrays;

public class ArraySortDemo {
    public static void main(String[] args) {
        int[] a = new int[5];
        Random r = new Random();

        for(int i=0; i<a.length;i++) {
            a[i] = r.nextInt(100);
        }
        System.out.println("原始数据：");
        for(int x:a) {
            System.out.print(x+" ");
        }
        System.out.println("\n----------------------------------");

        Arrays.sort(a); //升序排序

        System.out.println("拓序后升序输出：");
        for(int x:a) {
            System.out.print(x+" ");
        }
        System.out.println("\n----------------------------------");

        System.out.println("拓序后降序输出：");
        for(int i=a.length-1;i>=0;i--) {
            System.out.print(a[i]+" ");
        }
        System.out.println("\n----------------------------------");

    }
}
