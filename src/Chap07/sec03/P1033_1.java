package Chap07.sec03;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class P1033_1 {
    static ArrayList<cNode_1>[] A;
    static long lcm;
    static boolean visited[];
    static long D[];    //각 노드의 값(최대 공약수로 나누기 전)

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        A = new ArrayList[N];   //ArrayList의 배열
        visited = new boolean[N];
        D = new long[N];        //최대 공약수로 나누기 전의 노드의 값
        lcm = 1;
        for(int i=0; i<N; i++){
            A[i] = new ArrayList<cNode_1>();
        }
        for(int i=0; i<N-1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            A[a].add(new cNode_1(b, p, q));
            A[a].add(new cNode_1(a, q, p));
            lcm *= (p * q/gcd(p,q));    //최소 공배수 업데이트
        }
        D[0] = lcm;
        DFS(0);
    }
    public static long gcd(long a, long b){
        if(b==0)
            return a;
        else
            return gcd(b, a%b);
    }
    static void DFS(int Node) {
        visited[Node] = true;
        for(cNode_1 i : A[Node]){
            int next = i.getB();
            if(!visited[next]){
                D[next] = D[Node] * i.getQ() / i.getP();
                DFS(next);
            }
        }
    }
}
class cNode_1 {
    int b;
    int p;
    int q;

    public cNode_1(int b, int p, int q) {
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