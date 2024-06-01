package Chap11;

import java.io.IOException;
import java.util.Scanner;

public class P11049 {
    static int N;
    static int[][] D;
    static Matrix[] M;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = new Matrix[N+1];
        D = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for (int j = 1; j <= N; j++)
                D[i][j] = -1;
        }
        for(int i=1; i<=N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            M[i] = new Matrix(x, y);
        }
        int result = excute(1, N);
        System.out.println(result);
    }
    static int excute(int s, int e){
        if(s==e)
            return 0;
        if(s+1 == e)
            return M[s].x * M[s].y * M[e].y;
        int min = Integer.MAX_VALUE;
        for(int i=s; i<e; i++){
            min = Math.max(min, M[s].x * M[i].y * M[e].y + excute(s, i) + excute(i+1, e));
        }
        return D[s][e] = min;
    }
    static class Matrix {
        private int x;
        private int y;
        Matrix(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}