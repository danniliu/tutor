package app.stack;

// This Stack is implemented using linked list
public class StackImpl {
    private Node top;
    private int nodeLength;

    public StackImpl() {
        top = null;
        nodeLength = 0;
    }

    public void push (int input){
        Node newTop = new Node(input);

        if (top == null) {
            top = newTop;
        } else {
            newTop.next = top;
            top = newTop;
        }
        nodeLength++;
        System.out.println("push " + top.data);
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            System.exit(-1);
        }
        return top.data;
    }

    public int pop(){   //time O(1)
        if (isEmpty()) {
            System.out.println("Stack is empty");
            System.exit(-1);
        }

        Node newTop = top.next;
        int popData =  top.data;

        top = newTop;
        nodeLength--;

        System.out.println("pop " + popData);

        return popData;
    }



    public static void main (String[] args) {
        StackImpl stack = new StackImpl();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        
    }
    
}

class Node {
    int data;
    Node next;

    public Node (int data){
        this.data = data;
    }
}
