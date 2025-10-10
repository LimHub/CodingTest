import java.util.*;
import java.io.*;

public class Main {
  static class Node implements Comparable<Node>{
    int v;
    int weigh;

    public Node(int v,int weigh){
      this.v = v;
      this.weigh = weigh;
    }

    @Override
    public int compareTo(Node other){
      return this.weigh-other.weigh;
    }
  }
 

  private static final int INF = 200_001; 
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    int startVertex = Integer.parseInt(br.readLine().trim());
    ArrayList<ArrayList<Node>> dGraph = new ArrayList<>();
    
    for(int i = 0 ; i <= V ;i++)dGraph.add(new ArrayList<>());

    StringBuilder sb =  new StringBuilder();
    for(int i = 1 ; i <= E ; i++){
      st = new StringTokenizer(br.readLine());

      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int weigh = Integer.parseInt(st.nextToken());

      dGraph.get(start).add(new Node(end,weigh));
    }

    int [] result = new int[V+1];
    Arrays.fill(result, INF );

    PriorityQueue<Node> pq = new PriorityQueue<>();

    result[startVertex] = 0;
    pq.add(new Node(startVertex, 0 ));
    while(!pq.isEmpty()){
      Node now = pq.poll();
      int u = now.v;
      int weigh = now.weigh;

      if(result[u] < weigh) continue;

      for(Node neighbor : dGraph.get(u)){
        int v = neighbor.v;
        int w = neighbor.weigh;
        
        if(result[u] + w < result[v]){
          result[v] = result[u] + w;
          pq.add(new Node(v, result[v]));
        }
      }
    }
    for(int i = 1 ; i <=V ; i++){
      if(result[i] == INF){
        sb.append("INF").append("\n");
      }else{
        sb.append(result[i]).append("\n");
      }
    }
    System.out.println(sb.toString());


  }
}
