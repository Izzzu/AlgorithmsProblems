package binarySearch;

public class PowerFunction {

    public static int pow(int x, int n, int d) {
        return (int)((poww(x,n,d))%d);
    }

    static long poww(long x, long n, long d)
    {

        if(n==0)
            return 1;
        if(x>=0)
        {
            if(n==1)
                return x%d;
            else {
                if (n%2==0) {
                    long y = poww(x,n/2,d);
                    return y*y%d;
                } else {
                    return (x%d*poww(x,n-1,d)%d)%d;
                }
            }
        }
        else
        {
            if(n==1)
                return (d-((-x)%d))%d;
            else {
                if (n%2==0) {
                    return poww(-x, n, d);
                } else {
                    return (d-poww(-x,n,d))%d;
                }
            }

        }
    }


    public static void main(String[] args) {
        System.out.println(pow(-1,1,20));
    }
}
