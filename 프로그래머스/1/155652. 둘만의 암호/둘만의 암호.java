import java.util.*;
/*
아이디어 : 먼저 건너뛸 문자들을 skipList에 저장한다. 문자열을 돌면서 해당 문자에서 index만큼 가는 동안에 skipList에 겹치는 문자들이 있는지 확인한다. 있으면 그만큼 더 간다. 최종적으로 바뀐 문자가 'z'보다 큰지 확인하고 마지막 조정을 해준다.
시간복잡도 : O(N), N은 s의 길이
자료구조 : set
*/

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        Set<Character> skipSet = new HashSet<>();

        // skip 문자를 Set에 저장
        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }

        // 문자열 s를 순회하며 변환
        for (char c : s.toCharArray()) {
            char current = c;
            int steps = 0;

            // index만큼 이동하며 skipSet에 포함된 문자 건너뜀
            while (steps < index) {
                current++; // 다음 문자로 이동
                if (current > 'z') {
                    current = 'a'; // 알파벳 순환
                }
                if (!skipSet.contains(current)) {
                    steps++; // 건너뛸 필요가 없으면 이동 카운트 증가
                }
            }

            sb.append(current);
        }

        return sb.toString();
    }
}