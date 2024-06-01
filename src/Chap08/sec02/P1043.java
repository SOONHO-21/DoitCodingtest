package Chap08.sec02;

import java.util.ArrayList;
import java.util.Scanner;

public class P1043 {
    static int[] trueP;
    static ArrayList<Integer>[] party;
    static int[] parent;
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        if(T==0) {
            System.out.println(M);
            return;
        }
        trueP = new int[T+1];
        for(int i=1; i<=T; i++){
            trueP[i] = sc.nextInt();
        }
        party = new ArrayList[M+1];
        for(int i=1; i<=M; i++){
            party[i] = new ArrayList<Integer>();
        }
        for(int i=1; i<=M; i++){
            int party_size = sc.nextInt();
            for(int j=1; j<=party_size; j++){
                party[i].add(sc.nextInt());
            }
        }
        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }
        for(int i=1; i<=M; i++) {
            int firstPerson = party[i].get(0);
            for(int j=1; j<party[i].size(); j++) {
                union(firstPerson, party[i].get(j));
            }
        }
        int result = 0;
        for(int i=1; i<=M; i++) {
            boolean isPossible = true;
            int cur = party[i].get(0);
            for(int j=1; j<party[i].size(); j++){
                if(find(cur) == find(trueP[j])){
                    isPossible = false;
                    break;
                }
                if(isPossible) result++;
            }
        }
        System.out.println(result);
    }
    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b)
            parent[b] = a;
    }
    private static int find(int a){
        if(a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }
}