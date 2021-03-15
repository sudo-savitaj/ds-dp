public class TrappingRainWater {
    public void display() {
        int[] heights = {4,2,0,3,2,5};
        int collectedWater = trapDp(heights);

        System.out.println(collectedWater);
    }

    public int trap(int[] heights) {
        int collectedWater = 0;
        for (int i = 0; i < heights.length - 1; i++) {
            int leftMax = heights[i];
            int rightMax = heights[i];
            for (int j = 0; j < i; j++) {
                if (leftMax < heights[j]) leftMax = heights[j];
            }

            for (int k = i + 1; k < heights.length; k++) {
                if (rightMax < heights[k]) rightMax = heights[k];
            }

            collectedWater+= Integer.min(leftMax,rightMax) - heights[i];
        }
        return collectedWater;
    }

    public int trapDp(int[] heights) {
        if(heights.length<=0)return 0;

        int[] leftMax = new int[heights.length];
        leftMax[0] = heights[0];

        for (int i=1;i<heights.length;i++) leftMax[i] = Integer.max(heights[i],leftMax[i-1]);

        int[] rightMax = new int[heights.length];
        rightMax[heights.length-1] = heights[heights.length-1];
        for (int i=heights.length-2;i>=0;i--) rightMax[i] = Integer.max(heights[i],rightMax[i+1]);

        int collectedWater =0;
        for (int i=1;i<heights.length-1;i++)
            collectedWater += Integer.min(leftMax[i],rightMax[i]) - heights[i];

        return collectedWater;
    }
}
