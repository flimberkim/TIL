import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static TreeNode head = new TreeNode('A', null, null); //루트 노드 초기화
    public static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        TreeNode() {        }

        TreeNode(char val) {
            this.val = val;
        }

        TreeNode(char  val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //입력받은 값으로 트리를 만드는 메서드
    public static void insertNode(TreeNode temp, char root, char left, char right){
        if(temp.val == root){
            temp.left = (left == '.' ? null : new TreeNode(left, null, null));
            temp.right = (right == '.' ? null : new TreeNode(right, null, null));
        }
        else{
            if(temp.left != null) insertNode(temp.left, root, left, right);
            if(temp.right != null) insertNode(temp.right, root, left, right);
        }
    }

    //전위 순회를 해서 출력하는 메서드
    public static void preOrder(TreeNode head){
        if(head == null) return;
        System.out.print(head.val);
        preOrder(head.left);
        preOrder(head.right);

    }

    //중위 순회를 해서 출력하는 메서드
    public static void inOrder(TreeNode head){
        if(head == null) return;
        inOrder(head.left);
        System.out.print(head.val);
        inOrder(head.right);

    }

    //후위 순회를 해서 출력하는 메서드
    public static void postOrder(TreeNode head){
        if(head == null) return;
        postOrder(head.left);
        postOrder(head.right);
        System.out.print(head.val);
    }
    static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        StringTokenizer st;

        for(int i = 0; i < num; i ++){
            st = new StringTokenizer(input.readLine());
            char root;
            char left;
            char right;

            root = st.nextToken().charAt(0);
            left = st.nextToken().charAt(0);
            right = st.nextToken().charAt(0);

            insertNode(head, root, left, right);

        }
    }



    public static void main(String[] args) throws IOException {
        input();

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();

    }
}