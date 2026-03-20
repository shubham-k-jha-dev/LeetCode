import java.util.*;

class Solution {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] freq = new int[n*n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                freq[grid[i][j]]++;
            }
        }

        int repeat = 0;
        int missing = 0;
        for (int nums = 1; nums <= n*n; nums++) {
            if(freq[nums] == 2){
                repeat = nums;
            }
            if(freq[nums] == 0) {
                missing = nums;
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