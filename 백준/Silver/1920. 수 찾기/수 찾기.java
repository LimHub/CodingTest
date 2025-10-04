import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[])throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
      int N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int [] arr = new int[N];
      for(int i =0 ; i< N;i++){
        if(st.hasMoreTokens()) arr[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(arr);

      int M = Integer.parseInt(br.readLine());
      StringBuilder sb = new StringBuilder();
     
      st = new StringTokenizer(br.readLine());
      for(int i =0 ; i< M;i++){
        if(st.hasMoreTokens()){ 
          int newInput = Integer.parseInt(st.nextToken());
          int idx = Arrays.binarySearch(arr,newInput);
          if(idx >= 0 ) sb.append("1\n");
          else sb.append("0\n");
        }
      }
      System.out.println(sb.toString());
      
  }
}