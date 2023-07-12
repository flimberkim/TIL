import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//시간복잡도 : O(N), N은 주어진 각 문장의 길이
//아이디어 : '(' 또는'[' 를 만날때만 스택에 저장해준다. 
//          그리고 해당 괄호의 쌍을 만날때마다 직전 문자가 맞게 있는지 확인하고 맞으면 빼준다.
//          중간에 잘못되어서 처리된 경우가 아니라면 반복문 나왔을 때 스택이 비어있는지 확인한다.
//자료구조 : 배열, 스택

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
