//시간복잡도 : O(N), N은 주어진 숫자의 개수
//아이디어 : 포인터를 두개 두고 양쪽 끝에서 시작한다. 두 포인터에 해당하는 값을 더해서 0과의 차이가 최소가
//          될때를 확인하고 두 수를 저장한다. 연산이 끝나면 합이 0에 가장 가까운 두 수가 저장된다.
//자료구조 : 배열

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        Point temp = new Point(0, 0);
        int minVal = Integer.MAX_VALUE;
        int left = 0;
        int right = n - 1;

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(left < right) {
            int sum = arr[left] + arr[right];
            if(Math.abs(sum) < minVal) {
                minVal = Math.abs(sum);
                temp.x = arr[left];
                temp.y = arr[right];
            }
            if(sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        StringBuilder sb = new StringBuilder();

        sb.append(temp.x).append(" ").append(temp.y);

        System.out.println(sb.toString());
    }

}

