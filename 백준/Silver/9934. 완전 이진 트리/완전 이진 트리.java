import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int num;
    static StringBuilder[] answer;
    static int[] arr;
    
    //입력 받는 메서드
    static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(input.readLine()); //층수 입력받는다.
        arr = new int[(int) (Math.pow(2,num) - 1)]; //노드 개수를 크기로 갖는 배열 생성
        answer = new StringBuilder[num]; //층수 만큼의 StringBuilder 배열 생성
        
        for(int i = 0; i < num; i++){ //null로 초기화되어 있으므로 각 인덱스에 StringBuilder 객체를 넣어준다.
            StringBuilder temp = new StringBuilder();
            answer[i] = temp;
        }

        StringTokenizer st = new StringTokenizer(input.readLine());

        //노드의 값들을 입력받아 배열 arr에 저장
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }
    
    //중위순회의 규칙을 이용해서 중간값들을 계속 뽑아내고 각 층에 해당하는 StringBuilder에 추가한다.
    static void solution(int startIndex, int endIndex, int floor){
        if(floor == num) return; //층수가 끝나면 이 함수는 종료

        int midIndex = (startIndex + endIndex) / 2;
        answer[floor].append(arr[midIndex]).append(" ");

        solution(startIndex, midIndex - 1, floor + 1); //반으로 나눴을때 왼쪽 부분배열을 계산할 재귀함수
        solution(midIndex + 1, endIndex, floor + 1); //반으로 나눴을때 오른쪽 부분배열을 계산할 재귀함수

    }



    public static void main(String[] args) throws IOException {
        input();
        solution(0, arr.length -1, 0); //arr배열의 시작과 끝 인덱스를 넣어주고, 층수는 0층부터 시작

        for(int i = 0; i < answer.length; i++){
            //answer 배열에는 각 층에 있는 노드들을 연결한 String이 저장되어 있음
            //따라서 차례대로 answer배열의 값들을 출력해주고 한 줄 띄면 됨
            System.out.println(answer[i]); 
        }


    }
}