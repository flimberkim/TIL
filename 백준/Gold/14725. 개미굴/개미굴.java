//시간복잡도 : O(N), N은 입력되는 문자열(노드)의 개수
//아이디어 : 문제대로 트리를 구성하고, 차수를 고려해 "--"를 붙인 뒤 출력한다.
//자료구조 : Map,Tree

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int caseNum;
        TreeMap<String, TreeMap> map = new TreeMap<>();
        caseNum = Integer.parseInt(st.nextToken());

        for (int i = 0; i < caseNum; i++) {
            st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            TreeMap target = map;
            for (int j = 0; j < n; j++) {
                String name = st.nextToken();
                if (target.get(name) == null){
                    target.put(name, new TreeMap<>());
                }
                target = (TreeMap) target.get(name);
            }
        }
        getresult(map,0);
        System.out.println(sb.toString());

    }
    static void getresult(TreeMap map,int n) {

        for(Object s : map.keySet()) {
            for(int i = 0 ; i < n ; i++){
                sb.append("--");
            }
            sb.append(s + "\n");
            getresult((TreeMap)map.get(s),n+1);
        }
    }
}