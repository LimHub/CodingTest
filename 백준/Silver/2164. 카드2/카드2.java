import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < N ; i++){
          queue.add(i+1);
        }
        while(!queue.isEmpty()){
          int first = queue.remove();
          if(queue.isEmpty()){
            System.out.println(first);
            break;
          }
          int second = queue.remove();
          queue.add(second);
        }
      
    }
}
