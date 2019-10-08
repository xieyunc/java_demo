
public class ArrayDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a; //声明一个一维数组变量/对象
		a = new int[5];//a数组里面有5个元素，为所有元素分配了空间
		
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		a[4] = 5;
		
		for(int i=0;i<a.length;i++)
			System.out.print("a["+i+"]="+a[i]+"   ");
		
		System.out.println("\n-----------------------------------------------------");
		
		int[] b = new int[5];
		b[0] = 1;
		b[1] = 2;
		b[2] = 3;
		b[3] = 4;
		b[4] = 5;
		
		for(int i=0;i<b.length;i++)
			System.out.print("b["+i+"]="+b[i]+"   ");
		
		System.out.println("\n-----------------------------------------------------");
		
		int[] c = new int[] {1,2,3,4,5};
		for(int i=0;i<c.length;i++)
			System.out.print("c["+i+"]="+c[i]+"   ");
		
		System.out.println("\n-----------------------------------------------------");
		
		int[] d = {1,2,3,4,5};
		for(int i=0;i<d.length;i++)
			System.out.print("d["+i+"]="+d[i]+"   ");
		
		System.out.println("\n-----------------------------------------------------");

	}

}
