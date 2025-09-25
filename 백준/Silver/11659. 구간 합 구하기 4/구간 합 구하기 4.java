import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer firstLine = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(firstLine.nextToken());
    int M = Integer.parseInt(firstLine.nextToken());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    long[] sumArr = new long[N];
    sumArr[0] = arr[0];
    for (int j = 1; j < N; j++) {
      sumArr[j] = sumArr[j - 1] + arr[j];
    }

    StringBuilder output = new StringBuilder();
    for (int q = 0; q < M; q++) {
      StringTokenizer qs = new StringTokenizer(br.readLine());
      int firstNum = Integer.parseInt(qs.nextToken());  
      int secondNum = Integer.parseInt(qs.nextToken()); 

      if (firstNum == 1) {
        output.append(sumArr[secondNum - 1]).append('\n');
      } else {
        output.append(sumArr[secondNum - 1] - sumArr[firstNum - 2]).append('\n');
      }
    }

    System.out.print(output.toString());
    br.close();
  }
}
