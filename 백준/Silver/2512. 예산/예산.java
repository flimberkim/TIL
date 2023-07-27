//시간복잡도 : O(MlogN), M은 지자체의 개수, logN은 이분탐색을 통해 예산 값을 찾는 시간
//아이디어 : 처음에 요청 예산의 최저, 최대값을 기준으로 이분탐색을 진행하며 적정 예산값을 추정하고 각 케이스마다 총 예산으로 커버가 가능한지 확인한다.
//자료구조 : 배열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(input.readLine());
        int[] arr = new int[caseNum];
        StringTokenizer st = new StringTokenizer(input.readLine());
        int min = 0;
        int max = Integer.MIN_VALUE;
        int mid = 0;
        int sum = 0;

        for(int i = 0; i < caseNum; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int eternalMax = max;
        int budget = Integer.parseInt(input.readLine());

        while(min <= max){
            mid = (min + max) / 2;
            sum = 0;
            for(int i = 0; i < caseNum; i++){
                if(arr[i] > mid){
                    sum += mid;
                }else{
                    sum += arr[i];
                }
            }
            if(sum <= budget){
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }

        int answer = Math.min(eternalMax, (min - 1));
        System.out.println(answer);
    }

}

