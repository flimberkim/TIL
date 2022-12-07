# 백준 문제풀이

## 문제 2941번
### 문제<br>
예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.

크로아티아 알파벳&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;변경<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;č&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;c=<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ć&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;c-<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dž&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dz=<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;đ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;d-<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lj&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lj<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;nj&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;nj<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;š&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;s=<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ž&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;z=<br><br>
예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.

dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.<br><br>

입력<br>
첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.

단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.<br><br>

출력<br>
입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
## 내 풀이
import java.io.BufferedReader;<br>
import java.io.IOException;<br>
import java.io.InputStreamReader;<br>

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String str = input.readLine();
        String first = str;
        int[] arr = new int[8];
        int sum = 0;
        int rest = 0;
        int total = 0;

        sb.append(str);

        while((str.contains("c=") || str.contains("c-") || str.contains("dz=") || str.contains("d-") || str.contains("lj") || str.contains("nj") || str.contains("s=") || str.contains("z=")) == true) {
            if (str.contains("c=")) {
                sb.replace(sb.indexOf("c="), sb.indexOf("c=") + 2, "xx");
                str = sb.toString();
                arr[0]++;
                continue;
            }
            if (str.contains("c-")) {
                sb.replace(sb.indexOf("c-"), sb.indexOf("c-") + 2, "xx");
                str = sb.toString();
                arr[1]++;
                continue;
            }
            if (str.contains("dz=")) {
                sb.replace(sb.indexOf("dz="), sb.indexOf("dz=") + 3, "xxx");
                str = sb.toString();
                arr[2]++;
                continue;
            }
            if (str.contains("d-")) {
                sb.replace(sb.indexOf("d-"), sb.indexOf("d-") + 2, "xx");
                str = sb.toString();
                arr[3]++;
                continue;
            }
            if (str.contains("lj")) {
                sb.replace(sb.indexOf("lj"), sb.indexOf("lj") + 2, "xx");
                str = sb.toString();
                arr[4]++;
                continue;
            }
            if (str.contains("nj")) {
                sb.replace(sb.indexOf("nj"), sb.indexOf("nj") + 2, "xx");
                str = sb.toString();
                arr[5]++;
                continue;
            }
            if (str.contains("s=")) {
                sb.replace(sb.indexOf("s="), sb.indexOf("s=") + 2, "xx");
                str = sb.toString();
                arr[6]++;
                continue;
            }
            if (str.contains("z=")) {
                sb.replace(sb.indexOf("z="), sb.indexOf("z=") + 2, "xx");
                str = sb.toString();
                arr[7]++;
            }
        }

        for(int i : arr){
            sum += i;
        }
        rest = first.length() - (arr[0]*2 + arr[1]*2 + arr[2]*3 + arr[3]*2 + arr[4]*2 + arr[5]*2 + arr[6]*2 + arr[7]*2);
        total = sum + rest;
        System.out.println(total);
    }
}
<br><br><br>
##### 조건문과 반복문을 이용해서 문자를 하나하나 비교하며 푼다면 쉽게 풀 수 있는 문제였다. 하지만 나는 메서드를 이용해 문자열 단위로 체크를 하려다 보니 에러가 계속 발생했고, 해결하는데 꽤나 시간이 걸렸다ㅠㅠ