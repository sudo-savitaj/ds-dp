public class MinCoinChange {
    public void display() {
        int[] cents = {15,1};
        int sum = 4;

        long count = minCoins(cents, cents.length, sum);
        System.out.println(count);
        count = minCoinsDp(cents, cents.length, sum);
        System.out.println(count);
    }

    private int minCoinsDp(int coins[], int n, int sum) {
        int[][] t = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {

                if (j == 0) {
                    t[i][j] = 0;
                    continue;
                }
                if (i == 0) {
                    t[i][j] = Integer.MAX_VALUE;
                    continue;
                }

                if (coins[i - 1] > j) t[i][j] = t[i - 1][j];
                else {

                        int subRes = t[i][j - coins[i - 1]];
                        if(subRes != Integer.MAX_VALUE)
                            subRes ++;

                        t[i][j] = Integer.min(subRes, t[i - 1][j]);

                }
            }
        }


        return t[n][sum] == Integer.MAX_VALUE ? -1 :t[n][sum] ;
    }

    int minCoins(int coins[], int n, int sum) {
        if (sum == 0) return 0;
        if (n == 0) return Integer.MAX_VALUE - 1;

        if (coins[n - 1] > sum) return minCoins(coins, n - 1, sum);

        return Integer.min(1 + minCoins(coins, n, sum - coins[n - 1]), minCoins(coins, n - 1, sum));
    }
}
