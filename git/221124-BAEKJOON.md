# 백준 문제풀이

## 문제 10989번
### 문제<br>N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.<br>입력 :<br>첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.<br>출력 :<br>첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
## 내 풀이
import java.io.BufferedReader;<br>
import java.io.IOException;<br>
import java.io.InputStreamReader;<br>
import java.util.Arrays;<br>

public class PracticeJava {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[num];

        for(int i = 0; i < num; i++){
            arr[i] = (Integer.parseInt(input.readLine()));
        }

        Arrays.sort(arr);


        for(int i = 0; i < num; i++){
            sb.append(arr[i]).append('\n');
        }
        System.out.println(sb);
    }
}
<br><br><br>
#### 쉬워보여서 금방 풀 줄 알았는데, 시간 제한과 메모리 제한으로 좀 고전했다... 같은 기능을 구현하더라도 시간이 덜 걸리고 메모리를 조금 쓰는 코딩이라.. 어려운것 같다ㅠㅠ