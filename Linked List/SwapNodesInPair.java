/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next == null)
            return head;
        ListNode ans = head.next, cur = head, next = null, prev = null;

        while(cur != null && cur.next != null){
            next = cur.next.next;
            if(prev != null)
            prev.next = cur.next;
            cur.next.next = cur;
            cur.next = next;
            prev = cur;
            cur = next;
        }
        return ans;
    }
}