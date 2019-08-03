package string;

public class LengthOfLastWord {

    public static int lengthOfLastWord(final String A) {
        if (A.isEmpty()) {
            return 0;
        }
        int end = A.length();
        while(end>0 && A.charAt(end-1) == ' ') {
            end--;
        }
        int start = 0;
        for (int i = end-1; i>=0; i--) {
            if (A.charAt(i) == ' ') {
                start = i+1;
                break;
            }
        }
        return end-start;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World  "));
        System.out.println(lengthOfLastWord(" "));
        System.out.println(lengthOfLastWord("A"));
        System.out.println(lengthOfLastWord("  xDGBklKecz IAcOJYOH O  WY WPi"));
    }
}
