import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder temp = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        String word;
        int leftPoint = 0;
        int rightPoint = 0;
        int count = 0;

        int caseNum = Integer.parseInt(input.readLine());

        for(int i = 0; i < caseNum; i++){
            word = input.readLine(); //단어를 입력받고
            leftPoint = 0;
            rightPoint = word.length() - 1;

            while(leftPoint <= rightPoint){ //투 포인터를 이용해 반복문 돌린다.
                //만약 양쪽끝 문자가 같다면 왼쪽은 한칸 증가, 오른쪽은 한칸 감소
                if(word.charAt(leftPoint) == word.charAt(rightPoint)){
                    leftPoint++;
                    rightPoint--;
                }
                else{
                    //해당 위치의 문자가 서로 다르다면, 왼쪽 해당 인덱스 문자를 하나 지우고 그것이 회문인지 확인
                    //회문이면, 1개를 지웠을때 회문인 것이므로 유사회문!
                    //오른쪽 문자가 문제일 수도 있으니 오른쪽도 똑같이 해본다.
                    //둘다 아니라면 이 문자는 회문도, 유사회문도 아님!
                    temp = new StringBuilder(word);
                    String tempWord = temp.deleteCharAt(leftPoint).toString();
                    temp = new StringBuilder(word);
                    String reverse = temp.deleteCharAt(leftPoint).reverse().toString();
                    if(tempWord.equals(reverse)){
                        answer.append(1).append("\n");
                        break;
                    }

                    temp = new StringBuilder(word);
                    tempWord = temp.deleteCharAt(rightPoint).toString();
                    temp = new StringBuilder(word);
                    reverse = temp.deleteCharAt(rightPoint).reverse().toString();
                    if(tempWord.equals(reverse)){
                        answer.append(1).append("\n");
                        break;
                    }

                    answer.append(2).append("\n");
                    break;
                }
                //반복문을 끝까지 나가지 않았다면, 회문이라는 뜻이므로 0 입력
                if(leftPoint > rightPoint) answer.append(0).append("\n");
            }
        }
        System.out.println(answer);
    }
}