public class MaximumSubarray {
    public void display() {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

    }

    public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length+1];

            int max =0;
            dp[0] = nums[0];
            max = dp[0];
            for (int i=1;i<nums.length;i++) {
                dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
                if(dp[i] > max)
                    max = dp[i];
            }

            return max;
    }

}
