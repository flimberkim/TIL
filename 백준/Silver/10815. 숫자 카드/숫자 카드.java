import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//시간복잡도 : O(N), N은 상근이가 가지고 있는 카드 수와 검사해야할 카드 수 중에 큰 수
//아이디어 : 상근이가 가지고 있는 카드들을 HashSet에 넣고 검사한다.
//자료구조 : Set

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        int caseNum = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());

        for(int i = 0; i < caseNum; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(input.readLine());
        st = new StringTokenizer(input.readLine());

        while(st.hasMoreTokens()){
            if(set.contains(Integer.parseInt(st.nextToken()))){
                sb.append(1).append(" ");
        }else{
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}





