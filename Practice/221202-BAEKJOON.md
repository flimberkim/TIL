# 백준 문제풀이

## 문제 1978번
### 문제<br>주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.<br>입력 :<br>첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.<br>출력 :<br>주어진 수들 중 소수의 개수를 출력한다.
## 내 풀이
import java.io.BufferedReader;<br>
import java.io.IOException;<br>
import java.io.InputStreamReader;<br>
import java.util.ArrayList;<br>
import java.util.StringTokenizer;<br>

public class PracticeJava {

    public static boolean isPrime(int n){
        int count = 0;

        if(n == 1) return false;

        for(int i = 1; i <= n; i++){
            if(n % i == 0) count++;
        }
        if(count == 2){
            return true;
        }
        else return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        String temp = input.readLine();
        StringTokenizer st = new StringTokenizer(temp);
        int result = 0;

        for(int i = 0; i < num; i++){
            arr.add(i, Integer.parseInt(st.nextToken()));
        }

        for(int j = 0; j < num; j++){
            if(isPrime(arr.get(j))==true) result++;
        }
        System.out.println(result);
    }
}