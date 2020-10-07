                /*
                Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL

                */
                
                /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null || k==0) {
            return head;
        }
        ListNode curr = head;
        int length = 1;
        
        ListNode endNode = null;
        
        
        while(curr.next != null) {
            
            length++;
            
            curr = curr.next ;
            endNode = curr ;
        }
        
        curr = head;
        
        System.out.println("-----------> Hey There <----------"+length);
        
        if(k==length || k%length==0) {
            return head;
        }
        if(k>length) {
            k = k%length;
        }
        
        int count = 1;
        ListNode next = null;
        while(count != length-k) {
            curr = curr.next;
            count++;
        }
        
        next = curr.next;
        
        curr.next = null;
        
        endNode.next = head;
        
        
        
        return next;
        
        
    }
}                             
