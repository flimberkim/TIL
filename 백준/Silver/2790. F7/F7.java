import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(input.readLine());
        ArrayList<Integer> scores = new ArrayList<>();
        int result = 1; //이전 경기까지 최고점인 사람은 무조건 우승을 할 수 있으니 1로 초기화

        for(int i = 0; i < testNum; i++){
            scores.add(Integer.parseInt(input.readLine()));
        }

        Integer[] sorted = scores.stream().toArray(Integer[]::new);
        Arrays.sort(sorted, Collections.reverseOrder()); //입력받은 선수들의 점수를 내림차순으로 정렬

        int score = sorted[0]+1; //비교할 값의 초기화. 제일 점수 높은 사람이 꼴찌한다고 가정했을때로 초기화
        for(int i = 1; i < testNum; i++){
            if(sorted[i] + testNum >= score) result++; //다음 점수 높은 사람이 1등했을때 우승할 수 있으면 result값 1증가

            score = Math.max(score, sorted[i]+i+1); //비교할 값 수정
        }
        System.out.println(result);
    }
}