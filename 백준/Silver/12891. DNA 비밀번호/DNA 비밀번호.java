import java.util.*;
import java.io.*;
public class Main {
  static char[] S;
  static char[] P;
  static int cnt = 0;
  static int A;
  static int C;
  static int G;
  static int T;

  static int check_A = 0;
  static int check_C = 0;
  static int check_G = 0;
  static int check_T = 0;
  public static void main(String args[])throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // S의 문자열 길이
    int M = Integer.parseInt(st.nextToken()); // P의 문자열 길이

    S = br.readLine().toCharArray();

    for(int i = 0 ; i < M ; i++){
      cnt(S[i]);
    }
    st = new StringTokenizer(br.readLine());
    A = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    G = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());

    check();
    for(int i  = M ; i < N ; i++){
      cnt(S[i]);
      int j = i - M;
      remove(S[j]);
      check();
    }
    System.out.println(cnt);
  }
  static void cnt(char a){
    
    if(a == 'A'){
      check_A++;
    }
    else if(a == 'C'){
      check_C++;
    }
    else if(a == 'G'){
      check_G++;
    }
    else if(a == 'T'){
      check_T++;
    }
  }
  static void check(){
    if(A <= check_A && C <= check_C && G <= check_G && T <= check_T){
      cnt++;
    }
  }

  static void remove(char a){
    if(a == 'A'){
      check_A--;
    }
    else if(a == 'C'){
      check_C--;
    }
    else if(a == 'G'){
      check_G--;
    }
    else if(a == 'T'){
      check_T--;
    }
  }
}
