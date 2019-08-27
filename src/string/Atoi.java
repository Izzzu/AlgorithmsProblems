package string;

public class Atoi {

    public int atoi(final String A) {
        boolean plus = true;
        String a = A.trim();
        a = a.replaceFirst ("^0*", "");
        if (a.isEmpty()) a = "0";
        if (a.charAt(0) == '+') {
            plus = true;
            a = a.substring(1, a.length());
        } else if (a.charAt(0) == '-') {
            plus = false;
            a = a.substring(1, a.length());
        }
        // -2,147,483,648 to +2,147,483,647
        int len = 0;
        int i = 0;
        long num = 0;
        while(len<=10 && i<a.length()) {
            char c = a.charAt(i);
            if (!Character.isDigit(c)) {
                return (int)num;
            } else{
                long v = Character.getNumericValue(c);
                num = num*10L+v;
                len++;
                i++;
            }

            if(len >= 10) {
                if (plus && num > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (!plus && (-1)*num<Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return (int)num;
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.atoi("-15620769845D3431 491E4 8X644 465 P18078") );
    }
}
