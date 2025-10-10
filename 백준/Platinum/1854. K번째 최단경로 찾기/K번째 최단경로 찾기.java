import java.util.*;
import java.io.*;


public class Main{
  static class Node implements Comparable<Node>{
    int v;
    int weight;

    public  Node(int v,int weight){
      this.v = v;
      this.weight = weight;
    }

    @Override
    public int compareTo(Node other){
      return this.weight - other.weight;
    }
  }
  public static void main(String args[])throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    for(int i = 0; i <= n ; i++) graph.add(new ArrayList<Node>());

    for(int i = 0 ; i<m ; i++){
      st = new StringTokenizer(br.readLine());

      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      graph.get(start).add(new Node(end , weight));
    }

    PriorityQueue<Integer>[] kDist = new PriorityQueue[n+1];
    for(int i =1 ; i<=n;i++){
      kDist[i] = new PriorityQueue<>(Collections.reverseOrder());
    }

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(1,0));
    kDist[1].add(0);
    while(!pq.isEmpty()){
      Node current = pq.poll();
      int u = current.v;
      int currentweight = current.weight;
      for(Node neighbor : graph.get(u)){
        int v = neighbor.v;
        int weight = neighbor.weight + currentweight;

        if(kDist[v].size() < k){
          kDist[v].add(weight);
          pq.offer(new Node(v,weight));
        }

        else if(weight < kDist[v].peek()){
          kDist[v].poll();
          kDist[v].add(weight);
          pq.offer(new Node(v,weight));
        }
      }
    }
    for(int i = 1 ; i <=n ; i++){
      if(kDist[i].size() == k ){
        System.out.println(kDist[i].peek());
      }
      else{
        System.out.println("-1");
      }
    }
  }
}