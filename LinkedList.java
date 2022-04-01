/**
@author Arzun Giri
*/
import java.util.Scanner;
public class LinkedList {
    static Node head;
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
    
        }
    }
  
    public  void insertAtBeg(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
        }
        else{
            newNode.next=head;
            head=newNode;
        }
    }
    public   void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
        }
        else{
            Node temp = head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
        
    }
    public  void insertAtPos(int pos,int data){
        Node newNode = new Node(data);
        if(pos<1){
            System.out.println("Position can't be less than 1.");
        }
        else if(pos==1){
         insertAtBeg(data);
        }
        else{
            Node temp=head;
            for(int i=1;i<pos-1;i++){
                if(temp!=null){
                    temp=temp.next;
                }
               
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
    public void deleteAtBeg(){
        if(head==null){
            System.out.println("Error Deleteing: List is empty.");
        }
        else{
           Node temp=head;
            head=head.next;
            temp.next=null;
            temp=null;
        }
    }
    public void deleteAtEnd(){
        if(head==null){
            System.out.println("Error Deleteing: List is empty.");
        }
        else{
            Node temp=head;
            while(temp.next.next!=null){
                temp=temp.next;
            }
            temp.next=null;
        }
    }
    public void deleteAtPos(int pos){
        if(pos<1)
            System.out.println("Error Deleting: Position must be greater than 1.");
        else if(pos==1)
            deleteAtBeg();
        else{
            Node temp=head;
            for(int i=1;i<pos-1;i++){
               if(temp!=null){
                temp=temp.next;
               }
            }
            if(temp!=null && temp.next!=null){
                Node dNode=temp.next;
                temp.next=temp.next.next;
                dNode.next=null;
                dNode=null;
            }
            else{
                System.out.println("Error Deleting: Previous doesnot exists.");
            }
        }
    }
    public void  display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data +" -> ");
            temp=temp.next;
        }
        System.out.println(" NULL");
    }
    public static void main(String[] args) {
        LinkedList list =new LinkedList();
        list.insertAtBeg(12);
        list.insertAtBeg(11);
        list.insertAtBeg(25);
        list.insertAtEnd(30);
        list.insertAtBeg(21);
        list.insertAtBeg(86);
        list.insertAtPos(3, 13);
        // list.insertAtPos(6, 56);
        // list.insertAtEnd(99);
        // list.deleteAtBeg();
        // list.deleteAtEnd();
        // list.deleteAtPos(5);
        // list.display();
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
  
