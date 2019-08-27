package string;

public class CompareVersion {

    public int compareVersion(String A, String B) {

        while(!A.isEmpty() || !B.isEmpty()) {
            int a = A.indexOf('.');
            int b = B.indexOf('.');
            int valA = 0;
            int valB = 0;

            if (a != -1) {
                valA = Integer.valueOf(A.substring(0, a));
            } else if (!A.isEmpty()){
                valA = Integer.valueOf(A);
            }
            if (b != -1) {
                valB = Integer.valueOf(B.substring(0, b));
            } else if (!B.isEmpty()){
                valB = Integer.valueOf(B);
            }
            if (valA>valB) {
                return 1;
            } else if(valB > valA) {
                return -1;
            } else if (a ==-1 && b==-1 && valA == 0 && valB == 0) {
                return 0;
            } else if (a != -1 || b!= -1) {

                A = (a!=-1) ? A.substring(a+1) : "";
                B = (b!=-1) ? B.substring(b+1) : "";
            } else {
                return 0;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersion v = new CompareVersion();
        System.out.println(v.compareVersion("13.0", "13.0.8"));
    }
}
