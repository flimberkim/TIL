import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        List<Integer> arr = new ArrayList<>();
        int caseNum = Integer.parseInt(input.readLine());
        String temp;


        for(int i = 0; i < caseNum; i++){
            st = new StringTokenizer(input.readLine());
            temp = st.nextToken();
            if(temp.equals("push")){
                arr.add(Integer.parseInt(st.nextToken()));
                continue;
            }
            if(temp.equals("pop")){
                if (arr.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                } else {
                    sb.append(arr.get(0)).append("\n");
                    arr.remove(0);
                    continue;
                }
            }
            if(temp.equals("size")){
                sb.append(arr.size()).append("\n");
                continue;
            }
            if(temp.equals("empty")){
                if (arr.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
                continue;
            }
            if(temp.equals("front")){
                if(arr.isEmpty()){
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(arr.get(0)).append("\n");
                }
                continue;
            }
            if(temp.equals("back")){
                if(arr.isEmpty()){
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(arr.get(arr.size()-1)).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}