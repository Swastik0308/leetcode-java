public class QueuesWithArrays {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front; // for implementing circular queue

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;

        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // add O(1)
        public static void add(int data) {
            // regular q
            // if (rear == size - 1) {
            // System.out.println("Q IS FULL");
            // return;
            // }

            // rear = rear + 1;
            // arr[rear] = data;

            // circular q

            if (isFull()) {
                System.out.println("FULL");
                return;
            }
            if (front == -1)
                front = 0;

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // remove TC = O(n) for regular q to overcome this we implemented circular q
        public static int remove() {
            if (isEmpty()) {
                System.out.println("EMPTY");
                return -1;
            }

            // int front = arr[0];
            // for (int i = 0; i < rear; i++) {
            // arr[i] = arr[i + 1];
            // }
            // rear = rear - 1;
            // return front;

            int result = arr[front];

            // if we are deleting the last element
            if (rear == front)
                rear = front = -1;
            else
                front = (front + 1) % size;
            return result;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("EMPTY");
                return -1;
            }

            // return arr[0];
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
