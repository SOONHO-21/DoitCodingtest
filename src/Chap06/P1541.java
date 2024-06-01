package Chap06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.MAX_VALUE;

        String[] subTraction = bufferedReader.readLine().split("-");

        for(int i=0; i<subTraction.length; i++){
            String[] addition = subTraction[i].split("\\+");
            int temp = 0;
            for(int j=0; j<addition[j].length(); j++){
                temp += Integer.parseInt(addition[j]);      //addition[j]안에 n+m이 계산되어
                                                            //temp에 반영된다
            }

            // 첫 번째토큰인 경우 temp값이 첫 번째 수가 됨
            if(sum == Integer.MAX_VALUE){
                sum = temp;
            } else {
                sum -= temp;    //+로 괄호로 묶여서 temp가 된 후에는 100% 부호가 -이기 때문이다
            }
        }
        System.out.println(sum);
    }
}