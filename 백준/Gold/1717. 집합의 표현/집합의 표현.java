import java.util.*;
import java.io.*;

public class Main{
  static int[] parent;
  public static void main(String args[])throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      parent = new int[N+1];
      for(int  i = 0 ; i <= N ; i++){
        parent[i] = i;
      }
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringBuilder sb = new StringBuilder();
      for(int i = 0 ; i < M ; i++){
        st = new StringTokenizer(br.readLine());
        int cal = Integer.parseInt(st.nextToken());
        int firstNum = Integer.parseInt(st.nextToken());
        int secondNum = Integer.parseInt(st.nextToken());
        if(cal == 0){
            Union(firstNum, secondNum);
        }
        if(cal == 1){
          if(isUnion(firstNum, secondNum)){
            sb.append("YES").append("\n");
          }
          else{
            sb.append("NO").append("\n");
          }
        }

      }
      bw.write(sb.toString());
      bw.flush();
      bw.close();

  }
  static int Find(int x){
    if(parent[x] == x){
      return x;
    }
    return parent[x] = Find(parent[x]);
  }

  static void Union(int x,int y){
    x = Find(x);
    y = Find(y);

    if(x == y) return;
    else parent[y] = x;
  }

  static boolean isUnion(int x,int y){
    x = Find(x);
    y = Find(y);

    return (x==y);
  }
}