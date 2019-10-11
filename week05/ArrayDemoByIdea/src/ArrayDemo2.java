public class ArrayDemo2 {
    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6,7,8}};
        for(int i=0; i<a.length; i++) {
            for(int j=0;j < a[i].length; j++) {
                System.out.print("a["+i+"]["+j+"]="+a[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("---------------------------------");

        int[][] b = new int[2][];
        b[0] = new int[3];
        b[1] = new int[5];

        for(int i=0;i<b.length;i++) {
            for(int j=0;j<b[i].length;j++) {
                b[i][j] = (i+1)*j;
            }
        }

        for(int i=0; i<b.length; i++) {
            for(int j=0;j < b[i].length; j++) {
                System.out.print("b["+i+"]["+j+"]="+b[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("---------------------------------");

    }
}
