package others;

public class FrogJmp {
    public int solution(int X, int Y, int D) {
        return (int)Math.ceil((double)(Y-X) /(double)D);
    }

    public static void main(String[] args) {
        System.out.println(new FrogJmp().solution(10, 85, 30));
    }
}
