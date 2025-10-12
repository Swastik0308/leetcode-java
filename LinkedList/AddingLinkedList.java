//All the operations and few of leetcode questions are there.

public class AddingLinkedList {

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

    // addFirst and addLast have O(1) TC
    public void addFirst(int data) {
        // step1 -> create new node
        Node newNode = new Node(data);
        size++;

        if (head == null) { // linked list is empty
            head = tail = newNode;
            return;
        }

        // step2 -> newNode's next = head
        newNode.next = head;

        // step3 -> head = newNode
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

    public void print() {
        // if (head == null) {
        // System.out.println("Linked List is empty");
        // return;
        // }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addMiddle(int idx, int data) {
        // adding middle takes O(n) TC bcz it searches for the index
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        // i = idx-1 => temp = prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() { // On deleting the node from LL, the garbage collector automatically deletes
                               // from the memory unlike C++ where we have to delete explicitly
        if (head == null) { // size=0
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;

        } else if (head == tail) {// size=1
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (head == null) { // size=0
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;

        } else if (head == tail) {// size=1
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node temp;
        temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        int val = tail.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    // Search for a key in linked list similar to linear search
    public int iterativeSearch(int key) {
        if (head == null) {
            System.out.println("Linked list is empty");
            return -1;
        }

        Node temp = head;
        int idx = 0;
        while (temp != null) {
            if (temp.data == key) {
                return idx;
            } else {
                temp = temp.next;
                idx++;
            }
        }
        return -1;
    }

    public int helper(Node head, int key) { // helper funtion for recusion search O(n)
        if (head == null)
            return -1;

        if (head.data == key)
            return 0;

        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }

        return idx + 1;

    }

    public int recursiveSearch(int key) {
        return helper(head, key);

    }

    public void reverseLinkedList() {
        // Leetcode Link: https://leetcode.com/problems/reverse-linked-list/description/
        // O(n)
        Node prev = null; // previous of head is null
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev; // since after exiting the loop my curr will be null
    }

    public void deleteNthNodeFromEnd(int n) {// This n is the nth node from last.
        // https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
        // O(n)
        int sz = 0; // In this program we have already created size to keep track, but in the coding
                    // contest or interviews they may not give size so we will find again
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if (n == sz) {
            head = head.next; // remove first
            return;
        }

        int idx = 1;
        int idxToFind = sz - n;
        Node prev = head;
        while (idx < idxToFind) {
            prev = prev.next;
            idx++;
        }
        prev.next = prev.next.next; // This is simple prev.next = curr.next
        return;

    }

    // Program to find a given linked list is palindrome or not
    /*
     * There are 3 steps
     * 1.To find mid
     * 2.To reverse the second half of linked list
     * 3.Check if first and second half is equal or not
     */

    // Lettcode Link: https://leetcode.com/problems/palindrome-linked-list/
    // O(n)
    public Node findMid(Node head) { // helper
        Node slow = head;
        Node fast = head;

        while (fast != null /* if size is even */ && fast.next != null /* if size is odd */) {
            slow = slow.next; // moves one step
            fast = fast.next.next; // moves two step

        }
        return slow; // At this point slow will be pointing to mid
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null)
            return true;

        Node midNode = findMid(head);

        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }

        Node right = prev; // head of right half
        Node left = head;

        while (right != null) {
            if (left.data != right.data) {

                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;

    }

    // Detecting cycle/loops in linked list
    // Here we use Floyds algorithm [Slow-Fast approach]

    public static boolean isCycle() {
        // Leetcode Link: https://leetcode.com/problems/linked-list-cycle/
        // O(n)
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) { // This condition will only be true for linear linked list
            slow = slow.next; // +1
            fast = fast.next.next; // +2

            if (slow == fast)
                return true; // Cycle detected

        }

        return false; // No cycle
    }

    public static void removeCycle() {
        // Leetcode Link:
        // https://leetcode.com/problems/linked-list-cycle-ii/description/
        // O(N)
        // Detecting cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }

        }

        if (cycle == false) {
            System.out.println("Cycle does not exist");
            return;
        }

        // Find meeting point(where cycle begins)
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next; // now both slow and fast should be increased by one, when they meet they will
                              // meet at start of cycle and prev will be pointing to last node which makes the
                              // list cycle
            fast = fast.next;

        }
        // remove cycle
        prev.next = null;// last node is stored
    }

    // Merge sort using linked list
    // O(nlogn)

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // mid node
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = getMid(head);

        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        // For remaining nodes
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next; // bcz head of mergedLL is -1(dummy)

    }

    // zig Zag linked list
    // Leetcode Link: https://leetcode.com/problems/reorder-list/
    public void zigZag() {
        // find mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse 2nd half
        Node curr = mid.next; // 2nd half
        mid.next = null; // 1st half
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // zigzag merge
        while (left != null && right != null) {
            // zigzag operations
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            // Updation
            left = nextL;
            right = nextR;
        }
    }

    //
    public static void main(String[] args) {
        AddingLinkedList ll = new AddingLinkedList();

        // ll.print();
        // ll.addFirst(1);
        // // ll.print();
        // ll.addFirst(2);
        // // ll.print();
        // ll.addFirst(3);
        // //ll.print();
        // ll.addLast(4);
        // // ll.print();
        // ll.addLast(5);
        // // ll.print();
        // ll.addLast(6);
        // ll.addMiddle(2, 9);
        // ll.print();
        // ll.removeFirst();
        // ll.print();
        // ll.removeLast();
        // ll.print();
        // System.out.println(ll.iterativeSearch(9));
        // System.out.println(ll.recursiveSearch(10));
        // ll.reverseLinkedList();
        // ll.deleteNthNodeFromEnd(3);
        // ll.print();
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(1);
        // ll.print();
        // System.out.println(ll.checkPalindrome());

        // Creating a loop in linked list
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp; // 1->2->3->2[head]
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        // For merge sort
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        ll.print();
        // ll.head = ll.mergeSort(ll.head);
        ll.zigZag();
        ll.print();

    }
}
