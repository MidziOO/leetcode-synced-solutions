class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, result, new ArrayList<>(), used);
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, boolean[] used){

        if(nums.length == current.size()){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < nums.length; i ++){
            if(used[i]) {
                continue;
            }

            if(i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false){
                continue;
            }

            current.add(nums[i]);
            used[i] = true;

            backtrack(nums, result, current, used);

            current.remove(current.size() - 1);
            used[i] = false;
        }

    }
}
