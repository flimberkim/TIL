import java.util.*;

/*
아이디어 : 제1사분면에서 조건에 해당하는 점의 개수를 구하고 마지막에 4를 곱해서 답을 구한다.
시간복잡도 : O(N), N은 1사분면에 존재하는 두 원 사이의 정수쌍의 개수
자료구조 : -
*/

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long count = 0;
        
        double r1Pow = Math.pow(r1,2);
        double r2Pow = Math.pow(r2,2);
        
        for(int i = 1; i <= r2; i++){
            double xPow = Math.pow(i,2);
            
            //y1이 작은원
            double y1;
            double y2 = Math.sqrt(r2Pow - xPow);
            
            if(i >= r1){
                y1 = 0;
            }
            else{
                y1 = Math.sqrt(r1Pow - xPow);
                if(y1 > Math.floor(y1)){
                    y1 = Math.ceil(y1);
                }
            }
            
            if(y2 > Math.floor(y2)){
                y2 = Math.floor(y2);
            }
            count += y2 - y1 + 1;
        }
        
        answer = (long) count*4;
        
        return answer;
    }
}