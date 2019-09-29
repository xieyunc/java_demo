public class ForDemo {
	public static void main(String[] args) {
		int i, s = 0;
		for (i = 3;i<=100;i+=3) {
			s += i;
			if (s>=1000)
				break;
		}
		System.out.println("i="+i);
		System.out.println("s="+s);
	}
}
