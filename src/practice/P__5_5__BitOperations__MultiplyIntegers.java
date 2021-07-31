/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author 17864
 */
public class P__5_5__BitOperations__MultiplyIntegers {
    
    
    public static void main(String[] args) {
        System.out.println(multiply(13, 10));
    }
    
    public static int multiply(int a, int b){
        int sum = 0;
        
        while(a > 0){
            if((a & 1) == 1){
                sum += b;
            }
            a >>>= 1;
            b <<= 1;
        }
        return sum;
    }
}

