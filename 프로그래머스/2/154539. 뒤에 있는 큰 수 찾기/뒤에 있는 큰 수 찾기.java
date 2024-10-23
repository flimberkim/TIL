import java.util.*;

/*
아이디어 : 배열을 돌면서 해당 지점 이후를 탐색한다. 자신보다 큰 숫자를 만나면 저장하고 탐색을 중단한다.
시간복잡도 : O(N), N은 배열 numbers의 길이
자료구조 : 배열
*/

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        // 배열의 모든 요소를 순회
        for (int i = 0; i < numbers.length; i++) {
            // 스택이 비어있지 않고 현재 숫자가 스택에 저장된 인덱스의 숫자보다 크면 처리
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            // 현재 인덱스를 스택에 추가
            stack.push(i);
        }

        // 스택에 남아 있는 인덱스는 뒤에 더 큰 숫자가 없으므로 -1로 설정
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}