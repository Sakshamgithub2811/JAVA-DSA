class doublyLinkedList{
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
        private Node head;
        private Node tail;
        private int size;

        public doublyLinkedList(){
            this.head = null;
            this.tail = null;
            this.size = 0;
        }


    void insertAtHead(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    void insertAtTail(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    void insertAtPosition(int position, int data){
        if(position<1 ||  position>size+1){
            System.out.println("Invalid Position");
            return;
        }

        if(position==1){
            insertAtHead(data);
            return;
        }
        if(position==size+1){
            insertAtTail(data);
            return;
        }

       Node temp = head;
       for(int i=1; i<position-1;i++){
        temp = temp.next;
       }

        Node newNode = new Node(data);
        Node nextNode = temp.next;
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next = newNode;
        nextNode.pre = newNode;

        size++;

    }

    insertAtPosition
    display
    printBackward
    search
    updateValue
    deleteAtHead
    deleteTail
    deleteAtPosition
    
}


class Main {
    public static void main (String []args){
        doublyLinkedList list = new doublyLinkedList();
        list.insertAtHead(10);
        list.insertAtTail(20);
    }
}