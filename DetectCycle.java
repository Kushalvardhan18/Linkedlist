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

        // Check if a cycle exists and remove it if present
        if (hasCycle(head)) {
            System.out.println("The linked list contains a cycle.");
            removeCycle(head);
            System.out.println("Cycle removed.");
        } else {
            System.out.println("The linked list does not contain a cycle.");
        }

        // Re-check for cycle to verify removal
        if (hasCycle(head)) {
            System.out.println("The cycle was not removed.");
        } else {
            System.out.println("The linked list is now cycle-free.");
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

    // Method to remove the cycle from the linked list
    public static void removeCycle(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean cycleDetected = false;

        // Detect cycle and find the meeting point of slow and fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycleDetected = true;
                break;
            }
        }

        // If a cycle was detected, find the start of the cycle
        if (cycleDetected) {
            slow = head;
            ListNode prev = null;

            // Special case: if the cycle starts at the head
            if (slow == fast) {
                while (fast.next != slow) {
                    fast = fast.next;
                }
            } else {
                // Move both pointers at the same pace to find the cycle start
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }

            // Break the cycle
            fast.next = null;
        }
    }
}
