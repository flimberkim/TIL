# 백준 문제풀이

## 문제 10872번
### 문제<br>0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.<br>입력 :<br>첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.<br>출력 :<br>첫째 줄에 N!을 출력한다.
## 내 풀이
import java.io.BufferedReader;<br>
import java.io.IOException;<br>
import java.io.InputStreamReader;<br>

public class PracticeJava {

    public static int factorial(int n){
        if(n == 0) return 1;

        return n*factorial(n-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        int result = 0;

        result = factorial(num);
        System.out.println(result);
    }
}