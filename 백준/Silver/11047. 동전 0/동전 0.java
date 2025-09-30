import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer firstLine = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(firstLine.nextToken());
      int K = Integer.parseInt(firstLine.nextToken());

      int cnt = 0;
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
          arr[i] = Integer.parseInt(br.readLine());
      }
      int i = N - 1;
      while(K > 0 && i >= 0 ){
        if(K < arr[i]){
          i -= 1;
        }
        else{
          cnt = cnt + (K / arr[i]);
          K = K % arr[i];
        }
      }
      System.out.println(cnt);

  }  
}
