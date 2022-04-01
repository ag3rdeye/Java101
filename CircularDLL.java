/**
@author Arzun Giri
*/
import java.util.Scanner;
public class CircularDLL {
    public Node head;
    class Node{
        int data;
        Node prev;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
            this.prev = null;
        }
    }
    public void insertAtBeg(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            head.next = head;
            head.prev = head;
        }
        else{
            Node tail = head.prev;
            newNode.next = head;
            head.prev = newNode;
            tail.next = newNode;
            newNode.prev = tail;
            head = newNode;
        }
    }
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            head.next = head;
            head.prev = head;
        }
        else{
            Node tail = head.prev;
            tail.next=newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    public void insertAtPos(int pos,int data){
        Node newNode = new Node(data);
        Node temp = head;
        int size = 0;
        if(temp!=null){
            size++;
            temp = temp.next;
            while(temp!=head){
                temp = temp.next;
                size++;
            }
            if(pos<1 || pos>size+1){
                System.out.println("Error: Invalid Insertion");
                
            }
            else if(pos==1){
                insertAtBeg(data);
            }
            else{
                temp = head;
                for(int i=1;i<pos-1;i++){
                    temp=temp.next;
                }
                newNode.next=temp.next;
                temp.next.prev = newNode;
                temp.next=newNode;
                newNode.prev = temp;
            }
        }
    }
    public void deleteAtEnd(){
        if(head==null){
            System.out.println("Error Deleting: List is Empty.");
        }
        else{
            Node tail = head.prev;
            tail.prev.next = head;
            head.prev = tail.prev;
            tail = null;

        }
    }
    public void deleteAtBeg(){
        if(head==null){
            System.out.println("Error: List is Empty.");
        }
        else{
            Node tail = head.prev;
            head.next.prev = tail;
            tail.next = head.next;
            head = head.next;
        }
    }
    public void deleteAtPos(int pos){
        int size = 0;
        Node temp = head;
        if(temp!=null){
            size++;
            temp=temp.next;
            while(temp!=head){
                size++;
                temp=temp.next;
            }
        }
         if(pos<1 || pos>size){
            System.out.println("Error: Invalid Deletion.");
        }
        else if(pos==1){
            deleteAtBeg();
        }
        else{
            temp = head;
            for(int i=1;i<pos-1;i++){
                temp = temp.next;
            }
            Node delNode = temp.next;
            temp.next = temp.next.next;
            temp.next.next.prev = temp;
            delNode.prev=null;
            delNode.next= null;
            delNode=null;
        }
    }
    public void  displayForward(){
        Node temp=head;
        do{
            System.out.print(temp.data +" -> ");
            temp=temp.next;
        }while(temp!=head);
        System.out.println(" NULL");
    }
    public void displayBackward(){
        if(head==null)
        System.out.println("Error: List is Empty.");
    else{
        Node temp=head.prev;
        while(temp!=head){
            System.out.print(temp.data + " -> ");
            temp=temp.prev;
        }
       
        System.out.println(temp.data+" -> NULL");
    }
}
    public static void main(String[] args) {
        CircularDLL list = new CircularDLL();
        list.insertAtBeg(12);
        list.insertAtBeg(23);
        list.insertAtEnd(33);
        list.insertAtBeg(31);
        list.insertAtEnd(49);
        list.insertAtPos(3,11);
        list.insertAtPos(6, 79);
        // System.out.println("Displaying in Forward Direction:");
        list.displayForward();
        // System.out.println("Displaying in Backward Direction: ");
        // list.displayBackward();
        Scanner in = new Scanner(System.in);
        
        //This code is for deleting item in list, to insert call the insert methods inplace of delete.
        
        System.out.println("Enter your choice: ");
        System.out.println("1: Delete element at first.");
        System.out.println("2: Delete element at last.");
        System.out.println("3: Delete element at position.");
        System.out.println("4: Display List.");
        System.out.println("0: To exit.");
        int choice;
        do{
          System.out.println("Enter your choice: ");
          choice = in.nextInt();
            switch(choice){
                case 1: 
                     list.deleteAtBeg();
                break;
                case 2:
                    list.deleteAtEnd();
                     
                    break;
                case 3:
                   list.deleteAtPos(in.nextInt());
                    break;
                case 4:
                    list.displayForward();
                    break;
                case 0:
                    return;
                default:
                System.out.println("Error: Please enter valid choice.");
                
            }
        
        }while(choice!=0);
    }
}
