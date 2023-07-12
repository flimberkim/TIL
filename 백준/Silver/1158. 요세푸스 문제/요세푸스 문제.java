import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//시간복잡도 : O(N), N은 주어진 사람의 인원수
//아이디어 : 원순열이므로 덱을 활용한다. 주어진 간격만큼 덱을 이동하고 추출하는 과정을 반복한다.
//자료구조 : Deque(LinkedList)

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int size = Integer.parseInt(st.nextToken());
        int interval = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= size; i++) {
            deque.add(i);
        }

        while (!deque.isEmpty()) {
            for (int i = 1; i < interval; i++) {
                deque = moveLeft(deque);
            }
            sb.append(deque.pollFirst()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }

    public static LinkedList<Integer> moveLeft(LinkedList<Integer> deque){
        int temp = deque.pollFirst();
        deque.addLast(temp);
        return deque;
    }
}
