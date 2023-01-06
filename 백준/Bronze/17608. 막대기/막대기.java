import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int num = Integer.parseInt(input.readLine());
        int first = 0;
        int temp = 0;
        int max = 0;
        int count = 0;

        for(int i = 0; i < num; i++){
            stack.push(Integer.parseInt(input.readLine()));
        }

        first = stack.pop(); //맨 처음 막대의 높이 저장하고 빼냄
        count++; //보이는 막대 개수 ++

        while(!stack.isEmpty()){
            temp = stack.pop(); //다음 막대기 높이를 임시 저장
            if(temp > first && temp > max) count++; //다음 막대기 높이가 첫번째 보다 높고, 그때까지의 최대 높이 max보다 높으면 개수 증가
            max = Math.max(max, temp);
        }

        System.out.println(count);
    }
}