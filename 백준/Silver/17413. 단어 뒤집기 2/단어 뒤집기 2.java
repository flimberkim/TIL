import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String sentence = input.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuffer buffer = new StringBuffer();

        for(int i = 0; i < sentence.length(); i++){
            if(sentence.charAt(i) == ' '){
                while(!stack.isEmpty()){
                    buffer.append(stack.pop());
                }
                buffer.append(' ');
            }
            else if(sentence.charAt(i) == '<'){
                while(!stack.isEmpty()){
                    buffer.append(stack.pop());
                }
                buffer.append(sentence.charAt(i));
                i++;
                while(sentence.charAt(i) != '>'){
                    buffer.append(sentence.charAt(i));
                    i++;
                }
                buffer.append(sentence.charAt(i));
            }
            else stack.add(sentence.charAt(i));
        }
        while(!stack.isEmpty()){
            buffer.append(stack.pop());
        }
        System.out.println(buffer);
    }
}