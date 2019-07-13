package arrays;

import java.util.Arrays;
import java.util.List;

public class LargestNumber {
    public static String largestNumber(final List<Integer> A) {
        return A.stream()
                .map(i -> Integer.toString(i))
                .sorted((str1, str2) -> {
                    String a = str1+str2;
                    System.out.println("a = " + a);
                    String b = str2+str1;
                    System.out.println("b = " + b);

                    int com = a.compareTo(b);
                    System.out.println("com = " + com);

                    if(com>0) {
                        return -1;
                    } else if (com==0) {
                        return 0;
                    } else {
                        return 1;
                    }
                })
                .reduce((s1, s2) -> s1+s2)
                .orElse("");
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(Arrays.asList(8, 89)));
    }
}
