class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DetectCycle {
    public static void main(String[] args) {
        ListNode head = createLinkedListWithCycle();

        // Test the linked list with your cycle detection method
        if (hasCycle(head)) {
            System.out.println("The linked list contains a cycle.");
        } else {
            System.out.println("The linked list does not contain a cycle.");
        }
    }

    // Method to create a linked list with a cycle
    public static ListNode createLinkedListWithCycle() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        // Linking nodes to form the list: 1 -> 2 -> 3 -> 4
        head.next = second;
        second.next = third;
        third.next = fourth;

        // Creating a cycle by linking the last node back to the second node
        fourth.next = second;

        return head;  // Returns the head of the cyclic linked list
    }

    // Method to detect cycle using Floyd’s Cycle-Finding Algorithm
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet, there is a cycle
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
