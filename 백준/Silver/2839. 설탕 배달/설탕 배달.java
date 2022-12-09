import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int getMinimum(int weight){ //봉지의 최소 개수를 구하는 메소드 구현
        int result = 0;
        int a = 0; //5kg 봉지의 개수
        PriorityQueue<Integer> candidates = new PriorityQueue<>();
        int maxA = weight / 5;
        int maxB = weight / 3;

        //주어진 무게를 5kg, 3kg 봉지로 나눌 수 있는 경우를 모두 구해서 우선순위 큐에 넣음
        for (int j = 0; j <= maxB; j++) { //j는 3kg 봉지의 개수
            for (int i = 0; i <= maxA; i++) { //i == a 는 5kg 봉지의 개수
                if (weight == 5 * i + 3 * j) candidates.add(i + j);
                a = i;
            }
            if (weight == 5 * a + 3 * j) candidates.add(a + j);
        }
        if(candidates.isEmpty()) result = -1; //만약 큐에 저장된 것이 없다면, 해당 봉지로 나눌 수 없으므로 -1 반환
        else result = candidates.poll(); //큐에 저장된 것이 있다면, 최소 봉지의 개수를 반환

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int weight = Integer.parseInt(input.readLine());

        System.out.println(getMinimum(weight));

    }
}