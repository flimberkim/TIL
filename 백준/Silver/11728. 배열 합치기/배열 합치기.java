//시간복잡도 : O(N), N은 A배열의 길이 + B배열의 길이
//아이디어 : 두 배열에 각각 포인터를 두고, 포인터에 해당하는 값을 비교하고 포인터를 변경해 나간다.
//자료구조 : 배열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int aLen = Integer.parseInt(st.nextToken());
        int bLen = Integer.parseInt(st.nextToken());
        int[] answer = new int[aLen + bLen];
        int answerPointer = 0;
        int aPointer = 0;
        int bPointer = 0;
        int[] a = new int[aLen];
        int[] b = new int[bLen];

        st = new StringTokenizer(input.readLine());
        StringTokenizer st2 = new StringTokenizer(input.readLine());

        for(int i = 0; i < aLen; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < bLen; i++) {
            b[i] = Integer.parseInt(st2.nextToken());
        }

        while(true) {
            if(aPointer < aLen && bPointer < bLen){
                answer[answerPointer++] = a[aPointer] < b[bPointer] ? a[aPointer++] : b[bPointer++];
            }
            else if(aPointer < aLen && bPointer == bLen) {
                while(aPointer < aLen) {
                    answer[answerPointer++] = a[aPointer++];
                }
            }
            else if (aPointer == aLen && bPointer < bLen) {
                while(bPointer < bLen) {
                    answer[answerPointer++] = b[bPointer++];
                }
            }
            else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb.toString());

    }

}

