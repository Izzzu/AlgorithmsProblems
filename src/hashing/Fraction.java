package hashing;

import java.util.HashMap;
import java.util.Map;

public class Fraction {

    public String fractionToDecimal(int a, int b) {

        StringBuilder result = new StringBuilder();
        boolean sign = (a<0 && b>0) || (a>0 && b<0);
        if (sign) {
            result.append("-");
        }
        long A = Math.abs((long)a);
        long B = Math.abs((long)b);
        long factor = A/B;
        result.append(factor);

        if (B*factor == A) {
            return result.toString();
        }

        result.append(".");

        Map<Long, Integer> reminders = new HashMap<>();

        long rest = A%B;
        while(rest!=0) {

            long nextDividend = 10*rest;
            long d = nextDividend /B;
            if (!reminders.isEmpty()&& reminders.containsKey(nextDividend)) {
                result.append(")");
                result.insert(reminders.get(nextDividend), "(");
                break;
            }
            reminders.put(nextDividend, result.length());
            result.append(d);


            rest = nextDividend-(d*B);


        }

        return result.toString();


    }

    public String fractionToDecimalSimpler(int numerator, int denominator) {
        long a=numerator,b=denominator;
        if(a%b==0) return String.valueOf(a/b);
        Map<Long,Integer> map=new HashMap<>();
        StringBuilder res=new StringBuilder();
        if((a>0&&b<0)||(a<0&&b>0)) res.append("-");
        a=Math.abs(a);
        b=Math.abs(b);
        res.append(a/b+".");
        a=(a%b)*10;
        while(!map.containsKey(a)){
            map.put(a,res.length());
            res.append(String.valueOf(a/b));
            a=(a%b)*10;
            if(a==0) return res.toString();
        }
        return res.insert(map.get(a),"(").append(")").toString();
    }

    public static void main(String[] args) {
        //System.out.println(new Fraction().fractionToDecimal(87,  22));
        System.out.println(new Fraction().fractionToDecimal(-1,  20));
    }

}
