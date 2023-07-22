//시간복잡도 : O(N), 1부터 주어진 수까지의 개수
//아이디어 : 포인터를 두 개 두고, 두 포인터 모두 1부터 시작해서 포인터 구간의 합이 target값과 같아지는 경우의 수를 구한다.
//자료구조 : -

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(input.readLine());

        int left = 1;
        int right = 1;
        int sum = 1;
        int count = 0;

        while(left <= target){
            if(sum < target){
                right++;
                sum += right;
            }
            else if(sum > target){
                left++;
                sum = left;
                right = left;
            }
            else {
                count++;
                left++;
                sum = left;
                right = left;
            }
        }
        System.out.println(count);
    }

}

