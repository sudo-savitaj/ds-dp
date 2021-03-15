public class MatrixMultiplication {
    int[][] cache = new int[100][100];
    int n = 100;

    void setup() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cache[i][j] = -1;
            }
        }
    }

    public void display() {
        int[] arr = {40, 20, 30, 10, 30};
        int result = matrixMultiplication(5,arr);

        System.out.println(result);
    }

    int matrixMultiplication(int N, int arr[])
    {
        setup();
        return MatrixChainOrder(arr,1,N-1);
    }

    int MatrixChainOrder(int p[], int i, int j) {
        if (i >= j) return 0;
        int min = Integer.MAX_VALUE;

        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        for (int k = i; k < j; k++) {
            int numberOfMul = MatrixChainOrder(p, i, k)
                    + (p[i - 1] * p[k] * p[j])
                    + MatrixChainOrder(p, k + 1, j);
            if (numberOfMul < min) {
                min = numberOfMul;
            }
        }
        cache[i][j] = min;
        return cache[i][j];
    }
}
