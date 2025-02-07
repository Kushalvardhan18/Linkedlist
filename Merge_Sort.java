public class Merge_Sort {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        //step 1: create new node
        Merge_Sort.Node newNode = new Merge_Sort.Node(data);
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
        Merge_Sort.Node newNode = new Merge_Sort.Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;

    }

    private static Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Mid node

    }

    private static Node merge(Node head1, Node head2) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;
        while(head1 != null && head2 != null ){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2 ;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next  = head1;
            head1 = head1.next;
            temp = temp.next;
        }while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergeLL.next;
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // Find Mid
        Node mid = getMid(head);

        //left and right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        //MERGE
        return merge(newLeft, newRight);
    }
    public  static void printLL() {
        if (head == null) {
            System.out.println("Linked list is empty ");
        }
        Merge_Sort.Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
    public static void main(String[] args) {
        Merge_Sort ll = new Merge_Sort();
        ll.addFirst(3);
        ll.addFirst(9);
        ll.addFirst(15);
        ll.addFirst(1);
        ll.addFirst(17);
        ll.addFirst(99);
        ll.addLast(4);
        ll.addLast(11);
        printLL();
       ll.head = ll.mergeSort(head);
        printLL();
    }
}
