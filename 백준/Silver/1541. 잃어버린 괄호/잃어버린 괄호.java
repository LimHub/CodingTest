import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    String [] inputArr  = input.split("-");
    int sum = 0;
    for(int i = 0 ; i < inputArr.length ; i++){
      int total = 0;
      String [] calculate = inputArr[i].split("\\+");
      for(String part : calculate){
        total += Integer.parseInt(part);
      }
      if(i == 0) sum += total;
      else sum-=total;
    }
    System.out.println(sum);
  }
}