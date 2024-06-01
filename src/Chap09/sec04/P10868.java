package Chap09.sec04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10868 {
    static int N, M;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long treeHeight = 0;
        long length = N;
        while (length != 0){
            length /= 2;
            treeHeight++;
        }
        int treeSize = (int) Math.pow(2, treeHeight+1);
        int leftStartIndex = treeSize/2 - 1;
        tree = new long[treeSize + 1];
        for(int i=0; i<tree.length; i++){
            tree[i] = Integer.MAX_VALUE;
        }
        for(int i=leftStartIndex + 1; i<leftStartIndex + N; i++){
            st = new StringTokenizer(br.readLine());
            tree[i] = Long.parseLong(st.nextToken());
        }
        setTree(treeSize - 1);
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            s += leftStartIndex;
            e += leftStartIndex;
            System.out.println(getMin(s, e));
        }
        br.close();
    }
    //트리 초기화 하기
    private static void setTree(int i){
        while (i!=1){
            if(tree[i/2]>tree[i])
                tree[i/2] = tree[i];
            i--;
        }
    }
    private static long getMin(int s, int e){
        long min = Long.MAX_VALUE;
        while (s <= e){
            if(s%2 == 1) {
                min = Math.min(tree[s], min);
                s++;
            }
            if(e%2 == 0) {
                min = Math.min(tree[e], min);
                e--;
            }
            s = s/2;
            e = e/2;
        }
        return min;
    }
}