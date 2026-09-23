class Solution {
    public int[] sortedSquares(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int pointer=nums.length-1;
        int[] ans=new int[nums.length];
        while(left<=right){
            int sqrtleft=nums[left]*nums[left];
            int sqrtrght=nums[right]*nums[right];
            if(sqrtleft<=sqrtrght){
                ans[pointer]=sqrtrght;
                right--;
            }
            else{
                ans[pointer]=sqrtleft;
                left++;
            }
            pointer--;
        }
        return ans;
    }
}