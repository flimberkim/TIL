import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());

        int[] result = new int[num+1];

        result[0] = result[1] = 0; //n = 0, 1인 경우는 미리 초기화

        for(int i = 2; i <= num; i++){
            result[i] = result[i-1] + 1; //기본적으로 매번 1을 뺐을 때와 비교
            if(i % 3 == 0) result[i] = Math.min(result[i], result[i/3]+1);
            if(i % 2 == 0) result[i] = Math.min(result[i], result[i/2]+1);
        }
        System.out.println(result[num]);
    }
}