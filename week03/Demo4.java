import java.util.Scanner;

public class Demo4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入你的成绩：");
		int score = input.nextInt();
		
		switch(score/10){
			case 10:
			case 9:
				System.out.println("优");
				break;
			case 8:
				System.out.println("良");
				break;
			case 7:
				System.out.println("中");
				break;
			case 6:
				System.out.println("及");
				break;
			default:
				System.out.println("差");
				break;
		}
	}
}