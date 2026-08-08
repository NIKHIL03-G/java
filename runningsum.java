class Solution {
    public int[] runningSum(int[] nums) {
        int runningSum=nums[0];
        int[] ptr=new int[nums.length];
        ptr[0]=nums[0];
        for(int i=1; i<nums.length; i++){
            runningSum = runningSum+(nums[i]);
            ptr[i]= runningSum;
        }
        return ptr;
    }
}
