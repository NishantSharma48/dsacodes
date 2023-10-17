import java.util.Scanner;

public class SOD {
    static int Sod(int n){
        int ans;
        if(n>=0&&n<=9) return n;
        return Sod(n/10)+n%10;
    }
    static int cod(int n){
        if (n>=1&&n<=9) return 1;
        return cod(n/10)+1;
    }
    public static void main(String[] args) {
        System.out.println("Enter A Number: ");
        Scanner sc=new Scanner(System.in);
       int  n=sc.nextInt();
        //System.out.println(Sod(n));
        //System.out.println(cod(n));
    }

}
