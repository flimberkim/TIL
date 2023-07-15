//시간복잡도 : O(N), N은 주어진 숫자의 개수
//아이디어 : left, right 포인터 두 개를 0에 둔다. right 포인터를 움직여가면서
//          범위에 해당하는 숫자의 합을 target값과 비교한다.
//          target값이면 count 해주고 right++, target값보다 작으면 right++, target값보다 크면 left++ 해준다.
//자료구조 : 배열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int targetNum = Integer.parseInt(st.nextToken());
        int count = 0;
        st = new StringTokenizer(input.readLine());
        int[] arr = new int[N];
        int left = 0;
        int right = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = arr[0];
        while(right < N){
            if(sum > targetNum) {
                sum -= arr[left];
                left++;
            }
            else if (sum < targetNum){
                right++;
                if (right < N) {
                    sum += arr[right];
                } else {
                    break;

                }
            }
            else{
                count++;
                right++;
                if(right < N){
                    sum += arr[right];
                } else {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
