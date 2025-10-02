import java.util.*;
import java.io.*;

public class Main{
  static ArrayList<Integer>[] A;
  static boolean visited[];
  static StringBuilder dfsb = new StringBuilder();
  static StringBuilder bfsb = new StringBuilder();
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    A = new ArrayList[N+1];
    visited = new boolean[N+1];

    for(int i = 0 ; i <= N ; i++){
      A[i] = new ArrayList<>();
    }

    for(int i = 0 ; i < M ; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      A[s].add(m);
      A[m].add(s);
    }
    
    for(int i = 1 ; i <= N ; i++) Collections.sort(A[i]);
    DFS(V);

    Arrays.fill(visited,false);
    BFS(V);

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(dfsb.toString().trim()+"\n");
    bw.write(bfsb.toString().trim()+"\n");
    bw.close();
    bw.close();
  }

  static void DFS(int V){
    visited[V] = true;
    dfsb.append(V).append(" ");
    for(int i : A[V]){
      if(!visited[i]){
        DFS(i);
      }
    }
  }
  static void BFS(int V){
    Queue<Integer> queue = new LinkedList<>();
    queue.add(V);
    visited[V] = true;
    while(!queue.isEmpty()){
      int current = queue.poll();
      bfsb.append(current).append(" ");
      for(int i : A[current]){
        if(!visited[i]){
          visited[i] = true;
          queue.add(i);
        }
      }
    }
  }
}