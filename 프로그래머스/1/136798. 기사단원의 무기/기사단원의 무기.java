import java.util.*;
/*
아이디어 : 반복문으로 숫자를 돌면서 약수의 개수를 구하고, limit와 비교한 후 answer에 더해나간다.
자료구조 : -
시간복잡도 : O(N), N은 number의 크기
*/

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;        
        int numOfDiv = 0;
        
        for(int i = 1; i <= number; i++){
            numOfDiv = countDivisor(i);
            
            answer += numOfDiv > limit ? power : numOfDiv;
            
        }
        
        return answer;
    }
    
    public int countDivisor(int num){
        
        int count = 0;
        
        for(int i = 1; i*i <= num; i++){
            if(i*i == num) count += 1;
            else if(num % i == 0) count += 2;
        }
        
        return count;
        
    }
}