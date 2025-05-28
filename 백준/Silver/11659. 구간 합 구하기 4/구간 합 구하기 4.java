import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int dataNum = scan.nextInt();
        int questNum = scan.nextInt();

        int[] arr = new int[dataNum+1];
        for(int i=1;i<=dataNum;i++){
            arr[i] = scan.nextInt();
        }
        int[] arr1 = new int[dataNum+1];
        arr1[0]= arr[0]=0;
        for(int i =1 ; i<=dataNum;i++){
            arr1[i]=arr[i]+arr1[i-1];
        }
       
        for(int i=0;i<questNum;i++){
            int firstNum = scan.nextInt();
            int secondNum = scan.nextInt();
            System.out.println(arr1[secondNum]-arr1[firstNum-1]);
        }
        scan.close();
    }
}