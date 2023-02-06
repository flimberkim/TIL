import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        ArrayList<Integer> arr = new ArrayList<>();

        int caseNum = Integer.parseInt(input.readLine());

        for(int i = 0; i < caseNum; i++){
            int integerNum = Integer.parseInt(input.readLine());
            st = new StringTokenizer(input.readLine());
            while(st.hasMoreTokens()){
                arr.add(Integer.parseInt(st.nextToken()));
            }

            arr.sort(Comparator.naturalOrder());
            sb.append(arr.get(0)).append(" ").append(arr.get(arr.size()-1)).append("\n");
            arr = new ArrayList<>();
        }

        System.out.println(sb);

    }
}