class MyCircularQueue {
    int[] arr;
    int front, rear, len;
    public MyCircularQueue(int k) {
        arr = new int[k];
        front = 0;
        rear = 0;
        len = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;

        arr[rear] = value;
        rear = (rear + 1) % arr.length;
        len++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;

        front = (front + 1) % arr.length;
        len--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;

        return arr[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;

        int prevIndex = (rear-1 + arr.length) % arr.length;
        return arr[prevIndex];
    }
    
    public boolean isEmpty() {
        if(len == 0) return true;
        else return false;
    }
    
    public boolean isFull() {
        if(len == arr.length) return true;
        else return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
