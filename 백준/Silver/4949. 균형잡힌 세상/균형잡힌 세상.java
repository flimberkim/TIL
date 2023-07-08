import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String temp = null;
        boolean check = true;
        Stack<Character> stack = new Stack<>();

        while(true){
            temp = input.readLine();
            if(temp.equals(".")) break;

            stack = new Stack<>();
            check = true;

            for(int i = 0; i < temp.length(); i++){
                if(temp.charAt(i) == '(' || temp.charAt(i) == '[') stack.add(temp.charAt(i));
                else if(temp.charAt(i) == ')'){
                   if(stack.isEmpty() || stack.peek() == '['){
                        sb.append("no").append("\n");
                        check = false;
                        break;
                   }
                   else if(stack.peek() == '(') {
                       stack.pop();
                   }
                }
                else if(temp.charAt(i) == ']'){
                    if(stack.isEmpty() || stack.peek() == '('){
                        sb.append("no").append("\n");
                        check = false;
                        break;
                    }
                    else if(stack.peek() == '[') {
                        stack.pop();
                    }
                }
            }
            if(check){
                if(stack.isEmpty()) sb.append("yes").append("\n");
                else sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }
}





