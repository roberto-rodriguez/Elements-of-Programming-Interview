/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

/**
 *
 * @author 17864
 */
public class Search__SquareRoot {
    
    public static void main(String[] args) {
        System.out.println(square(24));
    }
    
    public static int square(int n) {
        int start = 0, end = n, middle = 0;
        
        while (start <= end) {
            middle = start + ((end - start) / 2);
            
            if (middle * middle > n) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return start - 1;
    }
}
