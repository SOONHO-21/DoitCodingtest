package Chap09.sec03;

import java.util.Scanner;

public class P1991 {
    static int N;
    static int tree[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        tree = new int[26][2];
        sc.nextLine();
        for(int i=0; i<N; i++){
            String[] temp = sc.nextLine().split(" ");
            int node = temp[i].charAt(0) - 'A';
            char left = temp[i].charAt(0);
            char right = temp[i].charAt(0);

            if(left == '.') {
                tree[node][0] = -1;
            } else
                tree[node][0] = left - 'A';
            if(right == '.') {
                tree[node][1] = -1;
            } else
                tree[node][1] = right - 'A';
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }
    static void preOrder(int n){
        if(n == -1)
            return ;
        System.out.println((char)(n + 'A'));
        preOrder(tree[n][0]);
        preOrder(tree[n][1]);
    }
    static void inOrder(int n){
        if(n == -1)
            return ;
        preOrder(tree[n][0]);
        System.out.println((char)(n + 'A'));
        preOrder(tree[n][1]);
    }
    static void postOrder(int n){
        if(n == -1)
            return ;
        preOrder(tree[n][0]);
        preOrder(tree[n][1]);
        System.out.println((char)(n + 'A'));
    }
}