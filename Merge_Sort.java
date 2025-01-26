import java.util.*;
import java.util.LinkedList;

public class Merge_Sort {
    public static int mid(LinkedList<Integer> myList){
        int slow = head;
        int fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
    }
    public static void main(String[] args){
        LinkedList<Integer> myList = new LinkedList<>();
        myList.addFirst(5);
        myList.addLast(6);
        myList.addLast(7);
        myList.addLast(1);
        myList.addLast(2);
        myList.addLast(9);
        mid(myList);

    }
}
