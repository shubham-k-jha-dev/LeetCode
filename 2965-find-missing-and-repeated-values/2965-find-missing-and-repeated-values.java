import java.util.*;

class Solution {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int repeat = 0;
        int missing = 0;
        int n = grid.length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int current = grid[i][j];
                int count = 0;
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < grid[x].length; y++) {
                        if (grid[x][y] == current) {
                            count++;
                        }
                    }
                }

                if (count == 2) {
                    repeat = current;
                }
            }
        }

        int total = n * n;

        for (int num = 1; num <= total; num++) {
            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == num) {
                        count++;
                    }
                }
            }

            if (count == 0) {
                missing = num;
            }
        }

        return new int[]{repeat, missing};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int[] ans = findMissingAndRepeatedValues(grid);
        System.out.println(Arrays.toString(ans));
    }
}