import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        String word = input.readLine();

        int aLen = 0;
        int bNum = 0;

        for (int i = 0; i < word.length(); i++) { //a의 길이(개수) 구하기
            if (Character.valueOf(word.charAt(i)).equals('a')) aLen++;
        }

        for(int i = 0; i <= word.length() - aLen; i++){ //슬라이딩 윈도우 적용하면서 b의 개수를 세기
            for(int j = i; j < i + aLen; j++){
                if(Character.valueOf(word.charAt(j)).equals('b')) bNum++;
            }
            tm.put(bNum, 0);
            bNum = 0;
        }

        for(int i = word.length() - aLen + 1; i < word.length(); i++){ //문자열은 원형으로 이루어져 있기 때문에, 인덱스가 넘어가는 경우 따로 계산
            for(int k = i; k < word.length(); k++){
                if(Character.valueOf(word.charAt(k)).equals('b')) bNum++;
            }

            for(int j = 0; j < aLen -word.length() + i; j++){
                if(Character.valueOf(word.charAt(j)).equals('b')) bNum++;
            }
            tm.put(bNum, 0);
            bNum = 0;
        }
        System.out.println(tm.firstKey());
    }
}