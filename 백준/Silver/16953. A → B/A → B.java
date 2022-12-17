import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int count = 1;
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        //a->b로 만드는 경우는 각 케이스마다 선택지가 2가지씩 존재할 수 있음
        //b->a로 만드는 과정은 선택지가 한정되어 있음. 따라서 거꾸로 연산하는 것이 편함

        while(a != b) {
            if(b < a) { //같아지지 않고 b가 더 작아지면 끝
                count = -1;
                break;
            }
            if (b - (b / 10) * 10 != 1 && b % 2 != 0) { //b의 끝자리가 1이 아니면서 2로 나누어 떨어지지 않으면 a로 바뀔 수 없음!
                count = -1;
                break;
            }

            if (b % 2 == 0) { //2로 나눠지면 나누고
                b /= 2;
            } else { //아니면 끝 1을 빼는 방법 밖에 없음
                b = (b - 1) / 10;
            }
            count++;
        }
        System.out.println(count);

    }
}