import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
            Arrays.sort(times);
            long min = 0; //최대값의 절반을 찾아나갈 것이므로 최소값은 처음에 0으로 초기화
            long max = (long) n * times[times.length - 1]; //제일 오래걸릴 경우를 가정한 시간의 최대값
            
            while(min <= max){
                long mid = (min + max) / 2; //중간값을 찾음
                long sum = 0;
                
                for(int i = 0; i < times.length; i++){
                    sum += (mid / times[i]); //중간값을 기준으로 각 심사위원이 그 시간동안 처리한 사람의 총 수를 구함
                }
                
                if(sum < n){ //만약 입국심사를 기다리는 인원보다 적게 처리했다면, 중간값이 커져야 함 -> mid값 기준으로 min값 증가
                    min = mid + 1;
                }
                else{ //아니라면 중간값이 작아져야 함 -> mid값 기준으로 max값을 줄임
                    max = mid - 1;
                    answer = mid;
                }
            }
            
            return answer;
    }
}
