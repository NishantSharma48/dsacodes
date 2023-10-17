import java.util.Scanner;

public class spiraltraversal {
    static void printMatrix(int arr[][]){
        for (int[] ints : arr) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + "\t");
            }
            System.out.println();
        }
    }
    static void spiralTraversal(int[][]matrix,int r,int c){
        int topRow=0,bottomRow=r-1,leftCol=0,rightCol=c-1;
        int totalcount=0;
        int i,j;
        while(totalcount < r*c){
            //top row-->left col to right col
            for( j=leftCol;j<=rightCol && totalcount<r*c;j++){
                System.out.print(matrix[topRow][j]+"\t");
                totalcount++;
            }
            topRow++;
            //right col--> top row to bottom row
            for(i=topRow;i<=bottomRow && totalcount<r*c;i++){
                System.out.print(matrix[i][rightCol]+"\t");
                totalcount++;
            }
            rightCol--;
            //bottom row--> right col to left col
            for(j=rightCol;j>=leftCol&&totalcount<r*c;j--){
                System.out.print(matrix[bottomRow][j]+"\t");
                totalcount++;
            }
            bottomRow--;
            //left col-->bottomrow to toprow
            for(i=bottomRow;i>=topRow&&totalcount<r*c;i--){
                System.out.print(matrix[i][leftCol]+"\t");
                totalcount++;
            }
            leftCol++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r,c,i,j;
        //input for matrix 1
        System.out.println("Enter Number of Row and column of Matrix");
        r = sc.nextInt();
        c = sc.nextInt();
        int[][] arr1 = new int[r][c];
        System.out.println("Enter Elements of Matrix");
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }
        System.out.println("original Matrix: ");
        printMatrix(arr1);
        System.out.println("Spiral Traversed Matrix");
        spiralTraversal(arr1,r,c);
    }
}
