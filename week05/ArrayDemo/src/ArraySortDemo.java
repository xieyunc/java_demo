import java.util.Random;
import java.util.Arrays;

public class ArraySortDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = new int[5];
		Random r = new Random();
		
		for(int i=0; i < a.length; i++){
			a[i] = r.nextInt(100);
		}
		
		System.out.println("未排序之前的原始数据：");
		for(int x:a) {
			System.out.print(x+" ");
		}
		
		Arrays.sort(a); //对数组a进行排序（升序）
		
		System.out.println("\n排序后以升序输出：");
		for(int x:a) {
			System.out.print(x+" ");
		}

		System.out.println("\n排序后以降序输出：");
		for(int i=a.length-1; i>=0 ; i--) {
			System.out.print(a[i]+" ");
		}
		
		

	}

}
