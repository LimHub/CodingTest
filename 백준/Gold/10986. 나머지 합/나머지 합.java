import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[])throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    long answer = 0;
    long[] arr = new long[N+1];
    long[] C = new long[M];
    arr[0] = 0;
    st = new StringTokenizer(br.readLine());
    // 구간합 배열 저장
    for(int i = 1 ; i <=N ; i++){
      arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
      int remainder = (int)(arr[i] % M);
      if(remainder == 0) answer++;
      C[remainder]++;
    }
    
    for(int i = 0 ; i < M ; i++){
      if(C[i] > 1){
        answer = answer + (C[i] * (C[i] - 1) / 2);
      }
    }
    System.out.println(answer);
    

  }
}
