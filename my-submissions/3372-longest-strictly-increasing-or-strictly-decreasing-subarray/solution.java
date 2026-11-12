class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        
        int maxIncreasing = 1;
        int maxDecreasing = 1;
        int currentIncreasing = 1;
        int currentDecreasing = 1;


        int prev = nums[0];

        for (int i = 0 ; i < nums.length; i ++){

            if(nums[i] < prev){
                currentIncreasing = 1;
                currentDecreasing ++;
                maxDecreasing = Math.max(maxDecreasing,currentDecreasing);
            }
            if(nums[i] > prev){
                currentDecreasing = 1;
                currentIncreasing ++;
                maxIncreasing = Math.max(maxIncreasing,currentIncreasing);
            }
            if(nums[i] == prev){
                currentDecreasing = 1;
                currentIncreasing = 1;
            }
            prev = nums[i];
        }
    return Math.max(maxIncreasing, maxDecreasing);
    }
}
