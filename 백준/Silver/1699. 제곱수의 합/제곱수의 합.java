import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        int[] dp = new int[num + 1];

        for(int i = 1; i < num+1; i++){
            dp[i] = i; //어짜피 다음 for문에서 최소값으로 잡아주기 때문에, 1로만 구성할때의 개수로 초기화
            for(int j = 1; j*j <= i; j++){
                if(dp[i] > dp[i - (j*j)] + 1){ 
                    dp[i] = dp[i - (j*j)] + 1;
                }
            }
        }

        System.out.println(dp[num]);
    }
}