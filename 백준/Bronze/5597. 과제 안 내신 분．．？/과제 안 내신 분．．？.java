import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TreeSet<Integer> set = IntStream.rangeClosed(1, 30).collect(TreeSet::new, TreeSet::add, TreeSet::addAll);


        for(int i = 0; i < 28; i++) {
            set.remove(Integer.parseInt(input.readLine()));
        }

        while(!set.isEmpty()) {
            sb.append(set.pollFirst()).append("\n");
        }

        System.out.print(sb);

    }
}
