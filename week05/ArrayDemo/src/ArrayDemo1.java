
public class ArrayDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a ;//申明了一个一维数组，动态数组的定义
		a = new int[5];//实例化了一个包含5个元素的数组，并分配了相应大小的内存空间
		
		//int[] a = new int[5];
		
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		a[4] = 5;
		
		//int a = new int[] {1,2,3,4,5};
		
		for(int i = 0; i< a.length; i++) {
			System.out.print("a["+i+"]="+a[i]+"  ");
		}
		
		System.out.println("\n-----------------------------------------");

		
		int[] b = {1,3,5,7,9}; //静态数组 
		
		for(int i=0;i<b.length;i++)
			System.out.print("b["+i+"]="+b[i]+"  ");
		System.out.println("\n-----------------------------------------");
		
		char[] c = {'中','国','c','h','i','n','a'}; //静态数组 

		for(char m:c)
			System.out.print(m+"  ");
		System.out.println("\n-----------------------------------------");

		
	}

}
