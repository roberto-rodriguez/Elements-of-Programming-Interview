/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 17864
 */
public class DynamicProgramming__Search_for_sequence {

    public static void main(String[] args) {
        int[][] grid = {
            {1, 2, 3},
            {3, 4, 5},
            {5, 6, 7}
        };

        int[] pattern = {1, 3, 4, 6};

        System.out.println(existPattern(grid, pattern));
    }

    public static boolean existPattern(int[][] grid, int[] pattern) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == pattern[0]) {
                    if (doesFollowPattern(grid, new Punto(i, j), pattern, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean doesFollowPattern(int[][] grid, Punto p, int[] pattern, int patternIndex) {

        if (patternIndex == pattern.length - 1) {
            return grid[p.row][p.column] == pattern[patternIndex];
        }

        List<Punto> options = options(grid, p, pattern[++patternIndex]);

        for (Punto option : options) {
            if (doesFollowPattern(grid, option, pattern, patternIndex)) {
                return true;
            }
        }
        return false;
    }

    public static List<Punto> options(int[][] grid, Punto p, int nextPoint) {
        List<Punto> options = new ArrayList<>();

        if (p.row > 0 && grid[p.row - 1][p.column] == nextPoint) { //up
            options.add(new Punto(p.row - 1, p.column));
        }
        if (p.column > 0 && grid[p.row][p.column - 1] == nextPoint) { //left
            options.add(new Punto(p.row, p.column - 1));
        }
        if (p.row < grid.length - 1 && grid[p.row + 1][p.column] == nextPoint) { //down
            options.add(new Punto(p.row + 1, p.column));
        }
        if (p.column < grid[p.row].length - 1 && grid[p.row][p.column + 1] == nextPoint) { //right
            options.add(new Punto(p.row, p.column + 1));
        }

        return options;
    }

}

class Punto {

    public int row, column;

    @Override
    public String toString() {
        return "(" + row + ", " + column + ")"; //To change body of generated methods, choose Tools | Templates.
    }

    public Punto(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
