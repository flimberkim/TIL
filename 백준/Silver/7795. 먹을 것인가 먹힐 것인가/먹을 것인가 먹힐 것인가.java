//시간복잡도 : O(MlogN), M,N은 각각 배열 A와 B의 길이
//아이디어 : 배열 A,B를 만들고 각각의 포인터를 두고, 문제의 조건에 맞게 포인터를 이동시킨다.
//자료구조 : 배열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int caseNum = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < caseNum; i++) {
                st = new StringTokenizer(input.readLine());
                int aNum = Integer.parseInt(st.nextToken());
                int bNum = Integer.parseInt(st.nextToken());
                int[] arrA = new int[aNum];
                int[] arrB = new int[bNum];

                st = new StringTokenizer(input.readLine());
                for(int j = 0; j < aNum; j++) {
                    arrA[j] = Integer.parseInt(st.nextToken());
                }

                st = new StringTokenizer(input.readLine());
                for(int j = 0; j < bNum; j++) {
                    arrB[j] = Integer.parseInt(st.nextToken());
                }
                Arrays.sort(arrB);

                sb.append(solution(arrA, arrB)).append("\n");
        }
        System.out.println(sb);
    }

    public static int solution(int[] arrA, int[] arrB){
        int answer = 0;
        int bLeft = 0;
        int bRight = arrB.length - 1;
        int bIndex = 0;

        for (int aNum : arrA) {

            while(bLeft <= bRight){
                int bMid = (bLeft + bRight) / 2;
                if(aNum > arrB[bMid]) {
                    bLeft = bMid + 1;
                    bIndex = bMid + 1;
                }
                else bRight = bMid - 1;
            }
            bLeft = 0;
            bRight = arrB.length - 1;
            answer += bIndex;
            bIndex = 0;
        }
        return answer;
    }
}