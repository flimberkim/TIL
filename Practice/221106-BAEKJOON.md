# 백준 문제풀이

## 문제 11720번
### N개의 숫자가 공백없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
- 입력 : 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.

## 내 풀이
import java.io.BufferedReader;<br>
import java.io.IOException;<br>
import java.io.InputStreamReader;<br>
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        int sum = 0;
        String temp;

        temp = bf.readLine();

        for(int i = 0; i < temp.length(); i++){
            sum += Integer.parseInt(String.valueOf(temp.charAt(i)));
        }
        System.out.println(sum);

    }
}
