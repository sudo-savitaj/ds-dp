//https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11
public class NumberOfSubsetWithDiff {
    public void display() {
        int[] set = {1, 1, 2, 3};
        int count = countOfSubsetWithDiff(set, 1);

        System.out.println(count);
    }

    int countOfSubsetWithDiff(int[] set, int diff){
        int n=set.length;
            int sum = getSum(set,n);

            if(sum<diff) return 0;
            int s1Sum = (sum+diff)/2;

            int[][] cache = new int[n+1][s1Sum+1];
            for (int i=0;i<=n;i++){
                for(int j=0;j<=s1Sum;j++){
                    if(j==0){ cache[i][j] =1; continue;}
                    else if(i==0){cache[i][j]=0;continue;}

                    if(set[i-1] > j) cache[i][j] = cache[i-1][j];
                    else cache[i][j] = cache[i-1][j-set[i-1]] + cache[i-1][j];
                }
            }
        return cache[n][s1Sum];
    }

    private int getSum(int[] arr, int n) {
        if (n == 0) return 0;
        return arr[n - 1] + getSum(arr, n - 1);
    }
}
