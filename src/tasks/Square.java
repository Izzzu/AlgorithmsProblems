package tasks;

public class Square {
    static float squareRoot(int number, int precision) {

        if (number == 0) {
            return 0;
        }

        int s = 0;
        int e = number;
        int ans = 0;
        while(s<=e) {
            int mid = s+ (e-s)/2;

            if ((double)number/(double)mid == mid) {
                return (float)mid;
            }
            if (mid < (double)number/(double)(mid)) {
                s = mid+1;
                ans = mid;
            } else {
                e = mid-1;
            }
        }

        double inc = 0.1;
        for(int i = 0; i<precision; i++) {
            while((double)ans <= (double)number/(double)ans) {
                ans += inc;
            }
            ans -= inc;
            inc = inc/10;
        }

        return (float)ans;


    }
}
