import java.util.*;

public class DoubleEndedQueue {

    public static void main(String[] args) {
        Deque<Integer> d = new LinkedList<>();
        d.addFirst(1);
        d.addFirst(2);
        d.addLast(3);
        d.addLast(4);
        // Similarly we have getFirst, getLast, removeFirst, removeLast
        System.out.print(d);

    }
}
