# 백준 문제풀이

## 문제 4344번
### 문제<br>
대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.<br><br>입력 :<br>첫째 줄에는 테스트 케이스의 개수 C가 주어진다.<br>둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.<br><br>출력 :<br>각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
## 내 풀이
import java.io.BufferedReader;<br>
import java.io.IOException;<br>
import java.io.InputStreamReader;<br>
import java.util.ArrayList;<br>
import java.util.List;<br>
import java.util.StringTokenizer;<br>

public class PracticeJava {

    public static double getRatio() throws IOException {
        double result = 0;
        BufferedReader eachCase = new BufferedReader(new InputStreamReader(System.in));
        String temp = eachCase.readLine();
        StringTokenizer st = new StringTokenizer(temp, " ");
        double num = Double.parseDouble(st.nextToken());
        double avg = 0;
        double sum = 0;
        double[] scores = new double[(int)num];
        int count = 0;

        for(int i = 0; i < num; i++){
            scores[i] = Double.parseDouble(st.nextToken());
            sum += scores[i];
        }
        avg = sum / num;

        for(int i = 0; i < num; i++){
            if(scores[i] > avg) count++;
        }

        result = ((double) count/num)*100;
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<Double> ratioForEachCase = new ArrayList<>();
        int caseNum = Integer.parseInt(input.readLine());
        double sum = 0;
        double avg = 0;
        double ratio = 0;

        for(int i = 0; i < caseNum; i++){
            ratioForEachCase.add(getRatio());
        }

        for(int i = 0; i < caseNum; i++){
            System.out.println(String.format("%.3f", ratioForEachCase.get(i)) + "%");
        }

    }
}