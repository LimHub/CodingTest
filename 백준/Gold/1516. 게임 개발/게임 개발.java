import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[])throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine().trim());

    int[] time = new int[N+1];
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for(int i = 0 ; i < N + 1 ; i++) graph.add(new ArrayList<>());

    int[] indegree = new int[N+1];
    int[] result = new int[N+1];

    for(int i = 1 ; i <= N ; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
    
      time[i] = Integer.parseInt(st.nextToken());
      while(true){
        int x = Integer.parseInt(st.nextToken());
        if(x == -1) break;
        graph.get(x).add(i);
        indegree[i]++;
      }
    }
     
    Queue<Integer> q = new LinkedList<>();
    for(int i = 1 ; i <= N ; i++){ 
      if(indegree[i] == 0){
        q.add(i);
        result[i] = time[i];
      }
    }
    while(!q.isEmpty()){
      int u = q.poll();
      for(int v : graph.get(u)){
        result[v] = Math.max(result[v] , result[u] + time[v]);
        indegree[v]--;
        if(indegree[v] == 0)q.add(v);
      }
    }
    StringBuilder sb = new StringBuilder();
    for(int i = 1 ; i <= N ; i++){
      sb.append(result[i]).append('\n');
    }
    System.out.println(sb.toString());
  }
}