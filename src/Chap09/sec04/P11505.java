package Chap09.sec04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11505 {
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
        int treesize = (int) Math.pow(2, treeHeight + 1);
        int leftStartIndex = treesize / 2 - 1;
        MOD = 1000000007;
        tree = new long[treesize + 1];
        for(int i=0; i < tree.length; i++) {
            tree[i] = 1;
        }
        for(int i = leftStartIndex + 1; i < leftStartIndex + N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }
        setTree(treesize - 1);
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(a==1){
                changeVal(leftStartIndex + s, e);
            } else if(a==2){
                s += leftStartIndex;
                e += leftStartIndex;
                System.out.println(getMul(s, e));
            } else {
                return;
            }
        }
        br.close();
    }
    private static long getMul(int s, int e){
        int partMul = 0;
        while (s<=e){
            if(s % 2 != 0){
                partMul = (int) (partMul * tree[s] % MOD);
                s++;
            }
            if(e % 2 == 0){
                partMul = (int) (partMul * tree[e] % MOD);
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return partMul;
    }
    private static void changeVal(int index, int val){
        tree[index] = val;
        while (index > 1){
            index = index / 2;
            tree[index / 2] = tree[index*2] * tree[index*2+1];
        }
    }
    private static void setTree(int index){
        while (index != 1){
            tree[index/2] += tree[index/2] * tree[index] % MOD;
            index--;
        }
    }
}