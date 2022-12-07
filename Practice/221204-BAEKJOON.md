# 백준 문제풀이

## 문제 2292번
### 문제<br>
위의 그림과 같이 육각형으로 이루어진 벌집이 있다. 그림에서 보는 바와 같이 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다. 숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오. 예를 들면, 13까지는 3개, 58까지는 5개를 지난다.<br><br>입력 :<br>첫째 줄에 N(1 ≤ N ≤ 1,000,000,000)이 주어진다.<br><br>출력 :<br>입력으로 주어진 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나는지 출력한다.
## 내 풀이
import java.io.BufferedReader;<br>
import java.io.IOException;<br>
import java.io.InputStreamReader;<br>

public class PracticeJava {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        long num = Integer.parseInt(input.readLine());
        long temp = 1;
        long result = 0;

        //1을 첫번째 껍질이라 하고, 그 벌집을 둘러싸고 있는 둘레의 모든 벌집을 '껍질'이라 하자
        //n번째 껍질 구하기
        //n번째 껍질에 속하면, 그 벌집까지 가는데 n번 걸린다는 뜻
        //계차수열의 일반항을 구해서 계산함

        while(true){
            if(num == 1){
                result = 1;
                System.out.println(result);
                return;
            }
            if(num >= ((3*temp*temp) - (3*temp) + 2) && num < ((3*(temp+1)*(temp+1)) - (3*(temp+1)) + 2)){
                result = temp + 1;
                System.out.println(result);
                return;
            }
            else temp++;
        }
    }
}