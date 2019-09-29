import java.util.Scanner;

public class WhileDemo2 {
	public static void main(String[] args) {
		int score = 0;
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.print("请输入你的成绩(输入-1退出)：");
			score = input.nextInt();
			
			if (score==-1){
				break;
			}
			
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
}