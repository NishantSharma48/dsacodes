import java.util.Scanner;

public class spiralmatrix {
   static void printMatrix(int arr[][]){
        for (int[] ints : arr) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + "\t");
            }
            System.out.println();
        }
    }
    static int[][] spiralMatrix(int n){
       int [][]matrix=new int[n][n];
       int topRow=0,bottomRow=n-1,leftCol=0,rightCol=n-1;
       int i,j;
       int count =1;
       while(count<=n*n){
           for(j=leftCol;j<=rightCol&&count<=n*n ;j++){
               matrix[topRow][j]=count++;
           }
           topRow++;
           for(i=topRow;i<=bottomRow && count<=n*n;i++){
               matrix[i][rightCol]=count++;
           }
           rightCol--;
           for(j=rightCol;j>=leftCol && count<=n*n;j--){
               matrix[bottomRow][j]=count++;
           }
           bottomRow--;
           for(i=bottomRow;i>=topRow && count<=n*n;i--){
               matrix[i][leftCol]=count++;
           }
           leftCol++;
       }
       return matrix;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n");
        int n= sc.nextInt();
        int [][]matrix=spiralMatrix(n);
        printMatrix(matrix);
    }
}
