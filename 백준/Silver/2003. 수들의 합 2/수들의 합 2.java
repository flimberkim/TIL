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