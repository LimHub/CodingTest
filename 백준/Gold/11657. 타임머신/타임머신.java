import java.util.*;
import java.io.*;

public class Main {
  static class Edge{
    int from;
    int to;
    int weight;
    public Edge(int from,int to,int weight){
      this.from = from;
      this.to = to;
      this.weight = weight;
    }
  }
  private static final long INF = Long.MAX_VALUE;
  public static void main(String args[])throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    ArrayList<Edge> edges= new ArrayList<>();
    for(int i = 0 ; i < M ; i++){
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());
      edges.add(new Edge(A,B,C));
    }

    long[] dist = new long[N + 1];
    Arrays.fill(dist,INF);
    dist[1] = 0;
    
    for(int i = 1 ; i< N;i++){
      for(Edge edge: edges){
        if(dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.weight){
          dist[edge.to]  = dist[edge.from] + edge.weight;
        }
      }
    }

    boolean hasNegative = false;
    for(Edge edge : edges){
      if(dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.weight){
        hasNegative = true;
        break;
      }
    }

    StringBuilder sb = new StringBuilder();

    if(hasNegative){
      sb.append(-1).append("\n");
    }
    else{
      for(int i = 2 ; i <= N ; i++){
        if(dist[i] == INF){
          sb.append(-1).append("\n");
        }
        else{
          sb.append(dist[i]).append("\n");
        }
      }
    }
    System.out.println(sb.toString());

  }
}
