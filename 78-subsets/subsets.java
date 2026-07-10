class Solution {
    List<List<Integer>> output = new ArrayList<>();
    public void backtrack(int index, List<Integer> curr, int[] nums){
        if(index == nums.length){
            output.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        backtrack(index + 1, curr, nums);
        curr.remove(curr.size() - 1);
        backtrack(index + 1, curr, nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        backtrack(0, curr, nums);
        return output;
    }
}