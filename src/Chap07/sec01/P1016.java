package Chap07.sec01;

import java.util.Scanner;

public class P1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Min = sc.nextInt();
        int Max = sc.nextInt();
        boolean[] Check = new boolean[Max-Min+1];
        for(int i=2; i<=Max; i++){
            int pow = i*i;
            int start_index = Min/pow;
            if(Min%pow != 0) start_index++;
            for(int j=start_index; j<Max; j++){
                if(j*pow < Max) Check[j*pow - Min] = true;
            }
        }
        int count = 0;
        for(int i=0; i<Check.length; i++){
            if(!Check[i]) count++;
        }
        System.out.println(count);
    }
}