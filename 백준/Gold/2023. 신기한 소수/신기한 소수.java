import java.util.*;
import java.io.*;

public class Main{
    static final int[] TAILS = {1, 3, 7, 9};
    public static void main(String args[]) throws IOException{
  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        if (N < 1 || N > 8) {
            System.out.println("N의 범위는 1 ~ 8 입니다 확인하고 다시 입력해주세요.");
            return;
        }

        StringBuilder out = new StringBuilder();

        if (N == 1) { // 한 자리 소수
            out.append(2).append('\n')
               .append(3).append('\n')
               .append(5).append('\n')
               .append(7).append('\n');
            System.out.print(out.toString());
            return;
        }

        // BFS (반복)로 “접두사 소수”만 확장
        Deque<Integer> q = new ArrayDeque<>();
        q.add(2); q.add(3); q.add(5); q.add(7);
        int len = 1;

        while (len < N) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int cur = q.pollFirst();
                for (int d : TAILS) {
                    int nxt = cur * 10 + d;
                    if (isPrime(nxt)) q.addLast(nxt);
                }
            }
            len++;
        }

        while (!q.isEmpty()) out.append(q.pollFirst()).append('\n');
        System.out.print(out.toString());
    }

    // 정수 연산만으로 빠른 소수 판별
    static boolean isPrime(int n) {
        if (n < 2) return false;
        if ((n & 1) == 0) return n == 2;
        for (int d = 3; (long)d * d <= n; d += 2) {
            if (n % d == 0) return false;
        }
        return true;
    }
}
