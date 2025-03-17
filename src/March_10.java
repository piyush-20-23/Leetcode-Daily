public class March_10 {

    public static void countOfSubstrings(String word, int k) {
        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                for (int l = i; l < j + 1; l++) {
                    System.out.print(word.charAt(l));
                }
                System.out.println();
            }

        }
    }

    public static void main(String[] args) {
        countOfSubstrings("aeioqq", 1);
    }
}
