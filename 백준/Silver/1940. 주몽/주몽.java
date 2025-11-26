import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[])throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    

    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0 ; i < N ; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    int i = 0 ;
    int j = N - 1;
    int cnt = 0;
    
    while(i<j){
      if(arr[i] + arr[j] < M){
        i++;
      }
      else if(arr[i] + arr[j] > M){
        j--;
      }else{
        cnt++;
        i++;
        j--;
      }
    }

    System.out.println(cnt);
  }
}
