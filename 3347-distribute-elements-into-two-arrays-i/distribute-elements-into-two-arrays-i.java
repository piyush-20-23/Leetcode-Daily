class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        int lastAddedArr1 = nums[0];
        int lastAddedArr2 = nums[1];

        arr1.add(lastAddedArr1);
        arr2.add(lastAddedArr2);

        for(int i = 2; i < nums.length; i ++){
            int ele = nums[i];
            if (lastAddedArr1 > lastAddedArr2){
                arr1.add(ele);
                lastAddedArr1 = ele;
            }
            else{
                arr2.add(ele);
                lastAddedArr2 = ele;
            }
        }

        int[] result = new int[arr1.size() + arr2.size()];
        for(int i = 0; i < result.length; i ++){
            if(i < arr1.size()){
                result[i] = arr1.get(i);
            }
            else{
                result[i] = arr2.get(i - arr1.size());
            }
        }

        return result;
    }
}