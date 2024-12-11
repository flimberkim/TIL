import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
        1. 아이디어 : 문자열을 배열에 입력받고, 배열의 정렬을 조건대로 오버라이딩 해준다.
        2. 시간복잡도 : O(NlogN), N은 배열의 크기
        3. 자료구조 : array
*/

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    int caseNum = Integer.parseInt(input.readLine());
    String[] arr = new String[caseNum];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = input.readLine();
    }

    // 정렬: 1) 길이 오름차순 2) 길이가 같으면 사전순
    Arrays.sort(arr, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (o1.length() != o2.length()) {
          return Integer.compare(o1.length(), o2.length()); // 길이로 정렬
        }
        return o1.compareTo(o2); // 사전순 정렬
      }
    });

    StringBuilder sb = new StringBuilder();
    String prev = ""; // 중복 제거용

    for (String s : arr) {
      if (!s.equals(prev)) { // 중복된 단어는 출력하지 않음
        sb.append(s).append("\n");
        prev = s;
      }
    }

    System.out.print(sb.toString().trim());

  }


}
