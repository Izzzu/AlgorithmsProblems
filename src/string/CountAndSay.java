package string;

public class CountAndSay {

    public static String countAndSay(int A) {
        String s = "1";
        for (int i = 1; i<A; i++) {
            s = say(s);
        }
        return s;
    }

    public static  String say(String m) {
        StringBuilder s = new StringBuilder();

        if (m.equals("1")) {
            s.append("11");
        } else {
            char c = m.charAt(0);
            int count = 1;
            for (int i = 1; i<m.length(); i++) {
                if (m.charAt(i) == c) {
                    count++;
                } else {
                    s.append(count);
                    s.append(c);
                    c = m.charAt(i);
                    count = 1;
                }

            }
            s.append(count);
            s.append(c);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
