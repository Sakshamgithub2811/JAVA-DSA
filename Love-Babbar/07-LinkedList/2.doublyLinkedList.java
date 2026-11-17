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
        nextNode.prev = newNode;

        size++;

    }

    void display(){
        Node temp = head;
        while(temp!= null){
            System.out.print(temp.data+"<->"); 
            temp = temp.next;
        }
        System.out.println("null");
    }

    void DisplayBackward(){
        Node temp = tail;
        System.out.print("Backward: ");
        while(temp!=null){

            System.out.print(temp.data+"<-");
            temp = temp.prev;
        }
        System.out.println("null");
    }


    void SearchList(int data){
        Node temp = head;

        for(int i=1;i<=size;i++){
            if(temp.data == data ){
                System.out.println("Element found");
                   return;
            }
         temp = temp.next;
        }
        System.out.println("Element is not present");


    }
    
    void updateAtPosition(int position, int data){
        if(position > 1 && position < size){
            System.out.println("InValid Position");
        }
        
        Node temp = head;
        for(int i=1;i<position;i++){
            temp = temp.next;
        }
        temp.data = data;

    }


    // updateAtPosition
    // updateValue

    void updateValue(int data, int newValue){
        
         Node temp = head;
         for(int i=1;i<=size;i++){

            if(temp.data == data){
                temp.data = newValue;
                return;

            }
            temp = temp.next;


         }
    }


    void deleteHead(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        if(head.next == null){
            head = null;
            tail = null;
            
        }
        else{
            head = head.next;
            head.prev = null;
        }
        size--;
        
    }
    void deleteTail(){
     if(head == null){
        System.out.println("List is empty");
        return;
    }
    if(head.next == null){
        head = null;
        tail = null;
        return;
    }else{
        tail = tail.prev;
        tail.next = null;
    }
    size--;

   }
    // deleteTail
    // deleteAtPosition

    void deleteAtPosition(int position){
        if(position < 1 || position > size){
            System.out.println("Invalid Position");
            return;
        }
        if(position == 1){
            deleteHead();
            return;
        }
        if(position == size){
            deleteTail();
            return;
        }

        Node temp = head;
        for(int i =1;i<position;i++){
            temp = temp.next;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
    }
    
}


class Main {
    public static void main (String []args){
        doublyLinkedList list = new doublyLinkedList();
        list.insertAtHead(10);
        list.insertAtTail(20);
        list.insertAtPosition(2, 300);


        list.display();
        list.DisplayBackward();
        list.updateValue(20, 3000);
        list.display();
        list.deleteAtPosition(2);
        list.display();
    }
}