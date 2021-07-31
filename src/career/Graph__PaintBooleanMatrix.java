/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 17864
 */
public class Graph__PaintBooleanMatrix {

    private static int[][] matrix = {
        {0, 1, 0, 1, 1, 1, 0, 0, 0, 0},
        {1, 1, 0, 1, 1, 0, 1, 1, 0, 0},
        {0, 0, 0, 1, 1, 0, 0, 1, 0, 0},
        {1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
        {0, 0, 0, 1, 1, 1, 1, 0, 1, 1},
        {0, 1, 0, 1, 1, 0, 1, 0, 0, 0},
        {1, 1, 1, 1, 0, 1, 0, 1, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
        {0, 1, 0, 0, 1, 1, 1, 0, 0, 0},
        {1, 1, 1, 1, 1, 1, 1, 0, 0, 1}
    };

    public static void main(String[] args) {
        exec(5, 4);
        exec(3, 6);
    }

    public static void exec(int row, int column) {

        draw(matrix, row, column, matrix[row][column]);

        System.out.println("");

        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println(" ],");
        }
    }

    public static void draw(int[][] matrix, int row, int column, int color) {
        matrix[row][column] = color == 0 ? 1 : 0;

        List<Point> options = listOption(matrix, row, column, color);

        for (Point option : options) {
            draw(matrix, (new Double(option.getX())).intValue(), (new Double(option.getY())).intValue(), color);
        }

    }

    public static List<Point> listOption(int[][] matrix, int row, int column, int color) {
        List<Point> options = new ArrayList<>();
        //up
        if (row > 0 && matrix[row - 1][column] == color) {
            options.add(new Point(row - 1, column));
        }
        //left
        if (column > 0 && matrix[row][column - 1] == color) {
            options.add(new Point(row, column - 1));
        }
        //down
        if (row < matrix.length - 1 && matrix[row + 1][column] == color) {
            options.add(new Point(row + 1, column));
        }
        //right
        if (column < matrix[row].length - 1 && matrix[row][column + 1] == color) {
            options.add(new Point(row, column + 1));
        }

        return options;
    } 
}
