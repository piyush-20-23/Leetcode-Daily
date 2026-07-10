class Solution {
    List<List<Integer>> output = new ArrayList<>();
    int[] candidates;

    public void backtrack(int index, int target, List<Integer> curr){
        if(target < 0) return;
        if(target == 0){
            output.add(new ArrayList(curr));
            return;
        }
        // if(target < 0 || index == candidates.length){
        //     return;
        // }
        // // take condition
        // curr.add(candidates[index]);
        // backtrack(index, target - candidates[index], curr);
        // curr.remove(curr.size() - 1);
        // // leave condition
        // backtrack(index + 1, target, curr);

        for(int i = index; i < candidates.length; i ++){
            curr.add(candidates[i]);
            backtrack(i, target - candidates[i], curr);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;

        backtrack(0, target, new ArrayList<>());
        return output;
    }
}