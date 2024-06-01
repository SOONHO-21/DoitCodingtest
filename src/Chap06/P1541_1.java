package Chap06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1541_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.MAX_VALUE;
        String modification = br.readLine();
        String[] subTraction = modification.split("-");
        for(int i=0; i<subTraction.length; i++){
            String[] tempModification = subTraction[i].split("\\+");
            int tempSum = 0;
            for(int j=0; j<tempModification.length; j++){
                tempSum += Integer.parseInt(tempModification[i]);
            }
            if(i == Integer.MAX_VALUE)
                sum = tempSum;
            else
                sum -= tempSum;
        }
        System.out.println(sum);
    }
}
