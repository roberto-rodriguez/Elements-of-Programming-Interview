/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import career.Coordinate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 17864
 */
public class DynamicProgramming__NumberOfWaysToTraverse_2D_Array {

    public static void main(String[] args) {
       calc(5); 
    }

    public static int calc(int size) {
        int[][] matrix = new int[size][size];
    
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }

        int result = traverse(matrix, new Coordinate(0, 0));
        System.out.println(size + " -> " + result);
        return result;
    }

    public static int traverse(int[][] matrix, Coordinate origin) {
        if (origin.row == matrix.length - 1 && origin.column  == matrix[origin.row].length - 1) {
            return 1;
        }

        if (matrix[origin.row][origin.column] != 0) {
            return matrix[origin.row][origin.column];
        }

        int n = 0;

        List<Coordinate> options = options(matrix, origin);

        for (Coordinate option : options) {
            n += traverse(matrix, option);
        }

        return n;
    }

    public static List<Coordinate> options(int[][] matrix, Coordinate origin) {
        List<Coordinate> options = new ArrayList<>();
        //right
        if (origin.column < matrix[origin.row].length - 1) {
            options.add(new Coordinate(origin.row, origin.column + 1));
        }
        //down
        if (origin.row < matrix.length - 1) {
            options.add(new Coordinate(origin.row + 1, origin.column));
        }

        return options;
    }
}
