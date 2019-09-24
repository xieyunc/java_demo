public class ForDemo {
	public static void main(String[] args) {
		int i = 3,s = 0;
		while(i<=100) {
			s += i;
			if (s>=800)
				break;
			i+=3;
		}
		System.out.println("i="+i+",s="+s);
	}
}