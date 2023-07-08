import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//시간복잡도 : O(N), N은 처음 주어진 배열의 크기
//아이디어 : 찾으려는 값의 위치가 중간보다 큰지 아닌지 판단하고, 그 여부에 따라 문제의 2, 3번 연산을 진행한다.
//          2,3번 연산을 진행할때마다 횟수를 세어 주고 새로운 LinkedList로 같은 작업을 반복한다.
//자료구조 : LinkedList

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int size = Integer.parseInt(st.nextToken());
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= size; i++) {
            deque.add(i);
        }

        int count = 0;

        st = new StringTokenizer(input.readLine());
        while (st.hasMoreTokens()) {
            int target = Integer.parseInt(st.nextToken());
            int length = deque.size();
            int halfIndex = length % 2 == 0 ? (length / 2) - 1 : length / 2;
            int targetIndex = deque.indexOf(target);

            if (targetIndex <= halfIndex) {
                for (int i = 0; i < targetIndex; i++) {
                    deque = moveLeft(deque);
                    count += 1;
                }
                if(deque.peekFirst() == target){
                    deque.pollFirst();
                }
            }
            else{
                for(int i = 0; i < length - targetIndex; i++){
                    deque = moveRight(deque);
                    count += 1;
                }
                if(deque.peekFirst() == target){
                    deque.pollFirst();
                }
            }
        }
        System.out.println(count);
    }

    public static LinkedList<Integer> moveLeft(LinkedList<Integer> deque){
        int temp = deque.pollFirst();
        deque.addLast(temp);
        return deque;
    }

    public static LinkedList<Integer> moveRight(LinkedList<Integer> deque){
        int temp = deque.pollLast();
        deque.addFirst(temp);
        return deque;
    }
}





