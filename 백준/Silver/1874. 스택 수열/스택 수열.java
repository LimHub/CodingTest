import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] answer = new int[N];
    for(int i = 0 ; i < N ; i++){
      answer[i] = sc.nextInt();
    }
    int num = 1;
    Stack<Integer> stack = new Stack<>();
    StringBuffer sb = new StringBuffer();
    boolean result = true;
    for(int i = 0 ; i < N ; i++){
        int index = answer[i];
        if(index >= num){
          while(index >= num){
            stack.push(num++);
            sb.append("+\n");
          }
          stack.pop();
          sb.append("-\n");
        }
        else{
          int n = stack.pop();
          if(n > index){
            System.out.println("NO");
            result = false;
            break;
          }
          sb.append("-\n");
        }
    }
    if(result) System.out.println(sb.toString());
  }
}
