
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author 17864
 */
public class Graph__Maze {

    private static int[][] maze = {
        {0, 1, 1, 1, 1, 1, 0, 0, 1, 1},
        {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
        {0, 1, 0, 1, 1, 0, 0, 1, 0, 0},
        {1, 1, 1, 0, 0, 0, 1, 0, 0, 1},
        {1, 0, 0, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 1, 1, 0, 1, 0, 0, 1},
        {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
        {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
        {0, 1, 0, 0, 1, 1, 1, 0, 0, 0},
        {1, 1, 1, 1, 1, 1, 1, 0, 0, 1}
    };

    public static void main(String[] args) {
        Coordinate start = new Coordinate(9, 0);
        Coordinate end = new Coordinate(0, 9);

        List<Coordinate> path = new ArrayList<>();
        path.add(start);

        System.out.println(existPath(maze, start, end, path));

        for (Coordinate p : path) {
            maze[p.row][p.column] = 5;
        }
        System.out.println(path);
        System.out.println("");

        for (int i = 0; i < maze.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + ", ");
            }
            System.out.println(" ],");
        }
    }

    private static boolean existPath(int[][] maze, Coordinate current, Coordinate end, List<Coordinate> path) {
        List<Coordinate> options = listOptions(maze, current);

        if (current.equals(end)) {
            return true;
        }

        for (Coordinate option : options) {
            path.add(option);

            maze[option.row][option.column] = 0;

            if (existPath(maze, option, end, path)) {
                return true;
            } else {
                path.remove(path.size() - 1);
            }
        }

        return false;
    }

    private static List<Coordinate> listOptions(int[][] maze, Coordinate coordinate) {
        int row = coordinate.row;
        int column = coordinate.column;

        List<Coordinate> options = new ArrayList<>();

        //up
        if (row > 0 && maze[row - 1][column] > 0) {
            options.add(new Coordinate(row - 1, column));
        }
        //right
        if (column < maze[row].length - 1 && maze[row][column + 1] > 0) {
            options.add(new Coordinate(row, column + 1));
        }
        //down
        if (row < maze.length - 1 && maze[row + 1][column] > 0) {
            options.add(new Coordinate(row + 1, column));
        }
        //left
        if (column > 0 && maze[row][column - 1] > 0) {
            options.add(new Coordinate(row, column - 1));
        }

        return options;
    }

    private boolean isFeasible(int[][] maze, Coordinate coordinate) {
        int x = coordinate.row;
        int y = coordinate.column;

        return x >= 0 && x < maze.length
                && y >= 0 && y < maze[x].length
                && maze[x][y] == 1;
    }
}

class Coordinate {

    public int row, column;

    @Override
    public String toString() {
        return "[" + row + "," + column + "]"; //To change body of generated methods, choose Tools | Templates.
    }

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Coordinate) {
            Coordinate other = (Coordinate) obj;

            return row == other.row && column == other.column;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
