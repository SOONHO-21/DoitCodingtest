package Chap07.sec03;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class P1033 {
    static ArrayList<cNode_1>[] A;
    static long lcm;
    static boolean visited[];
    static long D[];
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        A = new ArrayList[N];   //ArrayList의 배열
        visited = new boolean[N];
        D = new long[N];
        lcm = 1;
        for(int i=0; i<N; i++){
            A[i] = new ArrayList<cNode_1>();
        }
        for(int i=0; i<N-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            A[a].add(new cNode_1(b, p, q));
            A[b].add(new cNode_1(a, q, p));
            lcm *= (p * q / gcd(p, q));
        }
        D[0] = lcm;
        DFS(0);
        long mgcd = D[0];
        for(int i=0; i<N; i++){
            mgcd = gcd(mgcd, D[i]);
        }
        for(int i=0; i<N; i++){
            System.out.println(D[i]/mgcd + " ");
        }
    }

    public static long gcd(long a, long b){     //최대 공약수 함수 구현하기
        if(b==0)
            return a;
        else
            return gcd(b, a%b);
    }
    public static void DFS(int Node){
        visited[Node] = true;
        for(cNode_1 i : A[Node]){
            int next = i.getB();
            if(!visited[next]){
                D[next] = D[Node] * i.getQ()/i.getP();
                DFS(next);
            }
        }
    }
}

class cNode {
    int b;
    int p;
    int q;
    public cNode(int b, int p, int q) {
        super();
        this.b = b;
        this.p = p;
        this.q = q;
    }
    public int getB() {
        return b;
    }
    public int getP() {
        return p;
    }
    public int getQ() {
        return q;
    }
}