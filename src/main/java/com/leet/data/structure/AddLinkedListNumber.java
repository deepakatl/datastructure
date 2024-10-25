package com.leet.data.structure;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddLinkedListNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy node to start the result list
        ListNode current = dummyHead; // Pointer to the current node in the result list
        int carry = 0; // Variable to store carry-over value
        
        // Loop until both lists are empty and there is no carry left
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0; // Value from l1, or 0 if l1 is null
            int y = (l2 != null) ? l2.val : 0; // Value from l2, or 0 if l2 is null
            int sum = x + y + carry; // Calculate sum including carry
            carry = sum / 10; // Calculate carry for next iteration
            current.next = new ListNode(sum % 10); // Create new node with the result
            current = current.next; // Move to the next node
            
            // Move to the next nodes in the input lists
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummyHead.next; // Return the resulting linked list, excluding dummy head
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
