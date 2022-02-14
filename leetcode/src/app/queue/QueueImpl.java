package app.queue;

// This impl uses linkedlist
public class QueueImpl {
    private Node front, rear;
    private int length;

    public QueueImpl() {
        this.rear = null;
        this.front = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    // add at the end of the queue:
    public void add (int input){
        Node oldRear = rear;
        rear = new Node(input);
        if(isEmpty()) {  //1st element in the queue 
            front = rear;
        }else{
            oldRear.next = rear;
        }
        length++;
        System.out.println("Added " + rear.data);
    }

    // remove from the front
    public int remove(){
        if (isEmpty()) {
            System.out.println("The queue is empty");
            System.exit(-1);
        }
        Node oldFront = front;
        front = front.next;
        length--;
        System.out.println("removed  " + oldFront.data);
        return oldFront.data;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("The queue is empty");
            System.exit(-1);
        }
        return front.data;
    }

    public static void main(String[] args) {

        QueueImpl queue = new QueueImpl();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        queue.remove();
        queue.remove();
        queue.remove();

    }
    
}

class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
