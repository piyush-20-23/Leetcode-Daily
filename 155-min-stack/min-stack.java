class Node {
    int val;
    Node next;
    int min;

    Node(){}

    Node(int val, int min){
        this.val = val;
        this.min = min;
    }
}

class MinStack {
    int val;
    Node head;

    public MinStack() {
        
    }
    
    public void push(int value) {
        int currMin = (head == null)
                ? value
                : Math.min(value, head.min);
        Node temp = new Node(value, currMin);
        temp.next = head;
        head = temp;

    }
    
    public void pop() {
        if(head == null)
            return;
        head = head.next;
        
    }
    
    public int top() {
        if(head == null){
            //System.out.println("Head is null");
            return -6969;
        }

        return head.val;
    }
    
    public int getMin() {
        // int min = Integer.MAX_VALUE;
        // Node temp = head;
        // while(temp != null){
        //     min = (min < temp.val) ? min : temp.val;
        //     temp = temp.next;
        // }
        return head.min;
    }
}

