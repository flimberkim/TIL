import java.util.*;

/*
아이디어 : 그래프의 특징을 살펴보면, 새로 생성한 정점은 들어오는 간선이 없고 나가는 간선만 있다. 도넛 모양 그래프는 모든 정점에서 들어오는 간선과 나가는 간선이 1개. 막대 그래프는 마지막 정점에서 나가는 간선이 없고 들어오는 간선만 1개. 8자 그래프는 중간에 있는 정점은 항상 나가는 간선 2개, 들어오는 간선 2개.
새로 생성한 정점에서 나가는 간선의 개수 - (8자 그래프의 개수 + 막대 그래프의 개수) = 도넛 그래프의 개수 // 이 공식을 이용한다.
시간복잡도 : O(NM), N은 edges 행의 개수, M은 edges 열의 개수
자료구조 : array, map
*/

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> out = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();
        int[] answer = new int[4];

        //들어오는 간선과 나가는 간선의 개수를 저장
        for (int[] edge : edges) {
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
        }

        for (int node : out.keySet()) {
            if (out.get(node) > 1) { // (2)
                if (!in.containsKey(node)) {
                    answer[0] = node;
                } else {
                    answer[3] += 1;
                }
            }
        }

        for (int node : in.keySet()) {
            if (!out.containsKey(node)) { // (3)
                answer[2] += 1;
            }
        }
        answer[1] = out.get(answer[0]) - answer[2] - answer[3]; // (4)
        return answer;
    }
}