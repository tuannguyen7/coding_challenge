package leetcode;

public class Problem63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0)
            return 0;
        if (obstacleGrid[0].length == 0)
            return 1;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // init
        for (int i = 0; i < dp[0].length; i++) {
            if (obstacleGrid[0][i] == 0)
                dp[0][i] = i == 0 ? 1 : dp[0][i - 1];
            else
                dp[0][i] = 0;
        }

        for (int i = 0; i < dp.length; i++) {
            if (obstacleGrid[i][0] == 0)
                dp[i][0] = i == 0 ? 1 : dp[i - 1][0];
            else
                dp[i][0] = 0;
        }

        // DP step
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        // remove
        return dp[dp.length - 1][dp[0].length - 1];

    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{}};
        System.out.println(new Problem63().uniquePathsWithObstacles(obstacleGrid));
    }
}
