import java.beans.PropertyEditorSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> samples = new Stack<>();
        int num = Integer.parseInt(input.readLine());
        int nextNum; //다음 입력받은 수
        int preNum = 0; //직전에 입력받은 수
        int putNum = 1; //스택에 들어갈 숫자

        for(int i = 0; i < num; i++){
            if(i == 0) {
                nextNum = Integer.parseInt(input.readLine());
                for (; putNum <= nextNum; ) {
                    samples.push(putNum);
                    sb.append("+").append("\n");
                    putNum++;
                }
                samples.pop();
                sb.append("-").append("\n");
                preNum = nextNum;
                continue;
            }
            nextNum = Integer.parseInt(input.readLine());
            if(nextNum > preNum){
                for(; putNum <= nextNum; ){
                    samples.push(putNum);
                    sb.append("+").append("\n");
                    putNum++;
                }
                samples.pop();
                sb.append("-").append("\n");
            }
            else{
                if(samples.peek() != nextNum) {
                    sb = new StringBuilder();
                    sb.append("NO");
                    break;
                }
                else {
                    samples.pop();
                    sb.append("-").append("\n");
                }
            }
            preNum = nextNum;
        }
        System.out.println(sb);


    }
}