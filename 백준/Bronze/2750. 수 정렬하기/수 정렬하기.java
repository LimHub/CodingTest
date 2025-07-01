import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner scan  = new Scanner(System.in);
    int N = scan.nextInt();
    int[] arr= new int[N];
    for(int i =0 ;i < N ;i ++){
      arr[i]=scan.nextInt();
    }
    for(int i =0;i<N-1;i++){
      for(int j = 0 ; j<N-1-i;j++){
        if(arr[j]>arr[j+1]){
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }
    for(int i = 0 ; i< N;i++){
      System.out.println(arr[i]);
    }
  }}
