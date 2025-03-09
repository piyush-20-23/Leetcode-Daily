import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//2523. Closest Prime Numbers in Range
public class March_7 {
    public static int[] closestPrimes(int left, int right) {
        List<Integer> primes = new ArrayList<>() ;
        for(int num = left; num <= right; num++) {
            boolean flag = true;
            for (int i = 2; i < left; i++) {
                if (num % i == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                primes.add(num);
            }
        }
        if (primes.contains(1)){
            primes.remove(Integer.valueOf(1));
        }
        if(primes.size() < 2){
            return new int[]{-1,-1};
        }



        int minDiff = Integer.MAX_VALUE;
        int num1 = 0, num2 = 0;

        for (int i = 0; i < primes.size() - 1; i++) {
            int diff = primes.get(i + 1) - primes.get(i);
            if (diff < minDiff) {
                minDiff = diff;
                num1 = primes.get(i);
                num2 = primes.get(i + 1);
            }
        }
        return new int[]{num1,num2};
    }
    public static void printArray(boolean[] a){
        for (boolean i : a){
            System.out.println((i)?"True":"False");
        }
    }

    public static int[] closestPrimesOptimal(int left, int right){
        boolean[] prime = new boolean[right + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int p = 2; p*p <= right; p++) {
            if(prime[p]){
                for (int i = p*p; i <= right ; i += p) {
                    prime[i] = false;
                }
            }
        }
        int[] result = new int[]{-1,-1};
        int prev = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            if (prime[i]){
                if (prev == -1) {
                    prev = i;
                } else {
                    if (minDiff > i - prev) {
                        minDiff = i - prev;
                        result[0] = prev;
                        result[1] = i;
                    }
                    prev = i;
                }
            }
        }
        return result;

    }
    public static void main(String[] args) {
        int[] Ans = closestPrimesOptimal(15,25);
        System.out.println("Result : ");
        for (int j : Ans) {
            System.out.print(j + " ");
        }
    }
}
