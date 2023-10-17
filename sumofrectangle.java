import java.util.Scanner;

public class sumofrectangle {
    //Brute force Approach
    static int sumrectangle(int[][] matrix,int l1,int r1,int l2,int r2){
        int sum=0;
        for(int i=l1;i<=l2;i++){
            for(int j=r1;j<=r2;j++){
                sum+=matrix[i][j];
            }
        }
        return sum;
    }
    static void prefixsum(int[][]matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
    }
    //matrix[i][j]=sumrectangle((0,0),(i,j))
    static void prefixsum2(int[][]matrix){
        int r=matrix.length;
        int c=matrix[0].length;
        for(int i=0;i<r;i++){
            for(int j=1;j<c;j++){
                matrix[i][j]+=matrix[i][j-1];
            }
        }
        for (int j=0;j<c;j++){
            for(int i=1;i<r;i++){
                matrix[i][j]+=matrix[i-1][j];
            }
        }
    }
    static int sumrectangle2(int[][] matrix,int l1,int r1,int l2,int r2){
        int sum=0;
        prefixsum(matrix);
        for(int i=l1;i<=l2;i++){
            if( r1>=1){
                sum+=matrix[i][r2]-matrix[i][r1-1];
            }
            else sum+=matrix[i][r2];
        }

        return sum;
    }
    static int sumrectangle3(int[][] matrix,int l1,int r1,int l2,int r2){
        int ans;
        int sum,up=0,left=0,leftup=0;
        prefixsum2(matrix);
        sum=matrix[l2][r2];
        if(l1>=1) up=matrix[l1-1][r2];
        if(r1>=1)left=matrix[l2][r1-1];
        if(l1>=1&&r1>=1) leftup=matrix[l1-1][r1-1];
        ans=sum-up-left-leftup;

        return ans;
    }

        public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
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
        System.out.println("Enter The Coordinates of Rectangle");
        int l1= sc.nextInt();
        int r1= sc.nextInt();
        int l2= sc.nextInt();
        int r2= sc.nextInt();
        int ans=sumrectangle(arr1,l1,r1,l2,r2);
        System.out.println(ans);
        int ans1=sumrectangle2(arr1,l1,r1,l2,r2);
        System.out.println(ans1);
        System.out.println(sumrectangle3(arr1,l1,r1,l2,r2));
    }
}
