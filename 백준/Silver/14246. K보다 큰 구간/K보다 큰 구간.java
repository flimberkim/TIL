//시간복잡도 : O(N^2), N은 주어진 숫자의 개수
//아이디어 : 모든 쌍을 구하기 위해 완전탐색의 방식으로 진행하다가 조건을 만족 하는 순간 반복문을 빠져나오고 개수를 더해준다.
//자료구조 : 배열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int arrLen = Integer.parseInt(input.readLine());
        int[] arr = new int[arrLen];
        StringTokenizer st = new StringTokenizer(input.readLine());

        for(int i = 0; i < arrLen; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(input.readLine());
        long count = 0L;

        for(int i = 0; i < arrLen; i++) {
            long sum = 0L;
            int j = i;
            while(j < arrLen){
                sum += arr[j];
                if(sum > target){
                    count += arrLen - j;
                    break;
                }
                else j++;                
            }
        }
        System.out.println(count);
    }

}

