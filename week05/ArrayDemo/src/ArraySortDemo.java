/**
	文件名：ArraySortDemo.java
	描述：数组的排序Demo
*/

import java.util.Random;
import java.util.Arrays;

public class ArraySortDemo {

	public static void main(String[] args) {
		// TODO 数组排序Demo
		Random r = new Random();
		int[] a = new int[5];
		for (int i=0;i<a.length;i++) {
			a[i] = r.nextInt(100);
		}
		System.out.println("排序之前：");
		for (int x:a) {
			System.out.print(x+" ");
		}

		Arrays.sort(a);
		System.out.println("\n排序之后升序输出：");
		for (int x:a) {
			System.out.print(x+" ");
		}
		
		System.out.println("\n排序之后降序输出：");
		for (int i = a.length-1; i >=0 ; i--) {
			System.out.print(a[i]+" ");
		}
		

	}
}

