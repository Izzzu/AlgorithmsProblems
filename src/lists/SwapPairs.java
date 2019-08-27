package lists;

public class SwapPairs {
    public ListNode swapPairs(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode first = A;
        ListNode next = A.next;
        ListNode end = next.next;
        if (end != null) {
            end.next = swapPairs(next);
        }

        first = next;
        next.next = A;
        A.next = end;

        return first;


    }
}
