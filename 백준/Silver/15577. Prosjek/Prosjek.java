import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    static PriorityQueue<Double> arr = new PriorityQueue<>();
    
    //값을 입력받는 메서드
    public static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(input.readLine());

        for(int i = 0; i < caseNum; i++){
            arr.add(Double.parseDouble(input.readLine()));
        }
    }
    
    //필요한 연산을 하는 메서드
    public static double function(){
        double answer = 0;
        
        while(true){ //arr은 정렬이 되어서 입력되므로
            //먼저 작은 값을 두개 꺼내서 평균을 구한다.
            answer = (arr.poll() + arr.poll()) / 2;
            //그리고 그 평균값을 다시 넣는다.
            arr.add(answer);
            //만약 PriorityQueue의 크기가 1이라면 종료
            if(arr.size() == 1) break;
        }
        //그때의 최종 평균값을 반환한다.
        return answer;
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(function());
    }
}