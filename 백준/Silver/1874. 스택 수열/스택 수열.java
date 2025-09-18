import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]){
    Scanner sc  = new Scanner(System.in);
    int N = sc.nextInt();
    if(N< 1 || N > 100000){
      System.out.println("주어진 범위를 다시 확인해주세요.");
      return;
    }
    int[] answer =  new int[N];
    for(int i = 0; i < N ; i++){
      answer[i] = sc.nextInt();
    }
    Stack<Integer> stack = new Stack<>();
    StringBuffer bf = new StringBuffer();
    int num = 1;
    boolean result = true;
    for(int i =0 ; i < N ; i++){
      int su = answer[i];
      if(su >= num){
        while(su>=num){
          stack.push(num++);
          bf.append("+\n");
        }
        stack.pop();
        bf.append("-\n");
      }
      else{
        int n = stack.pop();
        if(n > su){
          System.out.println("NO");
          result = false;
          break;
        }
        bf.append("-\n");
      }
      
    }
    if(result) System.out.println(bf.toString());
  }
}
