class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>(); 
        backtrack(candidates, result, new ArrayList<>(), 0 , target );
        return result;  
        
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, int start, int remain){
        
        if (remain == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        if(remain < 0  ){
            return;
        }

        for(int i = start; i < nums.length; i++  ){
              
            current.add(nums[i]);

            backtrack(nums, result, current, i, remain - nums[i] );

            current.remove(current.size() - 1 );

        }
        

    }
}
