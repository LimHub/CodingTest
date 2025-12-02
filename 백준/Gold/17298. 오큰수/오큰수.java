import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[])throws IOException{
    //N을 입력받고 배열에 담기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int[] answer = new int[N];
    Stack<Integer> stack = new Stack<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0 ; i < N ; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    for(int i = 0 ; i < N ; i++){
      while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
        answer[stack.pop()] = arr[i];
      }
      stack.push(i);
    }
    while(!stack.isEmpty()){
      answer[stack.pop()] = -1;
    }
    StringBuilder sb = new StringBuilder();
    for(int num : answer){
      sb.append(num).append(" ");
    }
    System.out.println(sb);
  }

}
