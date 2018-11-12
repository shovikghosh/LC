package nutanix;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] maze = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 1; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        int xstart = sc.nextInt();
        int ystart = sc.nextInt();
        int xend = sc.nextInt();
        int yend = sc.nextInt();
        sc.close();
        if (BFS(maze, xstart, ystart, xend, yend)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }



    }

    static boolean BFS(int[][] maze, int xs,int xy, int tx, int ty) {
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 1) {
                    visited.add(i + ":" + j);
                }
            }
        }
        return BFS(maze, xs, xy, tx, ty);
    }

    static boolean BFS(int[][] maze, int x, int y, int tx, int ty, Set<String> visited) {
        String s = x + ":" + y;
        if (x == tx && y == ty) {
            return true;
        }
        if (visited.contains(s)) {
            return false;
        }
        int[] dir = findBound(maze, x, y);
        boolean r = false;
        r = r || BFS(maze, dir[0], y, tx,ty, visited);
        r = r || BFS(maze, dir[1], y, tx,ty, visited);
        r = r || BFS(maze, x, dir[2], tx,ty, visited);
        r = r || BFS(maze, x, dir[3], tx,ty, visited);
        return r;
    }

    static int[] findBound(int[][] maze, int x, int y) {
        int i = x;
        int j = y;
        int[] res = new int[4];
        res[0] = res[1] = res[2] = res[3] = -1111;
        while (++i < maze.length) {
            if (maze[i][y] == 1) {
                res[0] = i - 1;
                break;
            }
        }

        i = x;
        while (--i > 0) {
            if (maze[i][y] == 1) {
                res[1] = i + 1;
                break;
            }
        }
        while (++j < maze[0].length) {
            if (maze[x][j] == 1) {
                res[2] = j - 1;
                break;
            }
        }
        j = y;
        while (--j > 0) {
            if (maze[x][j] == 1) {
                res[3] = j + 1;
                break;
            }
        }
        return res;
    }
}

