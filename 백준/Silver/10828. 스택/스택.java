import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine());
        Stack<Integer> test =  new Stack<>();
        String word;
        int num = 0;
        ArrayList<Integer> result = new ArrayList<>();


        for(int i = 0; i < testCase; i++){
            String str = input.readLine();
            StringTokenizer st = new StringTokenizer(str);
            word = st.nextToken();
            if(st.hasMoreTokens()) num = Integer.parseInt(st.nextToken());
            if(word.equals("push")){
                test.push(num);
                continue;
            }
            try {
                if (word.equals("pop")) {
                    result.add(test.pop());
                    continue;
                }
            }
            catch(Exception e){
                result.add(-1);
                continue;
            }
            if(word.equals("size")) {
                result.add(test.size());
                continue;
            }
            if(word.equals("empty")) {
                if(test.isEmpty()) {
                    result.add(1);
                }
                else result.add(0);
                continue;
            }
            try {
                if (word.equals("top")) {
                    result.add(test.peek());
                }
            }
            catch (Exception e){
                result.add(-1);
            }
        }
        result.toArray();
        for(int j : result){
            System.out.println(j);
        }
    }
}