package Chap09.sec04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2042_1 {
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int treeHeight = 0;
        int length = N;
        while (length != 0){
            length /= 2;
            treeHeight++;
        }
        int treeSize = (int) Math.pow(2, treeHeight+1);
        int leftStartIndex = treeSize/2 - 1;
        tree = new int[treeSize + 1];
        for(int i = leftStartIndex+1; i <= leftStartIndex + N; i++){
            tree[i] = Integer.parseInt(br.readLine());
        }
        setTree(treeSize-1);
        for(int i = 0; i < M+K; i++){
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Integer.parseInt(st.nextToken());
            if(a==1){
                changeVal(leftStartIndex+s, (int) e);
            } else if (a==2) {
                s += leftStartIndex;
                e += leftStartIndex;
                System.out.println(getSum3(s, (int) e));
            }
            else
                return;
        }
        br.close();
    }
    private static void setTree(int number){
        int i = number;
        while (i>=0){
            tree[i/2] += tree[i];
            i--;
        }
    }
    private static void changeVal(int index, int val){
        int diff = val - tree[index];
        while (index != 0){
            tree[index] += diff;
            index /= 2;
        }
    }
    private static int getSum3(int s, int e){
        int sum = 0;
        if(s%2 == 1) {
            sum += tree[s];
        }
        if(e%2 == 0) {
            sum += tree[e];
        }
        s = s/2;
        e = e/2;
        return sum;
    }
}