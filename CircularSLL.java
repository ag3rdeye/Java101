/**
@author Arzun Giri
*/
import java.util.Scanner;
public class CircularSLL {
    public Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=next;
        }
    }
    public void insertAtBeg(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            newNode.next=head; 
        }
        else if(head.next==head){
            newNode.next=head;
            head.next=newNode;
            head=newNode;
        }
        else{
            newNode.next=head;
            Node temp= head;
            while(temp.next!=head){
                temp=temp.next;
            }
           temp.next=newNode;
           head=newNode;
        }
    }
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head==null)
            {
                head=newNode;
                newNode.next=head;
            }
        else if(head.next==head){
            newNode.next=head;
            head.next=newNode;
        }
        else{
            newNode.next = head;
            Node temp = head;
            while ( temp.next != head){
                temp = temp.next;
            }
            temp.next= newNode;

        }
    }
    public void insertAtPos(int pos, int data){
        Node newNode = new Node(data);
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
        if(pos<1 || pos> size+1){
            System.out.println("Error: Invalid Insertion.");
        }
        else if(pos==1){
            insertAtBeg(data);
        }
        else{
            temp = head;
            for(int i =1 ;i<pos-1;i++){
                temp = temp.next;
            }
           if(temp!=null){
            newNode.next=temp.next;
            temp.next=newNode;
        }
        else{
            System.out.println("previous node is null");
             }
           
        }
    }
    public void  display(){
        Node temp=head;
        do{
            System.out.print(temp.data +" -> ");
            temp=temp.next;
        }while(temp!=head);
        System.out.println(" NULL");
    }
    public void deleteAtBeg(){
        if(head==null){
            System.out.println("Error Deleting: List is Empty.");
        }
        else if(head.next==head){
            head=null;
        }
        else{
            Node temp = head;
            do{
              if(temp!=null){
                temp=temp.next;
              }

            }while(temp.next!=head);
            head = head.next;
            temp.next=head;
        }

    }
    public void deleteAtEnd(){
        if(head==null){
            System.out.println("Error Deleting: List is Empty.");
        }
        else if(head.next==head){
            head=null;
        }
        else{
            Node temp=head;
            while(temp.next.next!=head){
                temp=temp.next;
            }
            temp.next.next = null;
            temp.next=head;
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
        if(pos<1 || pos> size){
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
          temp.next=temp.next.next;
          delNode.next = null;
          delNode = null;

        }
    }
    public static void main (String[] args) {
        CircularSLL list = new CircularSLL();
        list.insertAtBeg(25);
        list.insertAtBeg(32);
        list.insertAtEnd(99);
        list.insertAtEnd(44);
        list.insertAtBeg(12);
        list.insertAtPos(5,33);
        list.display();
        Scanner in = new Scanner(System.in);
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
                    list.display();
                    break;
                case 0:
                    return;
                default:
                System.out.println("Error: Please enter valid choice.");
                
            }
        
        }while(choice!=0);
    }
    
}
