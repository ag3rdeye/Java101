/**
 @author Arzun Giri
 */
import java.util.Scanner;
public class CircularQueueLinkedList {
    Node front, rear;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public boolean isEmpty(){
        return front == null;
    }
    public void enqueue(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            front = rear = newNode;
        }
        else{
            rear.next = newNode;
            rear = newNode;
            rear.next = front;
        }
    }
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Error: Queue is Empty.");
        }
        else{
                Node temp = front;
                System.out.println("Dequeued item: "+temp.data);
                temp = null;
                front = front.next;
                rear.next = front;
                if(front == rear){
                    front = null;
                    rear = null;
                }
        }
    }
    public void display(){
        Node temp = front;
        do{
            if(temp!=null){
                System.out.print(temp.data +" <- ");
                temp = temp.next;
            }
        }while(temp!=front);
    }
    public static void main(String[] args) {
        CircularQueueLinkedList cql = new CircularQueueLinkedList();
        Scanner in = new Scanner(System.in);
        int choice;
        System.out.println("1: To Enqueue");
        System.out.println("2: To Dequeue");
        System.out.println("3: To Display");
        System.out.println("0: To Exit");
        do{
            choice = in.nextInt();
            switch(choice){
                case 1:
                System.out.println("Enter a number:");
                    cql.enqueue(in.nextInt());
                    break;
                case 2:
                    cql.dequeue();
                    break;
                case 3:
                    cql.display();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Error: Invalid Choice.");
            }
        }while(choice!=0);
        in.close();
    }
}
