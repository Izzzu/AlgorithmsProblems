package heapAndMaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeSortedLists2 {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {

        PriorityQueue<ListNode> heads = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val>o2.val ? 1 : -1;
            }
        });

        for (ListNode listNode : a) {
            heads.add(listNode);
        }

        ListNode head = null;
        ListNode nextNode = null;

        while(heads.size()> 0) {
            ListNode n = heads.poll();
            ListNode newNode = new ListNode(n.val);
            if (head == null) {
                head = newNode;
                nextNode = newNode;
            } else {
                nextNode.next = n;
                nextNode = n;
            }
            if (n.next !=null) {
                heads.add(n.next);
            }

        }

        return head;

    }


}
