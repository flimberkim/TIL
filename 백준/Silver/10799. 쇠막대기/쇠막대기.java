import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
        1. 아이디어 : 문자에 따라 '('면 스택에 쌓고 ')'를 만나면 스택에서 하나씩 꺼낸다. 꺼낼때 바로 직전 문자를 확인하고 경우에 따라 result에 개수를 추가해준다.
        2. 시간복잡도 : O(N), N은 입력받은 문자열의 길이
        3. 자료구조 : stack
*/

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    String s = input.readLine();
    Stack<Character> stack = new Stack<>();
    int result = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push('(');
        continue;
      }

      if (s.charAt(i) == ')') {
        stack.pop();

        if (s.charAt(i - 1) == '(') {
          result += stack.size();
        } else {
          result++;
        }
      }

    }

    System.out.println(result);


  }


}
