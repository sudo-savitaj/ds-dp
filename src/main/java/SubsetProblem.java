import java.util.ArrayList;

public class SubsetProblem {
    public void display() {
        int[] set = {3, 34, 4, 12, 5, 2};

        boolean result = isSubsetSumRecursive(set,6,11);
        System.out.println(result);

        result = isSubsetSum(set,6,11);
        System.out.println(result);

        result = isSubsetSumBottomUp(set,6,11);
        System.out.println(result);

        int[] input = {1, 3, 5};
        int isPartitionPossible = equalPartition(input);
        System.out.println(isPartitionPossible);
    }

    boolean isSubsetSumRecursive(int set[], int n, int sum){
        if(sum == 0) return true;
        if(n == 0) return false;
        return isSubsetSumRecursive(set,n-1,sum - set[n-1]) || isSubsetSumRecursive(set,n-1,sum );
    }

    boolean isSubsetSum(int set[], int n, int sum){
        return backtrack(set,new ArrayList<Integer>(),sum);

    }
    private boolean backtrack(int[] set, ArrayList<Integer> integers, int sum) {
        if(sum == 0){
            return true;
        }

        for (int item : set) {
            if(!integers.contains(item)){
                integers.add(item);
                boolean result = backtrack(set,integers,sum-item);
                if (result) return result;
                else integers.remove(integers.size() -1);
            }
        }

        return false;
    }

    boolean isSubsetSumBottomUp(int set[], int n, int sum){
        boolean[][] cache = new boolean[n+1][sum+1];
        for (int i=0;i<=n;i++){
            for (int j=0;j<=sum;j++){
                if(j==0){
                    cache[i][j]=true;
                    continue;
                } else if(i==0){
                    cache[i][j]= false;
                    continue;
                }

                if(set[i-1] <= j) cache[i][j] = cache[i-1][j-set[i-1]] || cache[i-1][j];
                else cache[i][j] = cache[i-1][j];
            }
        }
        return cache[n][sum];
    }

    int equalPartition(int arr[])
    {
        int N = arr.length;
        int sum = getSum(N,arr);

        if(sum%2 != 0) return  0;
        else return isSubsetSumBottomUp(arr,N,sum/2) == true ? 1 :0;
    }

    private int getSumRecursive(int n, int[] arr) {
        if(n == 0) return 0;
        return arr[n-1] + getSum(n-1,arr);
    }

    private int getSum(int n, int[] arr) {
        if(n == 0) return 0;
        int sum=0;
        for (int item : arr) {
            sum+=item;
        }
        return sum;
    }

}
