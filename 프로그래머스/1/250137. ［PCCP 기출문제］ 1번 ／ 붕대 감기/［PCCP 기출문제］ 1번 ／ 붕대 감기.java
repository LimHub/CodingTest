class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int recTime = bandage[0];
        int recPerSecond = bandage[1];
        int bonusRec = bandage[2];
        int lastNum = attacks[attacks.length-1][0];
        answer = health;
        int cntHealth = 0;
        int cntAttacks = 0;
        for(int i = 1 ; i <= lastNum ; i++){
           if(cntAttacks < attacks.length && attacks[cntAttacks][0] == i ){
               answer-=attacks[cntAttacks][1];
               cntAttacks++;
               cntHealth = 0;
               
               if(answer <= 0){
                   return -1;
               }
           }
           else{
               answer += recPerSecond;
               cntHealth++;
               if(recTime == cntHealth){
                   answer += bonusRec;
                   cntHealth = 0;
               }
               if(answer > health){
                   answer = health;
               }
           }
        }
        return answer;
    }
        
}