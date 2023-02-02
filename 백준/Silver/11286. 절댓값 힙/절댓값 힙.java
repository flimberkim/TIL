import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> answer = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //먼저 절대값 기준으로 정렬. 절대값 작은 것이 앞으로 오도록
                if(Math.abs(o1) > Math.abs(o2)){
                    return Math.abs(o1) - Math.abs(o2);
                }

                //절대값이 같다면 실제 값이 작은 값을 앞으로 보낸다.(오름차순)
                else if(Math.abs(o1) == Math.abs(o2)){
                    return o1 - o2;
                }
                //기본적인 정렬은 오름차순
                else return -1;
            }
        });

        for(int i = 0; i < caseNum; i++){
            int temp = Integer.parseInt(input.readLine());

            if(temp != 0){ //입력값이 0이 아니면 추가해주고
                answer.add(temp);
            }
            else if(temp == 0){ //0이라면 큐가 비어있을때와 아닐 때로 나누어 출력
                if(answer.isEmpty()) sb.append(0).append("\n");
                else sb.append(answer.poll()).append("\n");
            }

        }
        System.out.println(sb);

    }
}