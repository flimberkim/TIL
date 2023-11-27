import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int continuousTime = 0;
        int time = 0;
        int limitTime = attacks[attacks.length-1][0];
        int currentHealth = health;
        int attackIndex = 0;

        while(time <= limitTime) {

            if(continuousTime == bandage[0]) {
                currentHealth += bandage[2];
                continuousTime = 0;
                if(currentHealth > health) {
                    currentHealth = health;
                }
            }

            if(attacks[attackIndex][0] == time) {
                currentHealth -= attacks[attackIndex][1];
                attackIndex++;
                continuousTime = 0;

                if(currentHealth <= 0) {
                    return -1;
                }
                else{
                    time++;
                }
            }
            else {
                time++;
                continuousTime++;
                currentHealth += bandage[1];
                if(currentHealth > health) {
                    currentHealth = health;
                }
            }
        }

        return currentHealth;
    }
}