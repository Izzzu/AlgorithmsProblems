package string;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {
    public static  String reverseWords(String a) {
        StringBuilder s = new StringBuilder();
        // int i = a.length()-1;
        // int space = false;
        // while(i>=0) {
        //     if (a.charAt(i) == ' ') {
        //         i--;
        //         if (!space && i!=a.length()-1) {
        //              space = true;
        //              s.append(a.charAt(i));
        //         }
        //     } else {

        //     }
        // }
        int i = 0;
        List<String> list = new ArrayList<String>();
        while (i < a.length()) {
            if (a.charAt(i) == ' ') {
                i++;
            } else {
                StringBuilder m = new StringBuilder();
                while (i < a.length() && a.charAt(i) != ' ') {
                    m.append(a.charAt(i));
                    i++;
                }
                list.add(m.toString());
            }
        }
        for (int j = list.size() - 1; j >= 0; j--) {
            s.append(list.get(j));
            if (j != 0) {
                s.append(' ');
            }
        }
        return s.toString();


    }

    public static void main(String[] args) {
        System.out.println(reverseWords("j"));
    }

}
