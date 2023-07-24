//시간복잡도 : O(N), N은 주어진 숫자의 개수
//아이디어 : 슬라이딩 윈도우를 사용해 조건을 확인해 나가면서 합의 최대값을 업데이트한다.
//자료구조 : 배열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int len = Integer.parseInt(st.nextToken());
        int windowLen = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = windowLen - 1;

        st = new StringTokenizer(input.readLine());
        int[] arr = new int[len];

        for(int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i = left; i <= right; i++){
            sum += arr[i];
        }

        while(true) {
            max = Math.max(max, sum);
            sum -= arr[left++];
            if(right + 1 == len) break;
            sum += arr[++right];
        }

        System.out.println(max);

    }
}

