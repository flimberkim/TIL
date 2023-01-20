import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Status{
        public int value;
        public int index;

        Status(int value, int index){
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Status> deque = new LinkedList<>();
        int num = Integer.parseInt(st.nextToken());
        int sizeOfSlideWindow = Integer.parseInt(st.nextToken());
        int minValue = Integer.MAX_VALUE;
        int temp = 0;

        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < num; i++){ //차례대로 값을 deque에 삽입한다.
            temp = Integer.parseInt(st.nextToken());

            //새로 넣을 값보다 deque의 마지막값이 크다면 제거해준다.
            //무조건 제거해도 문제가 없는 이유는, 어짜피 다음 들어갈 숫자가 작다면 마지막 값은 필요가 없고,
            //살아 남는다고 하더라도 슬라이딩 윈도우의 범위에 벗어나기 때문에 제거될 것이기 때문!
            while(!deque.isEmpty() && deque.getLast().value > temp){
                deque.removeLast();
            }
            deque.addLast(new Status(temp, i));
            //슬라이딩윈도우의 범위에 벗어나는 인덱스를 가진 것은 앞에서 제거해준다.
            if(deque.getFirst().index <= i - sizeOfSlideWindow){
                deque.removeFirst();
            }
            //그러면 자연스럽게 deque의 맨 앞에 수가 최소값이 된다.
            sb.append(deque.getFirst().value).append(" ");
        }

        System.out.println(sb);
    }
}