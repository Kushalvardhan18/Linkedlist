public class DoublyLL {
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //add First
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            size++;
           return;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;

        }
    }

    // Print
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }


    //remove First
    public int removeFirst(){
        if(head == null){
            System.out.println("Empty");
            return Integer.MIN_VALUE;
        }
        if(size ==1){
            int val = head.data;
            head = null;
            tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    // add last
    public  void addLast(int data){
        Node newNode = new Node(data);

        if(head ==null){
            head = newNode;
            newNode.next = null;
            size++;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
            newNode.next = null;
            size++;
        }
    }

    //removeLast
    public void removelast(){
        if(head == null){
            System.out.println("Empty");
            return;
        }
        if(size == 1){
            head = tail = null;
            size--;
        }
        else{
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }
    public static void main(String[] args){
        DoublyLL dll = new DoublyLL();
        dll.addFirst(5);
        dll.addFirst(6);
        dll.addFirst(1);
        dll.addFirst(9);
        dll.print();
        dll.removelast();
        dll.print();
    }
}
