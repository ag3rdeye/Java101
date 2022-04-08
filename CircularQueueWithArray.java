import java.util.Scanner;

/**
 @author Arzun Giri
 */
public class CircularQueueWithArray {
    int front,rear,item[],capacity;

   public  CircularQueueWithArray(int size){
        front = -1;
        rear = -1;
        item = new int[size];
        capacity = size;
    }
    public boolean isFull(){
        return front == 0 && rear == capacity - 1 || front == rear + 1;
    }
    
    public boolean isEmpty(){
       return front==-1;
       
    }
    public void enqueue(int data){
        if(isFull()){
            System.out.println("Error: Queue is Full");
        }
        else{
            if(front== -1){
                front = 0;
                }
            rear = (rear+1)%capacity;
            item[rear]=data;
            
        }
    }
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Error: Queue is Empty.");
        }
        else{
            int x = item[front];
            if(front==rear){
                front = -1;
                rear = -1;
            }
            else{
                front = (front+1)%capacity;
            }
            System.out.println("Item dequeue: "+x);
        }
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Error: Queue is Empty.");
        }
        else{
            System.out.print("--> | ");
            for(int i = rear;i>=front;i--){
                System.out.print(item[i] +" | ");
            }
            System.out.print(" --> \n ");
        }
    }
    public static void main(String[] args) {
        CircularQueueWithArray cq= new CircularQueueWithArray(3);
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
                    cq.enqueue(in.nextInt());
                    break;
                case 2:
                    cq.dequeue();
                    break;
                case 3:
                    cq.display();
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
