class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] letters = new int[5];
        for(int i = 0; i < text.length(); i ++){
            switch(text.charAt(i)){
                case 'b':
                    letters[0] ++;
                    break;
                case 'a':
                    letters[1] ++;
                    break;
                case 'l':
                    letters[2] ++;
                    break;
                case 'o':
                    letters[3] ++;
                    break;
                case 'n':
                    letters[4]++;
                    break;
            }
        }
        System.out.println(Arrays.toString(letters));

        int count = Math.min(
            letters[0],
            Math.min(letters[1],
                Math.min(letters[2] / 2,
                    Math.min(letters[3] / 2,letters[4])))
        );
        
        return count;
    }
}