public class RodCutting {
    public void display() {
        int[] price = {3, 5, 8, 9, 10, 17, 17, 20};

        int maxProfit = cutRod(price,8);
        System.out.println(maxProfit);

    }

    int cutRod(int price[], int length) {
        int[] lengthArray = new int[length];
        for (int i=1;i<=length;i++) lengthArray[i-1] = i;

        return cutRod(price,lengthArray, length,price.length);
    }

    private int cutRod(int[] price,int[] lenthArray, int length,int n) {
        if (n <= 0) return 0;

        if(lenthArray[n-1] > length)
            return cutRod(price,lenthArray,length,n-1);
        return Integer.max(price[n - 1] + cutRod(price,  lenthArray,length-lenthArray[n-1],n), cutRod(price, lenthArray,length ,n- 1));
    }
}
