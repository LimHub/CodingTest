import java.util.*;
import java.io.*;

public class Main{
    static class Node{
      int index;
      int value;
      Node(int index, int value){
        this.index = index;
        this.value = value;
      }
    }
    public static void main (String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());

   

    Deque<Node> mydeque = new LinkedList<>();
    for(int i =0; i < N ; i++){
      int now = Integer.parseInt(st.nextToken());
      while(!mydeque.isEmpty() && mydeque.getLast().value > now){
          mydeque.removeLast();
      }
      mydeque.addLast(new Node(i,now));
      
      if(i- mydeque.getFirst().index >= L){
          mydeque.removeFirst();
      }

     // System.out.print(mydeque.getFirst().value + " "); 시스템아웃이 시간복잡도가 높아 라이터로 구현

      bw.write(mydeque.getFirst().value+ " ");
    }
    bw.flush();
    bw.close();
    br.close();
    
  }
}