import java.util.ArrayList;

public class StackUsingArrayList {

    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // push
        public static void push(int data) {
            list.add(data);
        }

        // pop
        public static int pop() {
            // int top = list.get(list.size()-1);
            // list.remove(list.size()-1);
            // return top;
            if (isEmpty())
                return -1;
            return list.remove(list.size() - 1);
        }

        // peek
        public static int peek() {
            return list.get(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            System.out.println("******");
            System.out.println(s.pop());
            System.out.println("-------");
            ;
        }
    }

}
