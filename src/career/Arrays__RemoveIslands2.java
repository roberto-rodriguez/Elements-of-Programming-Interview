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
public class Arrays__RemoveIslands2 {

    public static void main(String[] args) {
        int[][] image = {
            {1, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 1, 0},
            {1, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 1}
        };
//        int[][] image = {
//            {1, 0, 0, 0, 0, 0},
//            {0, 1, 1, 0, 1, 0},
//            {0, 1, 1, 0, 1, 0},
//            {0, 1, 0, 0, 1, 0},
//            {1, 1, 1, 1, 0, 0},
//            {1, 0, 0, 0, 0, 1}
//        };

        removeIslands(image);

        print(image);
    }

    private static int[][] removeIslands(int[][] image) {

        if (image.length > 2) {
            for (int i = 0; i < image.length; i++) {
                for (int j = 0; j < image[i].length; j++) {

                    List<P> listToRemove = new ArrayList<>();

                    if (image[i][j] == 0) {
                        continue;
                    }

                    P p = new P(i, j);
                    listToRemove.add(p);

                    boolean touchBorder = touchBorder(p, image, listToRemove);
 
                    for (P pointToRemove : listToRemove) {
                        if (touchBorder) {
                            if (image[pointToRemove.row][pointToRemove.column] == -1) {
                                image[pointToRemove.row][pointToRemove.column] = 1;
                            }
                        } else {
                            image[pointToRemove.row][pointToRemove.column] = 0;
                        }
                    }
                }
            }
        }

        return image;
    }

    private static boolean touchBorder(P p, int[][] image, List<P> listToRemove) {

        boolean isBorder = p.row == 0 || p.column == 0 || p.column == image[p.row].length - 1 || p.row == image.length - 1;

        if (isBorder) {
            return image[p.row][p.column] == 1;
        } else {
            boolean touchBorder = false;

            if (image[p.row][p.column] == 1) {
                image[p.row][p.column] = -1;

                List<P> options = listOptions(image, p);

                for (P option : options) {
                    listToRemove.add(option);

                    boolean tb = touchBorder(option, image, listToRemove);

                    touchBorder = touchBorder || tb;
                }
            }

            return touchBorder; //I'm 0 and didn't touch the border
        }
    }

    private static List<P> listOptions(int[][] maze, P coordinate) {
        int row = coordinate.row;
        int column = coordinate.column;

        List<P> options = new ArrayList<>();

        //up
        if (row > 0 && maze[row - 1][column] > 0) {
            options.add(new P(row - 1, column));
        }
        //right
        if (column < maze[row].length - 1 && maze[row][column + 1] > 0) {
            options.add(new P(row, column + 1));
        }
        //down
        if (row < maze.length - 1 && maze[row + 1][column] > 0) {
            options.add(new P(row + 1, column));
        }
        //left
        if (column > 0 && maze[row][column - 1] > 0) {
            options.add(new P(row, column - 1));
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

    private static void print(int[][] image) {
        System.out.println("[");
        for (int i = 0; i < image.length; i++) {
            System.out.print("   [");
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + ", ");
            }
            System.out.println("],");
        }
        System.out.print("]");
    }
}

class P {

    public int row, column;

    @Override
    public String toString() {
        return "[" + row + "," + column + "]"; //To change body of generated methods, choose Tools | Templates.
    }

    public P(int row, int column) {
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
