import java.util.*;

/*
아이디어 : 먼저 배열을 오름차순으로 정렬한다. 시소의 비율에 따라 각 무게별로 같거나 작은 무게 중에 쌍이 될 수 있는 것들의 개수를 체크해 나간다.
시간복잡도 : O(N), N은 weights의 길이
자료구조 : array, map
*/

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        
        Map<Double, Integer> map = new HashMap<>();
        
        for(int i : weights){
            double a = i*1.0;          // 무게가 같은 경우
            double b = (i*2.0) / 3.0;  // 무게가 2/3인 경우
            double c = (i*1.0) / 2.0;  // 무게가 2/4인 경우
            double d = (i*3.0) / 4.0;  // 무게가 3/4인 경우
                
            if(map.containsKey(a)) answer += map.get(a);
            if(map.containsKey(b)) answer += map.get(b);
            if(map.containsKey(c)) answer += map.get(c);
            if(map.containsKey(d)) answer += map.get(d);
            
            map.put((i*1.0), map.getOrDefault((i*1.0), 0) + 1);
            
        }
        
        return answer;
    }
}