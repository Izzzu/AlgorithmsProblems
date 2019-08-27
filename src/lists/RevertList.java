package lists;

public class RevertList {

    public ListNode revert(ListNode A) {
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
        }
        return prev;
    }

    /*
     ListNode prev = null, curr = node, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
     */
}
