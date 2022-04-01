/**
@author Arzun Giri
*/
import java.util.Scanner;

public class DoublyLinkedList{
    static Node head;
    public static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    
    public void insertAtBeg(int data){
        Node newNode = new Node(data);
        if (head==null){
            head=newNode;
        }
        else{
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }
    }

    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
        }
        // else if(head.next==null){
        //     head.next=newNode;
        //     newNode.prev=head;
        // }
        else{
            Node temp = head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
            newNode.prev=temp;
        }
    }
    public void insertAtPos(int pos,int data){
        Node newNode = new Node(data);
        if(pos<1){
            System.out.println("Error: Position must be greater than or equals to 1.");
        }
        else if(pos==1){
            insertAtBeg(data);
        }
        else{
            Node temp = head;
            for(int i=1;i<pos-1;i++){
                if(temp!=null){
                    temp=temp.next;
                }
            }
            
                if(temp!=null){
                    newNode.next= temp.next;
                    temp.next=newNode;
                    newNode.prev=temp; 
                    // temp.next.prev=newNode;
                }
                if(temp.next!=null){
                    temp.next.prev =newNode;
                }
              
                else{
                    System.out.println("Error: Previous node is null.");
                }
               
            
        }
    }

    public void displayForward(){
        if(head==null)
            System.out.println("Error: List is Empty.");
        else{
            Node temp= head;
            while(temp!=null){
                System.out.print(temp.data+" -> ");
                temp=temp.next;
            }
            System.out.println("NULL");
        }
    }
    public void displayBackward(){
        if(head==null)
        System.out.println("Error: List is Empty.");
    else{
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        while(temp!=null){
            System.out.print(temp.data +" -> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }
        
    }
    public void deleteAtBeg(){
        if(head==null){
            System.out.println("Error Deleting: List is Empty.");
        }
        else{
            Node temp=head;
            head=head.next;
            temp.next=null;
            head.prev=null;
        }
    }
    public void deleteAtEnd(){
        if(head==null){
            System.out.println("Error Deleting: List is Empty.");
        }
        else{
            Node temp = head.next;
            while(temp.next.next!=null){
                temp=temp.next;
            }
            temp.next.prev=null;
            temp.next=null;
        }
    }
    public void deleteAtPos(int pos){
        if(pos<1){
            System.out.println("Error: Position must be greater than or equals to 1.");
        }
        else if(pos==1){
            deleteAtBeg();
        }
        else{
            Node temp = head;
            for(int i=1;i<pos-1;i++){
                if(temp!=null){
                    temp = temp.next;
                }}
                if(temp!=null && temp.next!=null)
                {
                    Node delNode=temp.next;
                    temp.next=temp.next.next;
                    if(temp.next.next!=null)
                         temp.next.next.prev=temp;
                    delNode=null;
                     }
                
                else{
                    System.out.println("Previous node does not exists.");
                }
            
        }
    }
   
        public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtBeg(25);
        list.insertAtEnd(44);
        list.insertAtEnd(33);
        list.insertAtBeg(35);
        list.insertAtEnd(43);
        list.insertAtBeg(67);
        list.insertAtPos(3, 55);
        list.insertAtPos(4, 55);
        list.displayForward();
        // System.out.println("Displaying in Forward Direction:");
        // list.displayForward();
        // System.out.println("Displaying in Backward Direction: ");
        // list.displayBackward();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        System.out.println("1: Insert element at first.");
        System.out.println("2: Insert element at last.");
        System.out.println("3: Insert element at position.");
        System.out.println("4: Display List.");
        System.out.println("0: To exit.");
        int choice;
        do{
          System.out.println("Enter your choice: ");
          choice = in.nextInt();
            switch(choice){
                case 1: 
                // list.insertAtBeg(in.nextInt());
                list.deleteAtBeg();
                break;
                case 2:
                // list.insertAtEnd(in.nextInt());
                list.deleteAtEnd();
                // list.displayBackward();
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
