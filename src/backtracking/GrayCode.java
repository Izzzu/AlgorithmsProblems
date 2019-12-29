package backtracking;

import java.util.ArrayList;

public class GrayCode {

    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int n = 1<< a;
        for (int i = 0; i <n ; i++) {
            int next = i^(i>>1);
            result.add(next);

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new GrayCode().grayCode(2));
    }

}
