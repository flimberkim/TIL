import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine());
        ArrayList<String> result = new ArrayList<>();
        StringBuffer first = new StringBuffer();
        StringBuffer second = new StringBuffer();
        String sentence;
        String word;

        for(int i = 0; i < testCase; i++){
            sentence = input.readLine();
            StringTokenizer st = new StringTokenizer(sentence);
            while(st.hasMoreTokens()){
                first.append(st.nextToken());
                word = first.reverse().toString();
                first = new StringBuffer();
                second.append(word);
                second.append(' ');
            }
            second.append("\n");
            first = new StringBuffer();
            result.add(second.toString());
            second = new StringBuffer();
        }

        for(String s : result){
            System.out.print(s);
        }

    }
}