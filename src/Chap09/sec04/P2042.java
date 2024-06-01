package Chap09.sec04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2042 {
    static long[] tree;
    static int N, M, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int treeHeight = 0;
        int length = N;
        while (length != 0){
            length /= 2;
            treeHeight++;
        }
        int treesize = (int) Math.pow(2, N+1);
        int leftNodeStart = treesize / 2 - 1;
        tree = new long[treesize + 1];
        for(int i = leftNodeStart + 1; i < leftNodeStart + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treesize - 1);
        for(int i=0; i<M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            long s = Integer.parseInt(st.nextToken());
            long e = Integer.parseInt(st.nextToken());
            if(a == 1){
                changeVal((int) (leftNodeStart + s), e);
            } else if(a == 2){
                s += leftNodeStart;
                e += leftNodeStart;
                System.out.println(getSum((int) s, (int) e));
            } else {
                return;
            }
        }
        br.close();
    }
    private static long getSum(int s, int e){
        int partSum = 0;
        while (s <= e){
            if(s % 2 != 0){
                partSum += tree[s];
            }
            if(e % 2 == 0){
                partSum += tree[e];
            }
            s /= 2;
            e /= 2;
        }
        return partSum;
    }
    private static void changeVal(int index, long val){
        long diff = val - tree[index];  //원래 값와의 차이
        while (index > 0){
            tree[index] = tree[index] + diff;
            index = index / 2;      //부모 노드의 값 또한 바꿔야 되므로
        }
    }
    private static void setTree(int i){
        while (i!=1){
            tree[i/2] += tree[i];
            i--;
        }
    }
}