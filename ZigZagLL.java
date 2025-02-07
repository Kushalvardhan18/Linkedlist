public class ZigZagLL {
    public static class Node {
        int data;
        ZigZagLL.Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static ZigZagLL.Node head;
    public static ZigZagLL.Node tail;
    public static int size;

    public void addFirst(int data) {
        //step 1: create new node
        ZigZagLL.Node newNode = new ZigZagLL.Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }


        //step2: newNode next = head
        newNode.next = head;//link

        //step3: head = newNode
        head = newNode;
    }

    public void addLast(int data) {
        ZigZagLL.Node newNode = new ZigZagLL.Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;

    }
    public  static void printLL() {
        if (head == null) {
            System.out.println("Linked list is empty ");
        }
        ZigZagLL.Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node reverseSecondHalf(Node rightHead){
        Node curr = rightHead;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;
    }
    public  static Node merging(Node leftHand, Node rightHand){
        Node nextL;
        Node nextR;
        while(leftHand != null && rightHand != null){
            nextL = leftHand.next;
            leftHand.next = rightHand;
            nextR =rightHand.next;
            rightHand.next = nextL;
            leftHand = nextL;
            rightHand = nextR;
        }
        return leftHand;
    }
    public static Node ZigZag(Node head){
        // Find Mid
        Node mid = getMid(head);

        // Reverse 2nd Half
        Node rightHead = mid.next;
        mid.next = null;
        Node leftHand = head;
        Node rightHand = reverseSecondHalf(rightHead);

        // Alternative Merging
        return merging(leftHand,rightHand);
    }
    public static void main(String[] args){
        ZigZagLL ll = new ZigZagLL();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        printLL();
        ll.ZigZag(head);
        printLL();

    }
}
