public class practise{
    static class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }
        private Node head;
        private Node tail;
        private int size;

    public  practise(){
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        void insertAtHead(int data){
            Node newNode = new Node (data);
            if(head == null){
                head = newNode;
                tail = newNode;
            }
            else{
                newNode.next = head;
                head =  newNode;    
            }
            size++;
        }

        void insertAtTail(int data){
            Node newNode = new Node(data);

            if( head == null ){
                head = newNode ;
                tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;

            }
            size++;
        }

        void Display(){

            Node current = head;
            while(current!= null){
                System.out.print(current.data+" -> ");
                current = current.next;
            }
            System.out.println("null");
        }
        void insertAtPosition(int position, int data){
            if(position < 1 || position > size+1){
                System.out.println("Invalid Position");
                return;
            }

            if(position == 1  ){
                insertAtHead(data);
                return;
            }
            if(position == size+1){
               
                insertAtTail(data);
                return;
            }
            Node temp = head;
            for(int i = 1;i< position-1 ;i++){
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
            if(head == null){
                return true;
            }
            else{
                return false;
            }
        }
       
        public int head (){
            if(head == null){
                return -1;
            }else{
                return head.data;
            }
        }
        public int tail(){
            if(tail == null){
                return -1;
            }else{
                return tail.data;
            }
        }
        public void clear(){
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public void search(int data){
            Node temp = head;
            for(int i = 1; i<=size ;i++){
                if(temp.data == data){
                    System.out.println("Element Found");
                    return;
                }
                    
                temp = temp.next;
            }
                    System.out.println("Element Not found");
        }
        
        public void findPosition(int data){
            Node temp = head;
            for(int i=1;i<=size;i++){
                if(temp.data == data){
                    System.out.println("Element found at "+i);
                    return;
                }
                temp = temp.next;

            }
            System.out.println("Element not found");
            
        }

        public void updateAtPosition(int position , int newdata){

            if(position<1 || position >size){
                System.out.println("Invalid Position");
            }

            Node temp = head;
            for(int i =1; i<=position; i++){
                temp = temp.next;
            }
            temp.data = newdata;

        }
        
        public void updateValue(int oldValue, int newValue){
            Node temp = head;
            for(int i=0;i<=size;i++){
                if(temp.data == oldValue){
                    temp.data = newValue;
                    return;
                }
                temp = temp.next;
            }
            System.out.println("value not found");
        }
        
        
        public void deleteHead()
        {
            if(head == null){
                return;
            }
            head = head.next;
            size--;
            if(size==0){
                tail = null;
            }
        }

        public void deleteTail(){
           if(head == null)
           return ;

           if(size == 1){
            head = null;
            tail = null;
            size--;
            return;
           }
           Node temp = head;
           for(int i=1;i<size-1;i++){
            temp = temp.next;
           }

           tail = temp;
           temp.next = null;
           size--;
        }

        public void deleteAtPosition(int position){
            //position glt hue to 
            if( position < 1 || position > size){
                System.out.println("Invalid Position");
            }
            //position 1st hue to 
            if(position == 1 ){
                deleteHead();
                return;
            }
            //position last hue to 
            if(position == size){
                deleteTail();
                return;
            }
            //position kahi bich mein hue to
            // hame phle jo delete krna hai ausse phle jana hoga 
            //fir naya connection bnana hoga 
            // fir auska connection todna hoga 
            // fir size kam krna hoga 

            Node temp = head;
            for(int i=1; i<position-1;i++){
                temp = temp.next;
            }

            Node todelete = temp.next;
            temp.next  = todelete.next;
            todelete.next = null;
            size--;


        }
        
        //deleteAtValue

        public void deleteAtValue(int data){
           
           if(head == null){
            System.out.println("List is empty");
            return;

           }
           if(head.data == data){
            deleteHead();
            return;
           }

           Node prev = head;
           while(prev.next!= null && prev.next.data!=data ){
            prev = prev.next;

           }

           if(prev.next == null){
            System.out.println("data not found");
           }

           Node toDelete = prev.next;

           if(toDelete == tail){
             tail = prev;
           }
           prev.next = toDelete.next;
           toDelete.next = null;
           size--;

        }
}

class Main {
    public static void main (String [] args){

         practise  list = new practise();
         list.insertAtHead(20);
         list.insertAtTail(40);
         list.insertAtPosition(2,30);
         list.insertAtTail(50);
         list.findPosition(50);
         list.updateAtPosition(2,35);
         list.updateValue(35,33);
        
         list.deleteAtValue(33);
         
         list.Display();
    }
}