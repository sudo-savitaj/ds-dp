//https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&company[]=Amazon&company[]=Amazon&problemType=functional&page=1&query=category[]Dynamic%20Programmingcompany[]AmazonproblemTypefunctionalpage1company[]Amazoncategory[]Dynamic%20Programming
import java.util.Arrays;

public class Knapsack {
    static int[][] cache = new int[1001][1001];

    Knapsack() {
        for (int[] list : cache) {
            Arrays.fill(list, -1);
        }
    }

    public void display() {
        int n = 3;
        int W = 4;
        int[] values = {1,2,3};
        int[] weight = {4,5,1};


        int profit = knapSack(W, weight, values, n);
        System.out.println(profit);

        profit = bottomUpDP(W, weight, values);
        System.out.println(profit);

    }

    static int knapSack(int W, int wt[], int val[], int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (cache[n][W] != -1) return cache[n][W];
        if (wt[n - 1] > W) {
            cache[n][W] = knapSack(W, wt, val, n - 1);
            return cache[n][W];
        }
        cache[n][W] = Math.max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), knapSack(W, wt, val, n - 1));
        return cache[n][W];
    }

    static int knapSackTopDown(int W, int wt[], int val[], int n) {
        initializeCache(n, W);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {

            }
        }
        return cache[n][W];
    }

    private static void initializeCache(int n, int w) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) cache[i][j] = 0;
            }
        }
    }

    public int bottomUpDP(int W, int wt[], int val[]) {
        int[][] t = new int[wt.length+1][W+1];

        for(int i=0;i<=wt.length;i++){
            for (int j=0;j<=W;j++){
                if(i==0||j==0){
                    t[i][j] = 0;
                    continue;
                }

                if(wt[i-1] <= j){
                    t[i][j] = Math.max(val[i-1] + t[i-1][j - wt[i-1]], t[i-1][j]);
                } else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[wt.length][W];
    }


}
