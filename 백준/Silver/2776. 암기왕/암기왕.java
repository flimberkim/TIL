import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
        1. 아이디어 : 처음에 연종이가 본 숫자들을 배열에 저장하고 정렬해둔다.(이분탐색은 정렬이 되어있어야 하기 때문)
                    그 후에 체크할 숫자들이 배열에 존재하는 체크하면서 StringBuilder에 값을 추가한다.
        2. 시간복잡도 : O(N), N은 배열의 크기
        3. 자료구조 : array

*/

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int[] book;
    int temp;

    int num = Integer.parseInt(input.readLine());

    for (int i = 0; i < num; i++) {
      book = new int[Integer.parseInt(input.readLine())];
      st = new StringTokenizer(input.readLine());

      for (int j = 0; j < book.length; j++) {
        book[j] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(book);

      input.readLine();
      st = new StringTokenizer(input.readLine());

      while (st.hasMoreTokens()) {
        temp = Integer.parseInt(st.nextToken());

        if (Arrays.binarySearch(book, temp) >= 0) {
          sb.append(1).append("\n");
        } else {
          sb.append(0).append("\n");
        }
      }

    }

    System.out.println(sb.toString().trim());

  }


}
