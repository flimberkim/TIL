import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static TreeNode head = new TreeNode(0, null, null); //루트 노드 초기화


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //후위 순회를 해서 출력하는 메서드
    public static void postOrder(TreeNode head){
        if(head == null) return;
        postOrder(head.left);
        postOrder(head.right);
        sb.append(head.val).append("\n");
    }
    
    //끝까지 입력을 받아서 하나하나 트리에 넣는 메서드
    static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String temp;

        while(true){
            temp = input.readLine();
            if(temp == null || temp.equals("")) break;

            makeTree(Integer.parseInt(temp), head);
        }
    }

    static void makeTree(int n, TreeNode head){
        if(head.val == 0) { //헤드노드가 비어있다면 먼저 첫번째 입력값을 넣어준다.
            head.val = n;
            return;
        }

        //만약 값이 헤드노드값보다 작고, 왼쪽 노드가 비어있다면 넣어준다.
        if (n < head.val && head.left == null) {
            head.left = new TreeNode(n, null, null);
        }//값이 큰 경우 마찬가지로 오른쪽 노드에 넣어준다.
        else if(n > head.val && head.right == null) {
            head.right = new TreeNode(n, null, null);
        }

        //만약 노드가 이미 존재한다면 그 노드를 헤드노드로 하여 메서드 재귀호출
        if(n < head.val && head.left != null){
            makeTree(n, head.left);
        }
        else if(n > head.val && head.right != null){
            makeTree(n, head.right);
        }
    }



    public static void main(String[] args) throws IOException {
        input();
        postOrder(head);
        System.out.println(sb.toString().trim());
    }
}