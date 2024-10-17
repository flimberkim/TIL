import java.util.*;

/*
아이디어 : 포인터를 두 개 두고 수열의 구간을 체크하면서 부분 수열의 합이 k를 만족하는 구간을 구한다. 그리고 길이가 기존보다 짧을 때만 answer 배열에 업데이트한다.
시간복잡도 : O(N), N은 sequence의 길이
자료구조 : 배열
*/


class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        
        for(int right = 0; right < sequence.length; right++){
            
            sum += sequence[right];
            
            while(sum > k && left <= right){
                sum -= sequence[left];
                left++;
            }
            
            if(sum == k){
                
                int currentLength = right - left;
                
                if(minLength > currentLength){
                    answer[0] = left;
                    answer[1] = right;
                    minLength = currentLength;
                }
                
            }
            
        }               

        return answer;
    }
}