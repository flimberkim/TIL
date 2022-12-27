import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        int[] candidates = new int[num];
        int[] dp = new int[num];
        PriorityQueue<Integer> results = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;


        st = new StringTokenizer(input.readLine());

        for(int i = 0; i < num; i++){ //입력받은 숫자를 배열로 만든것
            candidates[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < num; i++){ //dp 배열에 각 인덱스까지의 감소하는 최장 배열의 길이를 넣는다.
            dp[i] = 1; //숫자 하나만 있으면 길이가 1이니까 매 인덱스는 1로 초기화한 후 시작
            for(int j = 0; j < i; j++){
                if(candidates[j] > candidates[i]){ //i번째 수와 그 전까지의 모든 수를 감소하는지 비교
                    dp[i] = Math.max(dp[i], dp[j] + 1); //만약 감소한다면 그때그때의 최장길이 +1 을 넣는다.
                }
            }
            results.add(dp[i]); //i번째의 결과가 나오면 priorityqueue에 저장
        }
        System.out.println(results.poll());
    }
}