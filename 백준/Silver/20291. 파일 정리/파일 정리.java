import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int fileNum = Integer.parseInt(input.readLine());
        TreeMap<String, Integer> map = new TreeMap<>(); //정렬을 하며 저장하는 해시맵 이용
        int temp1 = 0;
        StringBuilder sb = new StringBuilder();
        String temp;
        String[] temparr;

        for (int i = 0; i < fileNum; i++) {
            temp = input.readLine();
            temparr = temp.split("\\.", 2); //입력받은 단어를 나눔
            if (map.containsKey(temparr[1])) { //만약 확장자명이 트리맵에 있다면 그 값을 1 증가시킴
                temp1 = map.get(temparr[1]) + 1;
                map.put(temparr[1], temp1);
            } else { //없다면 확장자명을 키로 하고 그 값을 1로 초기화해서 넣어줌
                map.put(temparr[1], 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) { //모든 엔트리셋을 돌면서 sb에 확장자명과 개수를 추가
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        System.out.println(sb);
    }
}