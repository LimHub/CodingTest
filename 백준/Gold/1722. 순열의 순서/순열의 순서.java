import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[])throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    long[] fact = new long[21];
    fact[0] = 1;
    for(int i = 1 ; i <= 20 ;i++) {
      fact[i] = fact[i-1] * i ;
    }
    List<Integer> arr = new ArrayList<>();
    for(int i = 1 ; i <= N ; i++){
      arr.add(i);
    }
    int type = Integer.parseInt(st.nextToken());
    if(type == 1){
      long k = Long.parseLong(st.nextToken());
      k--;

      StringBuilder sb = new StringBuilder();
      for(int i = N - 1 ; i >= 0 ; i--){
        int index = (int)(k / fact[i]); 
        sb.append(arr.get(index)).append(" ");
        arr.remove(index);
        k %= fact[i];
      }
      System.out.println(sb.toString().trim());
    }else if(type == 2){
      long result = 0;
      for(int i = N - 1 ; i >= 0 ; i--){
        int currentNum = Integer.parseInt(st.nextToken());

        int index = arr.indexOf(currentNum);
        result += index * fact[i];
        arr.remove(index);
      }
      System.out.println(result + 1);
    }
  }
}