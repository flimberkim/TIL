//시간복잡도 : O(N), N은 (주어진 문자열의 길이 - 확인하는 부분 문자열의 길이 + 1)
//아이디어 : 슬라이딩윈도우를 사용해서 문자열을 돌면서 조건에 맞는 경우라면 count++;을 하며 개수를 센다.
//자료구조 : 배열, Map

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<Character, Integer> check = new HashMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int len = Integer.parseInt(st.nextToken());
        int windowLen = Integer.parseInt(st.nextToken());
        int count = 0;
        String str = input.readLine();
        char[] arr = str.toCharArray();
        String word = input.readLine();

        checkMapGenerator(word);

        int left = 0;
        int right = 0;

        Map<Character, Integer> temp = new HashMap<>();

        while(right < len) {
            temp.put(arr[right], temp.getOrDefault(arr[right], 0) + 1);
            if (right - left + 1 == windowLen) {
                if (isOk(check, temp)) {
                    count++;
                }
                temp.put(arr[left], temp.get(arr[left]) - 1);
                if (temp.get(arr[left]) == 0) {
                    temp.remove(arr[left]);
                }
                left++;
            }
            right++;
        }
        System.out.println(count);
    }

    public static void checkMapGenerator(String str){
        StringTokenizer st = new StringTokenizer(str);
        int tempNum = Integer.parseInt(st.nextToken());
        if(tempNum != 0){
            check.put('A', tempNum);
        }
        tempNum = Integer.parseInt(st.nextToken());
        if(tempNum != 0){
            check.put('C', tempNum);
        }
        tempNum = Integer.parseInt(st.nextToken());
        if(tempNum != 0){
            check.put('G', tempNum);
        }
        tempNum = Integer.parseInt(st.nextToken());
        if(tempNum != 0){
            check.put('T', tempNum);
        }
    }

    public static boolean isOk(Map<Character, Integer> check, Map<Character, Integer> temp) {
        for(Character key : check.keySet()) {
            if(!temp.containsKey(key) || temp.get(key) < check.get(key)) {
                return false;
            }
        }
        return true;
    }
}

