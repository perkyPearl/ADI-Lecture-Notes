public class QueueUsage {
    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue();

        q.enque(10, 2);
        q.enque(30, 1);
        q.enque(20, 3);
        q.enque(40, 0);

        System.out.println("Element at the front of the queue: " + q.peek());

        System.out.println("Dequeued: " + q.deque());
        System.out.println("Dequeued: " + q.deque());
        System.out.println("Dequeued: " + q.deque());
        System.out.println("Dequeued: " + q.deque());

        System.out.println("Dequeued: " + q.deque());
    }
}

class PriorityQueue {
    Node head;

    PriorityQueue() {
        head = null;
    }

    void enque(int data, int priority) {
        Node n = new Node(data, priority);

        if (head == null || head.priority < n.priority) {
            n.next = head;
            head = n;
        } else {
            Node temp = head;
            while (temp.next != null && temp.next.priority >= n.priority) {
                temp = temp.next;
            }
            n.next = temp.next;
            temp.next = n;
        }
    }

    int deque() {
        if (head == null) {
            System.out.println("Queue is Empty");
            return -1;
        }

        int res = head.data;
        head = head.next;

        return res;
    }

    int peek() {
        if (head == null) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return head.data;
    }
}

class Node {
    int data;
    int priority;
    Node next;

    Node(int data, int priority) {
        this.data = data;
        this.priority = priority;
        this.next = null;
    }
}
