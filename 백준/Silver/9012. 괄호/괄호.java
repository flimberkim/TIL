import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine());
        String temp;
        ArrayList<String> result = new ArrayList<>(); //결과값만 모아놓을 배열
        int num = 0;
        
        for(int i = 0; i < testCase; i++){
            temp = input.readLine();
            for(int j = 0; j < temp.length(); j++){
                if (temp.charAt(j) == '(') num++;  // '(' 개수마다 숫자 1 증가
                else num--; // ')' 개수마다 숫자 1 감소
                if(j != temp.length() -1 && num < 0) { //문자열 끝까지 비교 하기 전에 ')'의 개수가 더 많으면 NO 저장
                    result.add("NO");
                    break;
                }
            }
            if(result.size() == i) { //위 조건문에서 결과 배열에 추가 되지 않은 경우
                if (num == 0) result.add("YES"); //'('의 개수와 ')'의 개수가 같으면 YES 저장
                else result.add("NO"); //개수가 맞지 않으면 NO 저장
            }
            num = 0; //개수 파악을 위한 변수는 매 케이스가 끝나면 0으로 초기화
        }
        for(String s : result){
            System.out.println(s);
        }
    }
}