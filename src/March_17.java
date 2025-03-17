import java.util.Arrays;

public class March_17 {
    public static boolean divideArray(int[] nums) {
        boolean[] a = new boolean[500];
        Arrays.fill(a, true);
        boolean valid = true;
        int maxEle = Integer.MAX_VALUE;

        // mark the nums[i]th index with True / False
        for (int num : nums) {
            a[num] = !a[num];
        }

        for (boolean b : a) {
            if (!b) {
                valid = false;
                break;
            }
        }
        return valid;
    }

    public static void main(String[] args) {
        if(divideArray(new int[]{3,2,3,2,2,2})){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }
}
