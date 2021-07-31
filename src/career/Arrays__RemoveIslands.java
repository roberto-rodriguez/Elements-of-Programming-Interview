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
public class Arrays__RemoveIslands {

    public static void main(String[] args) {
//        int[][] image = {
//            {1, 0, 0, 0, 0, 0},
//            {0, 1, 0, 1, 1, 1},
//            {0, 0, 1, 0, 1, 0},
//            {1, 1, 0, 0, 1, 0},
//            {1, 0, 1, 1, 0, 0},
//            {1, 0, 0, 0, 0, 1}
//        };
        int[][] image = {
            {1, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 0},
            {0, 1, 1, 0, 1, 0},
            {0, 1, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 1}
        };

        removeIslands(image);

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

    private static int[][] removeIslands(int[][] image) {

        if (image.length > 2) {
            for (int i = 1; i < image.length; i++) {
                for (int j = 1; j < image[i].length; j++) {
                    if (image[i - 1][j] == 0 && image[i][j - 1] == 0) {
                        List<Point> listToRemove = new ArrayList<>();

                        boolean touchBorder = touchBorder(i, j, image, listToRemove, i, j);

                        if (!touchBorder) {
//                            System.out.println("canRemove " + "[" + i + ", " + j + "] -> " + listToRemove.stream().map(Point::toString).collect(Collectors.joining(", ")));
                            for (Point pointToRemove : listToRemove) {
                                System.out.println("Removing: (" + pointToRemove.getX() + ", " + pointToRemove.getY() + ")");
                                image[pointToRemove.getX()][pointToRemove.getY()] = 0;
                            }
                        }
                    }
                }
            }
        }

        return image;
    }

    private static boolean touchBorder(int x, int y, int[][] image, List<Point> listToRemove, int startX, int startY) {
        boolean isBorder = x == 0 || y == 0 || x == image[x].length - 1 || y == image.length - 1;

        if (isBorder) {
            return image[x][y] == 1;
        } else {

            boolean canRemove = image[x][y] == 1;
            if (canRemove) {

                if (x == startX) {
                    if (image[startX - 1][y] == 1) {
                        System.out.println("Found top border at (" + x + ", " + y + " )");
                        return true;
                    }
                }
                if (y == startY) {
                    if (image[x][startY - 1] == 1) {
                        System.out.println("Found left border at (" + x + ", " + y + " )");
                        return true;
                    }
                }

                boolean touchBorderToRight = touchBorder(x + 1, y, image, listToRemove, startX, startY);
                boolean touchBorderToBottom = touchBorder(x, y + 1, image, listToRemove, startX, startY);

                if (touchBorderToRight || touchBorderToBottom) {
                    return true;
                } else {
                    listToRemove.add(new Point(x, y));
                }
            }
            return false; //I'm 0 and didn't touch the border

        }
    }
}

class Point {

    private int x, y;

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
