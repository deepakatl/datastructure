package com.leet.data.structure;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AddLinkedListNumberTest {

    private AddLinkedListNumber addLinkedListNumber = new AddLinkedListNumber();

    // Helper method to create a linked list from an array
    private ListNode createList(int[] values) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummyHead.next;
    }

    // Helper method to convert linked list to array
    private int[] toArray(ListNode node) {
        ArrayList<Integer> values = new ArrayList<>();
        while (node != null) {
            values.add(node.val);
            node = node.next;
        }
        return values.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void testAddTwoNumbers_case1() {
        ListNode l1 = createList(new int[]{2, 4, 3});
        ListNode l2 = createList(new int[]{5, 6, 4});
        ListNode expected = createList(new int[]{7, 0, 8});

        ListNode result = addLinkedListNumber.addTwoNumbers(l1, l2);

        assertArrayEquals(toArray(expected), toArray(result));
    }

    @Test
    public void testAddTwoNumbers_case2() {
        ListNode l1 = createList(new int[]{0});
        ListNode l2 = createList(new int[]{0});
        ListNode expected = createList(new int[]{0});

        ListNode result = addLinkedListNumber.addTwoNumbers(l1, l2);

        assertArrayEquals(toArray(expected), toArray(result));
    }

    @Test
    public void testAddTwoNumbers_case3() {
        ListNode l1 = createList(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = createList(new int[]{9, 9, 9, 9});
        ListNode expected = createList(new int[]{8, 9, 9, 9, 0, 0, 0, 1});

        ListNode result = addLinkedListNumber.addTwoNumbers(l1, l2);

        assertArrayEquals(toArray(expected), toArray(result));
    }
}
