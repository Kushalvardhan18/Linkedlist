public class LinkedList {
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

    //Methods
    public  void addFirst(int data) {
        //step 1: create new node
        Node newNode = new Node(data);
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
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;

    }

    public  static void printLL(LinkedList ll) {
        if (head == null) {
            System.out.println("Linked list is empty ");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public  void addNode(int index, int data) {
        if(index ==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
           temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }
    public int removeFirst(){
        if(size ==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            size=0;
            int val = head.data;
            head = tail = null;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    public int removeLast(){
        if(size ==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            size=0;
            int val = head.data;
            head = tail = null;
            return val;
        }
        Node prev = head;
        for(int i =0;i<size-2;i++){
            prev = prev.next;
        }
        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;

    }
    public static int findKeyIndex(int key){
        Node temp = head;
        int i=0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }
    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next,key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }
    public  int recursiveSearch(int key){
        return helper(head,key);
    }
    public void reverse(){
        Node prev = null;
        Node curr = tail =head;
        while(curr !=null){
            Node next = curr.next;
            curr.next = prev;
           prev = curr;
           curr = next;
        }
        head = prev;

    }
    public void deleteNthNode(int n){
        int sz =0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        if(n ==sz){
            head = head.next;
            return;
        }
        int i=1;
        int idx= sz-n;   
        Node prev = head;
        while(i<idx){
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return;
    }

    // Slow-Fast Approach
    public Node findMid(Node head){
        Node slow= head;
        Node fast = head;
        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean isPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        // Find mid
        Node midNode = findMid(head);

        // reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next =prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; //right half head
        Node left = head;

        // check left half and right half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left= left.next;
            right= right.next;
        }
        return true;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
//        printLL(ll);
        ll.addNode(0, 100);
//        printLL(ll);
//        System.out.println(ll.size);
        ll.removeFirst();
//        printLL(ll);
        ll.removeLast();
        printLL(ll);
//        System.out.println(ll.size);
        int key =3;
        System.out.println( findKeyIndex(key));
        System.out.println(ll.recursiveSearch(3));
        ll.reverse();
        printLL(ll);
        ll.deleteNthNode(3);
        printLL(ll);
        System.out.println(ll.isPalindrome());
    }
}
