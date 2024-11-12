import java.util.LinkedList;
//import java.util.*;
public class LL_Collection_Framework {
    public static void main(String[] args){
        //create
        LinkedList<Integer> myList = new LinkedList<>();

        //add
        myList.addLast(1);
        myList.addLast(2);
        myList.addFirst(0);
        System.out.println(myList);

        //remove
        myList.removeLast();
        myList.removeFirst();
        System.out.println(myList);
    }
}
