//시간복잡도 : O(NlogN), N은 후보의 수
//아이디어 : 다솜이를 제외한 사람들의 득표수를 내림차순 정렬한 PriorityQue에 넣는다. peek 값이 다솜이보다 크다면
//         큐에서 빼서 1을 뺀 후 다시 큐에 넣어주고, 다솜이의 값은 +1 해준다. 이 과정을 반복하면서 다솜이의 득표수가
//         가장 많을때 반복문 빠져나오고 횟수를 출력해준다.
//자료구조 : 힙

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());
        int target = Integer.parseInt(input.readLine());
        int count = 0;

        if(num == 1) {
            System.out.println(0);
            return;
        }

        for(int i = 1; i < num; i++) {
            que.add(Integer.parseInt(input.readLine()));
        }

        while(true){
            if(que.peek() < target){
                break;
            }

            if(que.peek() >= target){
                int temp = que.poll();
                que.add(temp - 1);
                target++;
                count++;
            }
        }
        System.out.println(count);
    }
}

