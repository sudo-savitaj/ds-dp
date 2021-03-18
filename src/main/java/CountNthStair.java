//https://practice.geeksforgeeks.org/problems/count-ways-to-nth-stairorder-does-not-matter5639/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&company[]=Amazon&company[]=Amazon&problemType=functional&page=1&query=category[]Dynamic%20Programmingcompany[]AmazonproblemTypefunctionalpage1company[]Amazoncategory[]Dynamic%20Programming
public class CountNthStair {
    public void display() {
        long count =nthStair(24);
        long countDp =nthStairDP(24);

        System.out.println(count);
        System.out.println(countDp);
    }
    public long nthStair(int n)
    {
        if(n<=1) return n;

        return nthStair(n-1)+nthStair(n-2);
    }

    public long nthStairDP(int n)
    {
        int[] cache = new int[n+1];

        cache[0] =0;
        cache[1] =1;
        for (int i=2;i<=n;i++){
            cache[i] = cache[i-1]+cache[i-2];
        }

        return cache[n];
    }

}
