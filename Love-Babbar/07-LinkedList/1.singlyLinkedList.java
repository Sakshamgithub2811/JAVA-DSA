public class singlyLinkedList{

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


    public singlyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void display() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }
     
    public void insertAtHead(int data) {
        Node newNode = new Node(data);

        if (head == null) { 
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    public void insertAtTail(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void insertAtPosition(int position, int data){
        if(position < 1 || position > size + 1 ){
            System.out.println("Invalid Position!");
            return;
        }

        if(position == 1){
            insertAtHead(data);
            return;
        }
        if(position == size + 1){
            insertAtTail(data);
            return;
        }

        Node temp = head;
        for(int i = 1 ; i < position - 1;i++){
            temp = temp.next;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int head(){
        if(head == null){
            return -1;
        }
        else{
            return head.data;
        }
    }

    public int tail(){
        if(tail == null){
            return -1;
        }
        else{
            return tail.data;
        }
    }
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }
    public void Search(int data){
        Node temp = head;

        for(int i = 1 ; i <= size ; i++){
            if(temp.data == data){
                System.out.println("Element is present");
                return;
            }
            temp = temp.next;   
        }
        System.out.println("Element is not present");

    }

    public void findPosition(int data){
        Node temp = head;
        for(int i =1; i<= size;i++){
            if(temp.data == data){
                System.out.println(i);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Element is not present");

    }

    public void updateAtPosition(int position, int newData){
        if(position < 1 || position > size){
            System.out.println("Invalid Position");
            return;
        }
        
        Node temp = head;
        for(int i =1; i<position ;i++){
            temp = temp.next;
        }
        temp.data = newData;
    }

    public void updateValue(int oldValue , int newValue){
        Node temp = head;

        for(int i = 0; i<size; i++){
            if(temp.data == oldValue){
                temp.data = newValue;
                return;    
            }
            temp = temp.next;
        }

    }

    public void deleteHead(){
        if(head == null){
            return;
        }
        head = head.next;
        size--;

        if(size == 0){
            tail = null;
        }
    }
   public void deleteTail() {
    // Case 1: Khali list
    if (head == null) {
        return;
    }

    // Case 2: Sirf 1 element ho
    if (size == 1) {
        head = null;
        tail = null;
        size--;
        return;
    }

    // Case 3: 2 ya usse zyada elements
    Node temp = head;
    for (int i = 1; i < size - 1; i++) { // size - 1 tak!
        temp = temp.next;
    }

    tail = temp;        // Second last dabba ab nayi tail ban gaya
    tail.next = null;   // Aakhiri dabbe ka connection tod diya
    size--;
}

public void deleteAtPosition(int position) {
    // Edge Case: Invalid check
    if (position < 1 || position > size) {
        System.out.println("Invalid position!");
        return;
    }

    // Case 1: Pehla dabba delete karna ho
    if (position == 1) {
        deleteHead();
        return;
    }

    // Case 2: Aakhiri dabba delete karna ho
    if (position == size) {
        deleteTail();
        return;
    }

    // Case 3: Beech ka dabba delete karna ho
    // Step A: position - 1 tak pahocho
    Node prev = head;
    for (int i = 1; i < position - 1; i++) {
        prev = prev.next;
    }

    // Step B: Connection bypass karo
    Node toDelete = prev.next;
    prev.next = toDelete.next;
    toDelete.next = null; // Memory disconnect

    size--;
}

public void deleteValue(int value) {
    // Edge Case 1: Khali list
    if (head == null) {
        System.out.println("List is empty!");
        return;
    }

    // Case 1: Agar pehle hi dabbe par value mil jaye
    if (head.data == value) { 
        deleteHead();
        return;
    }

    // Case 2: Beech me ya end me dhundho
    Node prev = head;
    while (prev.next != null && prev.next.data != value) {
        prev = prev.next;
    }

    // Agar poori list ghoom li aur value nahi mili
    if (prev.next == null) {
        System.out.println("Value " + value + " not found in the list!");
        return;
    }

    // Agar value mil gayi
    Node toDelete = prev.next;

    // Agar aakhiri dabba delete ho raha ho toh tail update karo
    if (toDelete == tail) {
        tail = prev;
    }

    prev.next = toDelete.next;
    toDelete.next = null;
    size--;
}
}

 class Main{
    public static void main(String[] args) {
        singlyLinkedList list = new singlyLinkedList();

        list.insertAtHead(10);
        list.insertAtHead(20);
        list.insertAtHead(30);
        list.insertAtHead(40);
        list.insertAtHead(50);
        list.insertAtTail(40);
        list.insertAtTail(50);  
        list.insertAtPosition(3, 100);

        list.display();
    }
}