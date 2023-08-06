//시간복잡도 : O(MN), M은 입력 받는 단어의 개수, N은 비교하는 두 단어 중 긴 단어의 길이
//아이디어 : 먼저 주어진 단어들을 배열에 저장해준다. 비교할 단어를 입력받고, 그 단어로 시작하는
//          단어가 배열에 있다면 count++해주고 반복
//자료구조 : 배열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int wordsNum = Integer.parseInt(st.nextToken());
        int testNum = Integer.parseInt(st.nextToken());

        TrieNode root = new TrieNode();

        for (int i = 0; i < wordsNum; i++) {
            String word = input.readLine();
            insertWord(root, word);
        }

        int count = 0;
        for (int i = 0; i < testNum; i++) {
            String word = input.readLine();
            if (isPrefix(root, word)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    public static void insertWord(TrieNode root, String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }

    public static boolean isPrefix(TrieNode root, String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return false;
            }
            current = current.children.get(ch);
        }
        return true;
    }
}
