package BackTracking.DynamicProg;

public class RatInAMaze {
    private static void findPaths(int[][] grid, int n, int i, int j, String op, boolean[][] visited) {
        if (i == n - 1 && j == n - 1) {
            System.out.println(op);
            return;
        }
        visited[i][j] = true;
        if (isItSafe(grid, n, i, j + 1, visited))
            findPaths(grid, n, i, j + 1, op + "R", visited);
        if (isItSafe(grid, n, i + 1, j, visited))
            findPaths(grid, n, i + 1, j, op + "D", visited);
        visited[i][j] = false;
    }
    private static int findPathsCount(int n, int i, int j, boolean[][] visited) {
        if (i == n - 1 && j == n - 1) {
            return 1;
        }
        if(i >= n || j >= n ) return 0;
        return findPathsCount(n, i, j + 1, visited) + findPathsCount(n, i+1, j, visited);
    }

    private static boolean isItSafe(int[][] grid, int n, int i, int j, boolean[][] visited) {
        return (i < n && j < n && !visited[i][j] && grid[i][j] != 1);
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] grid = {{0, 0, 1},
                        {0, 0, 0},
                        {0, 0, 0}};
        boolean[][] visited = new boolean[n][n];
        //findPaths(grid, n, 0, 0, "", visited);
        System.out.println(findPathsCount(n, 0, 0, visited));
    }
}
