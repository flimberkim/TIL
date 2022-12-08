import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine());
        PriorityQueue<Integer> testset = new PriorityQueue<>(Collections.reverseOrder()); //최대 힙을 반환하는 큐 생성
        ArrayList<Integer> result = new ArrayList<>(); //결과값만 모아놓을 배열
        int num = 0;

        for(int i = 0; i < testCase; i++){ //testCase만큼 반복
            num = Integer.parseInt(input.readLine()); //매 케이스 마다의 연산이 무엇인지 입력받음
            if(num == 0){ //0을 입력받은 경우 
                if(testset.isEmpty()) result.add(0); //큐가 비어있으면 0을 반환해서 배열에 저장
                else{
                    result.add(testset.poll()); //큐가 비어있지 않으면 최대값을 반환하고 큐에서 제거
                }
            }
            testset.add(num); //입력받은 수가 0이 아니면, 그 값을 큐에 저장
        }
        for(int i : result){ //결과값을 모아 놓은 배열을 출력
            System.out.println(i);
        }
    }
}