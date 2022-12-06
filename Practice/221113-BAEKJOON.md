# 백준 문제풀이

## 문제 1065번
### 문제<br>
어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. <br><br>입력 : <br>첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.<br><br>출력 : <br>첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
## 내 풀이
import java.io.BufferedReader;<br>
import java.io.IOException;<br>
import java.io.InputStreamReader;<br>

public class PracticeJava {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(input.readLine());
        System.out.println(functionsf(i));
    }
    public static int functionsf(int a){

        int p = 0;
        int q = 0;
        int r = 0;
        int count = 0;
        int count11 = 0;
        String temp;

        if(a < 100){
            count = a;
            return count;
        }
        else{
            count11 = 99;
            for(int i = 100; i <= a; i++){
                p = i/100; //i의 백의 자리수
                q = (i - (p*100)) / 10; //i의 십의 자리수
                r = (i - (p*100)) - (q*10); //i의 일의 자리수

                if((p-q) == (q-r)) count11++;
            }
            return count11;
        }
    }
}