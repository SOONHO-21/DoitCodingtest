package Chap10;

import javax.management.DynamicMBean;
import java.util.Scanner;

public class P1010 {
    public static void main(String[] args){
        int[][] D = new int[31][31];
        for(int i=1; i<=30; i++){
            D[i][0] = 1;
            D[i][i] = 1;
            D[i][1] = i;
        }
        for(int i=2; i<=30; i++){
            for(int j=1; j<=i; j++){
                D[i][j] = D[i-1][j-1] + D[i-1][j];
            }
        }
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        for(int i=0; i<Q; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(D[n][m]);
        }
    }
}