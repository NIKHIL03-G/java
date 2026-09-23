class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int totalSum = 0;

        // Maximum subarray
        int currentMax = nums[0];
        int maxSum = nums[0];

        // Minimum subarray
        int currentMin = nums[0];
        int minSum = nums[0];

        totalSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // Kadane's algorithm for maximum subarray
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Kadane's algorithm for minimum subarray
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);

            totalSum += num;
        }

        // All numbers are negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Maximum of normal and circular subarray
        int circularSum = totalSum - minSum;

        return Math.max(maxSum, circularSum);
    }
}