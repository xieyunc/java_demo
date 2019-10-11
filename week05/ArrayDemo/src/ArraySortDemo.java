import java.util.Random;
import java.util.Arrays;

public class ArraySortDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = new int[8];
		Random r = new Random();
		for(int i=0;i<a.length;i++) {
			//a[i] = (int)(Math.random()*100);
			a[i] = r.nextInt(100);
		}
		
		System.out.println("原始数据：");
		for(int x:a) {
			System.out.print(x+"  ");
		}
		System.out.println("\n-----------------------------------------");
		
		Arrays.sort(a); //排序，升序
		
		System.out.println("排序后数据（升序）：");
		for(int x:a) {
			System.out.print(x+"  ");
		}
		System.out.println("\n-----------------------------------------");
		
		System.out.println("排序后数据（降序）：");
		for(int i=a.length-1;i>=0;i--) {
			System.out.print(a[i]+"  ");
		}
		System.out.println("\n-----------------------------------------");
		

	}

}
