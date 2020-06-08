package others;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {


        if(A.length == 0) {
            return A;
        }
        for (int i = 0; i < K; i++) {
            rotateByOne(A);
        }

        return A;
    }

    private void rotateByOne(int[] A) {
        int temp = A[A.length-1];
        for (int i = A.length-1; i >0; i--) {
            A[i] = A[i-1];
        }
        A[0] = temp;
    }


}
