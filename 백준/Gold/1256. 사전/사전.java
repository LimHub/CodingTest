import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[])throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    long K = Long.parseLong(st.nextToken());
    
    long[][] dp = new long[201][201];
    long K_MAX = 1000000001l;
    for(int i = 0 ; i <= N + M ; i++){
      dp[i][0] = 1;
      dp[i][i] = 1;
    }

    for(int i = 2 ; i <= N + M ; i++){
      for(int j = 1 ; j < i ; j++){
        dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
        if(dp[i][j] > K_MAX){
          dp[i][j] = K_MAX;
        }
      }
    }
    if(dp[N+M][M] < K){
      System.out.println(-1);
      return;
    }

    StringBuilder sb = new StringBuilder();
    int n = N;
    int m = M;
    long k = K;
    for(int i = 0 ; i < N + M ; i++){
      if(n==0){
        sb.append('z');
        m--;
        continue;
      }
      if(m == 0){
        sb.append('a');
        n--;
        continue;
      }
      long cnt = dp[n-1+m][m];

      if(k <= cnt){
        sb.append('a');
        n--;
      }
      else{
        k -=cnt;
        sb.append('z');
        m--;
      }
    }
    System.out.println(sb.toString()); 
  }
}
