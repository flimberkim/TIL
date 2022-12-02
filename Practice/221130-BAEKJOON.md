# 백준 문제풀이

## 문제 2748번
### 문제<br>피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.<br>이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.<br>n=17일때 까지 피보나치 수를 써보면 다음과 같다.<br>0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597<br>n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.<br>입력 :<br>첫째 줄에 n이 주어진다. n은 90보다 작거나 같은 자연수이다.<br>출력 :<br>첫째 줄에 n번째 피보나치 수를 출력한다.
## 내 풀이
import java.io.BufferedReader;<br>
import java.io.IOException;<br>
import java.io.InputStreamReader;<br>

public class PracticeJava {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());

        long sum = 1;
        long f1 = 0;
        long f2 = 1;

        for(int i = 1; i < num; i++){
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        System.out.println(sum);
    }
}
<br><br><br>
#### 코드를 맞게 짠 것 같은데 계속 틀렸다고 나와서... 쉬운 문제인데 거의 한 시간을 썼다ㅠㅠ 보니까 숫자의 크기 때문에 변수를 int형이 아닌 long형으로 선언해야 했던ㅠㅠㅠㅠ