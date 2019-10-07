/**
	文件名：ArrayDemo1.java
	描述：一维数组的使用
*/
public class ArrayDemo1 {

	public static void main(String[] args) {
		// TODO 一维数组的使用
		//int[] a; //声明一个一维数组变量/对象
		//a = new int[5]; //为一维数组对象分配元素个数及内存空间
		//以上两条语句可写为：
		int[] a = new int[5]; 
		a[0] = 0;//为数据元素赋值
		a[1] = 2;
		a[2] = 4;
		a[3] = 6;
		a[4] = 8;
		
		for(int i = 0;i < a.length;i++) {
			System.out.println("a["+i+"]="+a[i]);
		}
		System.out.println("---------------------------------------------");

		for(int x:a) {
			System.out.println(x);
		}
		System.out.println("---------------------------------------------");
		
		int b[];//仿c++写法，不推荐
		b = new int[5];
		b[0] = 0;//为数据元素赋值
		b[1] = 2;
		b[2] = 4;
		b[3] = 6;
		b[4] = 8;
		
		for(int i = 0;i < b.length;i++) {
			System.out.println("b["+i+"]="+b[i]);
		}
		System.out.println("---------------------------------------------");

		int[] c = {1,3,5,5,9};//声明及赋值语句合二为一
		for(int i = 0;i < c.length;i++) {
			System.out.println("c["+i+"]="+c[i]);
		}
		System.out.println("---------------------------------------------");
		
		
	}

}
