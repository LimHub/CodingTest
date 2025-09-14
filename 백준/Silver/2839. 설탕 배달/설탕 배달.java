import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      String s = bf.readLine();
      StringTokenizer st = new StringTokenizer(s);
      int a = Integer.parseInt(st.nextToken());
      if(a < 3 ){
        System.out.println("입력하신 숫자가 3보다 작습니다.");
        return;
      }
      int cntFive = 0;
        int cntThree = 0;

        int maxFive = a / 5;
        int remByFive = a % 5;

        switch (remByFive) {
            case 0: // 바로 나눠떨어짐
                cntFive = maxFive;
                break;
            case 1: // 5 하나 빼면 +5 => (1+5)=6 → 3으로 나눠짐
                cntFive = maxFive - 1;
                break;
            case 2: // 5 두 개 빼면 +10 => (2+10)=12 → 3으로 나눠짐
                cntFive = maxFive - 2;
                break;
            case 3: // 3이 남으니 그대로
                cntFive = maxFive;
                break;
            case 4: // 5 하나 빼면 +5 => (4+5)=9 → 3으로 나눠짐
                cntFive = maxFive - 1;
                break;
        }

        int rest = a - 5 * cntFive;

        // 불가능한 경우(음수 5개, 음수 나머지, 3으로 안 나눠짐) 처리
        if (cntFive < 0 || rest < 0 || rest % 3 != 0) {
            System.out.println(-1);
            return;
        }

        cntThree = rest / 3;
        System.out.println(cntFive + cntThree);
}
}
