package _8_2_RobotGrid;

import java.util.ArrayList;
import java.util.HashSet;

public class App {

    static class Point {

        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return row + ", " + col;
        }

    }

    public static ArrayList<Point> getPath(boolean[][] maze) {

        if (maze == null || maze.length == 0) return null;

        ArrayList<Point> path = new ArrayList<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
            return path;
        }
        return null;
    }

    public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {

        System.out.println(row + ", " + col);

        //base case FAIL
        // out of bounds or not a square we can step on
        if (row < 0 || col < 0 || !maze[row][col]) {
            return false;
        }

        // base case SUCCESS
        // we've worked backwards to top left square (the "start")
        boolean isAtOrigin = row == 00 && col == 0;

        // if there's a path from the start (end?) to here, add current location
        if (isAtOrigin ||
                getPath(maze, row, col - 1, path) ||
                getPath(maze, row - 1, col, path)) {
            Point p = new Point(row, col);
            System.out.println("Point = " + p);
            path.add(p);
            return true;
        }
        return false;
    }

    //dynamic solution -- remember 'failed' squares we've already visited before
    public static ArrayList<Point> getPathDynamic(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if (getPathDynamic(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    private static boolean getPathDynamic(boolean[][] maze, int row, int col,
                                          ArrayList<Point> path, HashSet<Point> failedPoints) {

        if (row < 0 || col < 0 || !maze[row][col]) {
            return false;
        }

        Point p = new Point(row, col);

        if (failedPoints.contains(p)) {
            return false;
        }

        boolean isAtOrigin = row == 0 && col == 0;

        if (isAtOrigin ||
                getPathDynamic(maze, row, col-1, path, failedPoints) ||
                getPathDynamic(maze, row-1, col, path, failedPoints)) {
            path.add(p);
            return true;
        }
        failedPoints.add(p);
        return false;
    }


    public static void main(String[] args) {

        boolean[][] maze = {
                {true, true, true, true},
                {true, false, true, true},
                {true, true, false, true},
                {true, true, true, true}
            };

//        ArrayList<Point> path = getPath(maze);
        ArrayList<Point> path = getPathDynamic(maze);
        for (Point p : path) {
            System.out.print(p + " --> ");
        }

    }

}
