# 백준 문제풀이

## 문제 2609번
### 문제<br>두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.<br>입력 :<br>첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.<br>출력 :<br>첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
## 내 풀이
import java.io.BufferedReader;<br>
import java.io.IOException;<br>
import java.io.InputStreamReader;<br>
import java.util.StringTokenizer;<br>

public class PracticeJava {

    static int gcd(int num1, int num2){
        while(num2 != 0){
            int r = num1 % num2; //나머지를 구함
            //gcd(num1 , num2) == gcd(num2, r) 임을 이용

            num1 = num2;
            num2 = r;
        }
        return num1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int gcd1 = 0;
        int lcm = 0;

        gcd1 = gcd(num1, num2);

        lcm = num1 * num2 / gcd1;

        System.out.println(gcd1);
        System.out.println(lcm);
    }
}