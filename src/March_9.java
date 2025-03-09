//3208. Alternating Groups II
public class March_9 {
    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int altGrp = 0;
        int n = colors.length;
        int[] subArray = new int[k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                subArray[j] = colors[(i+j)%n];
            }
            if(checkAlternate(subArray, k)){
                altGrp ++;
            }
        }

        return altGrp;
    }

    public static boolean checkAlternate(int[] a, int k){
        for (int i = 1; i < k; i++) {
            if (a[i] != a[i-1]){
                System.out.println(a[i] + " " + a[i-1]);
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] a){
        for (int j : a) {
            System.out.print(j + " ");
        }
    }
    public static void main(String[] args) {
        System.out.println(numberOfAlternatingGroups(new int[]{0,1,0,0,1,0,1},6));
    }
}
