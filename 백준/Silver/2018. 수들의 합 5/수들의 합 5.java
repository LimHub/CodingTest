import java.util.*;

public class Main {
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    
    int sum = 1;
    int start_index = 1;
    int end_index = 1;
    int cnt = 1;

    while(end_index != N){
      if(sum == N){
          cnt ++;
          end_index++;
          sum +=end_index;
      }
      else if(sum < N){
          end_index++;
          sum += end_index;
      }
      else{
        sum -= start_index;
        start_index++;
      }
    }
    System.out.println(cnt);
  }  
}
