public class Demo4 {
	public static void main(String[] args) {
		int score = 70;
		
		switch(score/10){
			case 10:
			case 9:
				System.out.println("优");
				break;
			case 8:
				System.out.println("良");
				break;
			case 7:
				System.out.println("中等");
				break;
			case 6:
				System.out.println("及格");
				break;
			default:
				System.out.println("差");
				break;
		}
	}
}