//시간복잡도 : O(MlogN), M은 원래 가지고 있던 전선의 개수, logN은 이분탐색으로 적정 길이를 찾는 시간
//아이디어 : 이분탐색을 통해 적정 길이를 예측하고, 그때마다 원하는 조건에 맞는지 확인해나가며 최적의 값을 찾는다.
//자료구조 : 배열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        int caseNum = Integer.parseInt(st.nextToken());
        int targetNum = Integer.parseInt(st.nextToken());
        long min = 1;
        long max = 1;
        long mid = 0;
        int count = 0;
        int[] arr = new int[caseNum];

        for(int i = 0; i < caseNum; i++){
            arr[i] = Integer.parseInt(input.readLine());
            max = Math.max(max, arr[i]);
        }

        while(min <= max){
            mid = (min + max) / 2;
            count = 0;
            for(int i = 0; i < caseNum; i++){
                count += arr[i] / mid;
            }
            if(count >= targetNum){
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }
        System.out.println(min - 1);
    }
}

