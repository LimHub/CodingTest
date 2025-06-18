import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer input = new StringTokenizer(br.readLine());
        int[] answerarr = new int[N];
        
        for(int k = 0; k < N; k++) {
            answerarr[k] = Integer.parseInt(input.nextToken());
        }
        Arrays.sort(answerarr);
        int cnt = 0;
        for(int k = 0; k < N; k++) {
            int i = 0;
            int j = N - 1;
            int find = answerarr[k];
            while(i < j) {
                if(i == k) {
                    i++;
                    continue;
                }
                if(j == k) {
                    j--;
                    continue;
                }
                if(answerarr[i] + answerarr[j] == find) {
                    cnt++;
                    break;
                } else if(answerarr[i] + answerarr[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
