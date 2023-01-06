import java.beans.PropertyEditorSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> cards = new LinkedList<>();
        int num = Integer.parseInt(input.readLine());
        int temp = 0;

        for(int i = 1; i <= num; i++){
            cards.add(i);
        }

        while(cards.size() != 1){
            cards.removeFirst();
            temp = cards.pollFirst();
            cards.addLast(temp);
        }

        System.out.println(cards.pollLast());
    }
}