package others;

public class BinaryGap {
    public int solution(int N) {
        return solution(N >>> Integer.numberOfTrailingZeros(N), 0, 0);
    }

    private int solution(int n, int max, int current) {
        if (n == 0) {
            return max;
        }
        if ((n & 1) == 0) {
            return solution(n >>> 1, max, current+1);
        } else{
            return solution(n >>> 1, Math.max(max, current), 0);

        }

    }

    public int solution2(int N) {
        if (N == 0) {
            return 0;
        }
        String s = Integer.toBinaryString(N >>> Integer.numberOfTrailingZeros(N));

        int max = 0;
        int gap = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                gap++;
            } else {
                max = Math.max(gap, max);
                gap = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryGap().solution(9));
    }



}
