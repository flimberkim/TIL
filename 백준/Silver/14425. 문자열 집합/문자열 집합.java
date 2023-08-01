//시간복잡도 : O(N), N은 입력받는 문자와 테스트 해볼 문자의 개수 중 많은 것의 개수
//아이디어 : 처음에 입력받는 문자들을 Set에 넣는다. 테스트 해볼 문자를 입력받으면서 Set에 있는지 체크한다.
//자료구조 : Set

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int length = Integer.parseInt(st.nextToken());
        int testNum= Integer.parseInt(st.nextToken());
        int count = 0;
        String temp;

        Set<String> check = new HashSet<>();

        for(int i = 0; i < length; i++){
            check.add(input.readLine());
        }

        for(int j = 0; j < testNum; j++){
            temp = input.readLine();
            if(check.contains(temp)){
                count++;
            }
        }
        System.out.println(count);
    }
}