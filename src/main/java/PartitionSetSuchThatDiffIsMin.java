import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitionSetSuchThatDiffIsMin {
    public void display() {
        int[] set = {1, 6, 11, 5};

//        int minDiff = minDiffernce(set, 2);
        int minDiff = minDiffernceBottomUp(set, 4);

        System.out.println(minDiff);

    }

    int minDiffernce(int arr[], int n) {
        int sum = getSum(arr, n);
        int halfSum = sum / 2;

        int minDiff = recursive(arr, n, halfSum);
        int fullFilledSum = halfSum - minDiff;
        int remainSum = sum - fullFilledSum;
        return remainSum - fullFilledSum;
    }

    private int recursive(int[] arr, int n, int sum) {
        if (n == 0) return sum;

        if (arr[n - 1] > sum) return recursive(arr, n - 1, sum);

        int diffWithNthItem = recursive(arr, n - 1, sum - arr[n - 1]);
        int diffWithOutNthItem = recursive(arr, n - 1, sum);

        return diffWithNthItem < diffWithOutNthItem ? diffWithNthItem : diffWithOutNthItem;
    }

    int minDiffernceBottomUp(int arr[], int n) {
        int sum = getSum(arr, n);
        boolean[][] cache = new boolean[n + 1][sum + 1];

        List<Integer> vector = new ArrayList<Integer>();

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    cache[i][j] = true;
                    continue;
                } else if (i == 0) {
                    cache[i][j] = false;
                    continue;
                }

                if(arr[i-1]>j){
                    cache[i][j] = cache[i-1][j];
                } else {
                    cache[i][j] = cache[i-1][j-arr[i-1]] || cache[i-1][j];;
                }

            }
        }

       int k=0;
        while(k<= sum/2){
                if (cache[n][k]) vector.add(k);
                k++;
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i< vector.size() ;i++){
            Integer element = vector.get(i);
            if(min > sum - (2* element)) min = sum - (2* element);
        }

        return min;
    }


    private int getSum(int[] arr, int n) {
        if (n == 0) return 0;
        return arr[n - 1] + getSum(arr, n - 1);
    }
}
