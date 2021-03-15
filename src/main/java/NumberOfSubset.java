public class NumberOfSubset {
    public void display() {
        int[] set = {2, 3, 5, 6, 8, 10};

        int count = countSubsetSum(set, 6, 10);
        System.out.println(count);

        count = countSubsetSumBottomUp(set, 6, 10);
        System.out.println(count);
    }

    int countSubsetSum(int set[], int n, int sum) {
        if (sum == 0) return 1;
        if (n == 0) return 0;

        if (set[n - 1] > sum) return countSubsetSum(set, n - 1, sum);
        return countSubsetSum(set, n - 1, sum - set[n - 1]) + countSubsetSum(set, n - 1, sum);
    }

    int countSubsetSumBottomUp(int set[], int n, int sum) {
        int[][] cache = new int[n + 1][sum + 1];

        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <= sum ; j++) {
                if (j == 0) {
                    cache[i][j] = 1;
                    continue;
                } else if(i==0) {
                    cache[i][j] = 0;
                    continue;
                }

                if(set[i-1] > j){
                    cache[i][j] = cache[i-1][j];
                } else {
                    cache[i][j] = cache[i-1][j-set[i-1]] + cache[i-1][j];
                }
            }
        }
        return cache[n][sum];
    }
}
