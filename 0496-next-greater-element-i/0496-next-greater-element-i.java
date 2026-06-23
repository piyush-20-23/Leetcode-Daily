class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();

        int max = 0;
        for(int ele : nums2){
            max = (max > ele) ? max : ele;
        }
        int nGE[] = new int[max + 1];

        for(int i = nums2.length - 1; i >= 0; i --){
            while(!stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }

            nGE[nums2[i]] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }

        for(int i = 0; i < nums1.length; i ++){
            nums1[i] = nGE[nums1[i]];
        }

        return nums1;
    }
}