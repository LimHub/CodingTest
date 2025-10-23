import java.io.*;
import java.util.*;

public class Main {
  static List<Integer>[] tree;
  static int[] depth;
  static int[][] parent;
  static int Max_K = 17;
  static int N;
  public static void main(String args[])throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    tree = new ArrayList[N+1];
    depth = new int[N+1];
    parent = new int[Max_K + 1][N+1];
    for(int i  = 1 ; i <= N ; i++){
      tree[i] = new ArrayList<>();
    }
    for(int i = 0 ; i < N - 1 ; i++){
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      tree[u].add(v);
      tree[v].add(u);
    }
    DFS(1,0,0);
    setParent();

    int M = Integer.parseInt(br.readLine());
      StringBuilder sb = new StringBuilder();

      for (int i = 0; i < M; i++) {
          st = new StringTokenizer(br.readLine());
          int u = Integer.parseInt(st.nextToken());
          int v = Integer.parseInt(st.nextToken());
          sb.append(LCA(u, v)).append("\n");
      }

      bw.write(sb.toString());
      bw.flush();
      bw.close();
      br.close();

  }
  static void DFS(int current,int d,int p){
      depth[current] = d;
      parent[0][current] = p;
      for(int next : tree[current]){
        if(next != p){
          DFS(next,d+1,current);
        }
      }
  }
  private static void setParent(){
    for(int k = 1 ; k<= Max_K ; k++){
      for(int i = 1 ; i <= N ; i++){
        parent[k][i] = parent[k - 1][parent[k-1][i]];
      }
    }
  }
  static int LCA(int a , int b){
    if(depth[a] > depth[b]){
      int temp = a;
      a = b;
      b = temp;
    }
    for(int k = Max_K ; k>=0 ; k --){
      if(depth[b] - (1 << k) >= depth[a]){
        b = parent[k][b];      
      }
    }
    if(a == b){
      return a;
    }
    for(int k = Max_K ; k>=0 ; k --){
      if(parent[k][a] != parent[k][b]){
        a = parent[k][a]; 
        b = parent[k][b];     
      }
    }
    return parent[0][a];
  }
}
