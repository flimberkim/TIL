# 백준 문제풀이

## 문제 1316번
### 문제<br>
그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.<br>단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.<br><br>입력 :<br>첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.<br><br>출력 :<br>첫째 줄에 그룹 단어의 개수를 출력한다.
## 내 풀이
import java.io.BufferedReader;<br>
import java.io.IOException;<br>
import java.io.InputStreamReader;<br>

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static boolean groupWordCheck() throws IOException {
        boolean[] confirm = new boolean[26];
        int previous = 0;
        String word = input.readLine();

        for(int i = 0; i < word.length(); i++){
            int now = word.charAt(i);

            if(previous != now){
                if(confirm[now - 'a'] == false){
                    confirm[now - 'a'] = true;
                    previous = now;
                }
                else{
                    return false;
                }
            }
            else continue;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(input.readLine());
        int count = 0;

        for(int i = 0; i < num; i++){
            if(groupWordCheck() == true) count++;
        }
        System.out.println(count);
    }
}
<br><br><br>

#### 이 문제는 계속 틀려서 구글에 검새해 본 솔루션을 참고했다.. 다음에 다시 풀어봐야지!