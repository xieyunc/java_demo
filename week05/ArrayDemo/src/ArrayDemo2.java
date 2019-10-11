
public class ArrayDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[][] a = {{1,2,3},{7,8,9,10,11}};
		int[][] a = new int[2][];
		
		a[0] = new int[] {1,2,3};
		a[1] = new int[] {7,8,9,0};
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.print("a["+i+"]["+j+"]="+a[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-------------------------------------");

	}

}
