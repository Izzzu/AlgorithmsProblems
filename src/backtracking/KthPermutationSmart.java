package backtracking;

public class KthPermutationSmart {

    public String getPermutation(int n, int k) {

        int[] nums = new int[n];
        int[] fac = new int[n+1];

        nums[0] = 1;
        fac[1] = 1;
        fac[0] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i-1] = i;
            fac[i] = i*fac[i-1];
        }

        if (k<=1) {
            return stringFromNr(n).toString();
        }

        if (k>=fac[n]) {
            StringBuilder s = stringFromNr(n);
            return s.reverse().toString();
        }

        k -=1;
        for (int i = 0; i < n-1; i++) {
            int f = fac[n-i-1];
            int index = k/f;

            shift(nums,i, i+index);

            k = k - f*index;
        }

        return stringFromNr(nums);

    }

    private String stringFromNr(int[] nums) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            s.append(nums[i]);
        }
        return s.toString();
    }

    private static void shift(int[] a, int s, int e){
        int temp = a[e];
        for(int i = e; i > s; i--){
            a[i] = a[i-1];
        }
        a[s] = temp;
    }

    private StringBuilder stringFromNr(int n) {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < n; i++) {
            s.append(i+1);
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new KthPermutationSmart().getPermutation(3, 5));
    }




}
