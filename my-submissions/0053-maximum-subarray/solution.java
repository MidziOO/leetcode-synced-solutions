class Solution {
    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++ ){
            
            if(nums[i] > current + nums[i]){
                current = nums[i];   
            }
            else{
                current = current + nums[i];
            }
            if(current > maxSum){
                maxSum = current;
            }        
        }
        return maxSum;
    }
}
