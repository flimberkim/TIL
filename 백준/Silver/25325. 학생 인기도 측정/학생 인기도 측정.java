import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(input.readLine());
        ArrayList<String> stuNames = new ArrayList<>(); //처음에 학생 이름들을 입력받을 배열
        int[] numLikes = new int[num];
        String[] stuNamesFinal; //ArrayList를 배열로 바꿔서 저장할 배열
        int temp = 0; //순서 바꿀때 필요한 임시 변수
        String tempst; //순서 바꿀때 필요한 임시 변수

        st = new StringTokenizer(input.readLine());
        while(st.hasMoreTokens()){
            stuNames.add(st.nextToken());
        }

        for(int j = 0; j < num; j++){
            st = new StringTokenizer(input.readLine());
            while(st.hasMoreTokens()){
                numLikes[stuNames.indexOf(st.nextToken())]++;
            }
        }
        stuNamesFinal = stuNames.toArray(new String[stuNames.size()]);

        while(num >= 2) {
            for (int i = 0; i < num - 1; i++) {
                if (numLikes[i] < numLikes[i + 1]) { //각 배열을 조건이 성립할때 동시에 정렬
                    temp = numLikes[i + 1];
                    numLikes[i + 1] = numLikes[i];
                    numLikes[i] = temp;

                    tempst = stuNamesFinal[i + 1];
                    stuNamesFinal[i + 1] = stuNamesFinal[i];
                    stuNamesFinal[i] = tempst;
                }
                else if(numLikes[i] == numLikes[i+1]){
                    if(stuNamesFinal[i].compareTo(stuNamesFinal[i+1]) > 0){
                        temp = numLikes[i + 1];
                        numLikes[i + 1] = numLikes[i];
                        numLikes[i] = temp;

                        tempst = stuNamesFinal[i + 1];
                        stuNamesFinal[i + 1] = stuNamesFinal[i];
                        stuNamesFinal[i] = tempst;
                    }
                }
            }
            num--;
        }

        for(int i = 0; i < numLikes.length; i++){
            sb.append(stuNamesFinal[i]).append(" ").append(numLikes[i]).append("\n");
        }
        System.out.println(sb);
    }
}