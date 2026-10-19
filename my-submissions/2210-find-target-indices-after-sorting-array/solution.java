class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessThanTarget = 0;
        int targetCount = 0;

        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i ++){
            if (nums[i] < target){
                lessThanTarget++;

            }
            else if(nums[i] == target){
                targetCount++;
            } 
        }
        for(int j = 0; j < targetCount; j++){
            res.add(lessThanTarget + j);
        }
        return res;
    }
}
