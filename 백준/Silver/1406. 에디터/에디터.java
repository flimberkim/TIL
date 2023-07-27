//시간복잡도 : O(N), N은 명령어가 입력되는 횟수
//아이디어 : 처음 문자열을 StringBuilder로 받고, 조건에 따라 문자열에 대해 알맞은 조치를 한다.
//자료구조 : 배열, 스택

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder left = new StringBuilder(input.readLine());
        Stack<Character> right = new Stack<>();

        int caseNum = Integer.parseInt(input.readLine());

        for (int i = 0; i < caseNum; i++) {
            String[] arr = input.readLine().split(" ");
            switch (arr[0]) {
                case "L":
                    if (left.length() > 0) {
                        right.push(left.charAt(left.length() - 1));
                        left.setLength(left.length() - 1);
                    }
                    break;
                case "D":
                    if (!right.isEmpty()) {
                        left.append(right.pop());
                    }
                    break;
                case "B":
                    if (left.length() > 0) {
                        left.setLength(left.length() - 1);
                    }
                    break;
                case "P":
                    left.append(arr[1]);
                    break;
            }
        }

        while (!right.isEmpty()) {
            left.append(right.pop());
        }

        System.out.println(left.toString());
    }

}

