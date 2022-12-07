# 백준 문제풀이

## 문제 11653번
### 문제<br>
정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.<br><br>입력 :<br>첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.<br><br>출력 :<br>N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. N이 1인 경우 아무것도 출력하지 않는다.
## 내 풀이
import java.io.BufferedReader;<br>
import java.io.IOException;<br>
import java.io.InputStreamReader;<br>

public class PracticeJava {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(input.readLine());
        int i = 2;

        while(num != 1){
            if(num % i == 0){
                num /= i;
                sb.append(i + "\n");
            }
            else i++;
        }

        System.out.println(sb);
    }
}