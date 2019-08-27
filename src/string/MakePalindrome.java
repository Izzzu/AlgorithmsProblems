package string;

public class MakePalindrome {

    public int solve(String A) {
        int count = 0;
        while(!A.isEmpty() && !isPalindrome(A)) {
            count++;
            A = A.substring(0, A.length()-1);
        }
        return count;
    }

    private boolean isPalindrome(String A) {
        int l = 0;
        int r = A.length()-1;
        while(l<=r) {
            if (A.charAt(l) == A.charAt(r)) {
                r--;
                l++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MakePalindrome mp = new MakePalindrome();
        System.out.println(mp.solve("babb"));
    }
}
