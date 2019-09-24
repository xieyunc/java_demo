import java.util.Scanner;

public class DoWhileDemo {
	public static void main(String[] args) {
		String myName;
		Scanner input = new Scanner(System.in);
		do{
			System.out.print("请输入姓名（输入q退出）：");
			
			myName = input.next();
		}while (!myName.equals("q"));
		
		System.out.println("结束程序！");
	}
}