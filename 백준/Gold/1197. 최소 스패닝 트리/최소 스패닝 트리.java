import java.util.*;
import java.io.*;

public class Main{
  static class Edge implements Comparable<Edge>{
    int start;
    int end;
    int weight;

    public Edge(int start,int end,int weight){
      this.start = start;
      this.end = end;
      this.weight = weight;
    }
    @Override
    public int compareTo(Edge o){
      return this.weight - o.weight;
    }
  }
  static int parent[];
  public static void main(String args[])throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    ArrayList<Edge> edgeList = new ArrayList<>();
    for(int i = 0 ; i < E ; i++){
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      edgeList.add(new Edge(start,end,weight));
    }

    Collections.sort(edgeList);

    parent = new int[ V + 1 ];
    for(int i = 1 ; i <= V ; i++){
      parent[i] = i;
    }

    int totalWeight = 0;
    int edgeCount = 0;

    for(Edge edge : edgeList){
      if(find(edge.start) != find(edge.end)){
        union(edge.start, edge.end);
        totalWeight += edge.weight;
        edgeCount++;
      }
      if(edgeCount == V - 1){
        break;
      }
    }
    System.out.println(totalWeight);
    
  }

  public static int find(int x){
    if(parent[x] == x){
      return x;
    }
    return parent[x] = find(parent[x]);
  }

  public static void union(int x , int y){
    int rootX = find(x);
    int rootY = find(y);
    if(rootX != rootY){
      parent[rootY] = rootX;
    }
  }
}