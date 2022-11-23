# 백준 문제풀이

## 문제 2775번
### 문제<br>평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.<br>이 아파트에 거주를 하려면 조건이 있는데, “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.<br>아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라. 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.<br>입력 :<br>첫 번째 줄에 Test case의 수 T가 주어진다. 그리고 각각의 케이스마다 입력으로 첫 번째 줄에 정수 k, 두 번째 줄에 정수 n이 주어진다.<br>출력 :<br>각각의 Test case에 대해서 해당 집에 거주민 수를 출력하라.<br>제한 :<br>1 ≤ k, n ≤ 14
## 내 풀이
import java.io.BufferedReader;<br>
import java.io.IOException;<br>
import java.io.InputStreamReader;<br>
import java.util.ArrayList;<br>
import java.util.StringTokenizer;<br>

public class PracticeJava {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int num = Integer.parseInt(st.nextToken());
        int floor = 0;
        int houseNum = 0;
        ArrayList<Integer> result = new ArrayList<>();
        int[][] entire = new int[15][15];
        for(int i = 0; i < 15; i++){
            entire[i][1] = 1;
            entire[0][i] = i;
        }

        for(int i = 1; i < 15; i++){
            for(int j = 2; j < 15; j++){
                entire[i][j] = entire[i][j-1]+entire[i-1][j];
            }
        }

        for(int i = 0; i < num; i++){
            floor = Integer.parseInt(input.readLine());
            houseNum = Integer.parseInt(input.readLine());
            result.add(entire[floor][houseNum]);
        }

        for(int i : result){
            System.out.println(i);
        }

    }
}
<br><br><br>
#### 이 문제를 풀 때, 나는 당연히 일반항을 구해서 문제를 풀어야 하는 줄 알고 엄청 고민을 했는데... 설마 배열에 숫자를 다 구해놓고 찾아가는 것만 구하는 방식으로 문제를 해결할 줄이야.. 나의 사고방식이 문제인건가 혼란스럽다 ㅎㅎ..ㅎㅎ