class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), nums, 0);
        return result;

    }

    private void backTrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start){
        
        result.add(new ArrayList<>(current));
        
            
        for(int i = start; i < nums.length; i ++){
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }

            current.add(nums[i]);

            backTrack(result, current, nums, i + 1);
            
            current.remove(current.size() - 1);   
        }
    }
}
