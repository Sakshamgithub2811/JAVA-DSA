// insertAtHead
// insertAtTail
// insertAtposition
// display
// search
// deletehead
// deleteTail
// deleteAtPosition

class circularLinkedList{
    static class Node{
        int data;
        Node next;
        
        Node(int data){
            this.data = data;
            this.next = null;

        }
    }
    private Node head;
    private Node tail;
    private int size;

    public circularLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    void insertAtHead( int data){
    Node newHead = new Node(data);
     
     if(head == null){
        newHead.next = newHead;
        head = newHead;
        tail = newHead;
        
     }
     else{
 newHead.next = head;
    tail.next = newHead;
    head = newHead;
     }
    size++;
    }


    void insertAtTail(int data){
        Node newHead = new Node(data);
        if(head == null){
            newHead.next = newHead;
            head = newHead;
            tail = newHead;
        }else{
            tail.next = newHead;
            tail = newHead;
            newHead.next = head;
        }
        size++;
    }

    void display(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        
        Node temp = head;
        do{
            System.out.print(temp.data+"->");
            temp = temp.next;
        }while(temp!=head);
        System.out.println("(head)");
    }

    void insertAtPosition(int position, int data){
        if(position < 1 || position > size+1){
            System.out.println("Invalid Position");
            return;
        }
        if(position == 1){
            insertAtHead(data);
            return;


        }
        if(position == size+1){
            insertAtTail(data);
            return;
        }
        Node temp = head;
        for(int i=1;i<position-1;i++){
            temp = temp.next;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;

    }


    void search(int data){
        if(head==null){
            System.out.println("Empty List");
            return;
        }
        Node temp = head;
        do{
            if(temp.data == data){
                System.out.println("Element found");
                return;
            }
            temp = temp.next;
        }while(temp!=head);
        System.out.println("not found");
    }

    void deleteHead(){
        if(head==null){
            System.out.println("Empty List");
            return;
        }

        if(head == tail){
            head= null;
            tail = null;
            size--;
            return;
        }

        head = head.next;
        tail.next = head;
        size--;
    }

    void deleteTail(){
        if(head == null){
            System.out.println("Empty List");
            return;
        }

        if(head == tail){
            head= null;
            tail = null;
            size--;
            return;
        }

        Node temp = head;
        for(int i=1;i<size-1;i++){
            temp = temp.next;
        }
        
        tail = temp;
        tail.next = head;
        size--;
    }

    void deleteAtPosition(int position){
        if(position<1 || position>size){
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
        for(int i=1;i<position-1;i++){
            temp = temp.next;
        }

        Node toDelete = temp.next;
        temp.next = toDelete.next;
        toDelete = null;
        size--;

    }



}


class Main{
    public static void main(String []args){
        circularLinkedList list = new circularLinkedList();
        list.insertAtHead(10);
        list.insertAtTail(20);
        list.insertAtTail(30);

        list.display();
    }
}
