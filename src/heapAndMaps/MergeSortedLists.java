package heapAndMaps;

import java.util.ArrayList;


class ListNode {
    public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
 }

public class MergeSortedLists {

    public ListNode mergeKLists(ArrayList<ListNode> a) {

        if (a == null || a.isEmpty()) {
            return null;
        }
        int last = a.size()-1;
        while(last>0) {

            int i = last;
            a.set(i-1, merge(a.get(i-1) , a.get(i)));
            last--;

        }


        return a.get(0);
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode result = null;
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }

        if (a.val> b.val) {
            result = b;
            result.next = merge(a, b.next);
        } else {
            result = a;
            result.next = merge(a.next, b);
        }

        return result;
    }

}
