import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> results = new Stack<>();
        Integer caseNum = Integer.parseInt(input.readLine());
        Integer temp = 0;
        Integer sum = 0;

        for(int i = 0; i < caseNum; i++){ //각 경우마다 0이 아니면 스택에 넣고, 0이면 제거
            temp = Integer.parseInt(input.readLine());
            if(temp != 0) {
                results.push(temp);
                continue;
            }
            results.pop();
        }

        while(!results.isEmpty()){ //남은값들의 합을 구함
            sum += results.pop();
        }
        System.out.println(sum); //답 출력
    }
}