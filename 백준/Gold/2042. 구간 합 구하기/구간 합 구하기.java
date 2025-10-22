import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[])throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    long[] arr = new long[N];
 

    for(int i = 0 ; i < N ; i++){
      arr[i] = Long.parseLong(br.readLine());
    }
    long[] sumArr = new long [N];
    sumArr[0] = arr[0];
    for(int i = 1 ; i < N ; i++){
      sumArr[i] = sumArr[i-1] + arr [i];
    }
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    long answer;
    long gap;
    for(int i = 0 ; i < M + K ; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      long c = Long.parseLong(st.nextToken());
      if(a == 1 ){
        gap = c - arr[b - 1];
        arr[b-1] =c;
        for(int j = b - 1 ; j < N ; j++){
          sumArr[j] += gap;
        }
      }
      else if(a == 2){
        if(b == 1){
          answer = sumArr[(int)c-1];
          sb.append(answer).append("\n");
      }else{
          answer = sumArr[(int)c-1] - sumArr[b-2];
          sb.append(answer).append("\n");
      }
      }
    }
    bw.write(sb.toString());
    bw.close();

  }
}
