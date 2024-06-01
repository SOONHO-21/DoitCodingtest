package Chap09.sec04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11505_1 {
    static long[] tree;
    static int MOD;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int treeHeight = 0;
        int length = N;
        while (length != 0){
            length /= 2;
            treeHeight++;
        }
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leftStartIndex = treeSize/2 - 1;
        tree = new long[N];
        MOD = 1000000007;
        for(int i=leftStartIndex+1; i<leftStartIndex + N; i++){
            tree[i] = 1;
        }
        for(int i=leftStartIndex+1; i<leftStartIndex + N; i++){
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize);
        for(int i=0; i<M+K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(a==1)
                changeVal(leftStartIndex + s, e);
            else if (a==2) {
                a = leftStartIndex + s;
                e = leftStartIndex + e;
                System.out.println(getMul(s, e));
            } else
                return;
        }
        br.close();
    }
    private static long getMul(int s, int e) {
        int partMul = 1;
        while (s<=e){
            if(s%2 != 0){
                partMul *= s;
            }
            if(e%2 == 0){
                partMul *= e;
            }
            s /= 2;
            e /= 2;
        }
        return partMul;
    }
    private static void changeVal(int index, int val){
        tree[index] = val;
        while (index>1){
            index /= 2;
            tree[index] = tree[index*2] + tree[index*2 + 1];
        }
    }
    private static void setTree(int index){
        while (index != 1){
            tree[index/2] = tree[index/2] * tree[index];
            index--;
        }
    }
}