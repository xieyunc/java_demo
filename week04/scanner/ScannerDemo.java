import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] arg) {
		//final double PI = 3.14;
		int x,y;
		Scanner input = new Scanner(System.in);
		System.out.print("请输入被除数：");
		if (input.hasNextInt()) {
			x = input.nextInt();
		}
		else{
			System.out.println("输入的数据不是整数！");
			return;
		}
			
		System.out.print("请输入除数：");
		if (input.hasNextInt()) {
			y = input.nextInt();
			if (y==0){
				System.out.println("除数不能为0！");
				return;
			}
		}
		else{
			System.out.println("输入的数据不是整数！");
			return;
		}
		
		System.out.println(String.format("%d/%d=%d",x,y,x/y));
		
		System.out.print("请输入小数：");
		double d1 = input.nextFloat();
		System.out.println("d1="+d1);

		System.out.print("请输入文字（不包含空格）：");
		String s1 = input.next(); //可以获取不包括空格的字符串
		System.out.println("s1="+s1);

		System.out.print("请输入一行文字：");
		String s2 = input.nextLine(); //可以获取包括空格的字符串
		System.out.println("s2="+s2);
	}
}