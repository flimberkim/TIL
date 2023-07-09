import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//시간복잡도 : O(N), N은 주어진 문자열의 길이
//아이디어 : 각 알파벳 A와 B를 2번 단위로 나눠서 체크한다. 스택에 처음 들어오는 A 또는 B는 스택에 그대로 저장.
//         스택에 두 번째로 들어오는 A 또는 B는 peek()를 통해 비교하고 다른 알파벳이면 false를 리턴한다.
//         true인 경우들만 개수를 세어 주면 답!
//자료구조 : 스택

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int caseNum = Integer.parseInt(st.nextToken());

        int count = 0;
        for(int i = 0; i < caseNum; i++){
            st = new StringTokenizer(input.readLine());
            String temp = st.nextToken();
            if(temp.length() % 2 != 0) continue;
            if(check(temp)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean check(String str){
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        stack.add(str.charAt(0));
        for(int i = 1; i < str.length(); i++){
            char temp = str.charAt(i);
            if(!stack.isEmpty() && stack.peek() == temp) {
                stack.pop();
            }
            else stack.add(temp);
        }

        return stack.isEmpty() ? true : false;
    }

}





