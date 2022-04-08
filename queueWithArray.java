import java.util.Scanner;

/**
 @author Arzun Giri
 */
public class queueWithArray {
    private int rear,front,capacity;
    private int item[];
    queueWithArray(int size){
        rear = -1;
        front = 0;
        capacity = size;
        item = new int[size];
    }
    //headfixed queue implementation
    public boolean isFull(){
        return rear==capacity-1;
    }
    public boolean isEmpty(){
        return rear==-1;
    }
    public void enqueue(int data){
        if(isFull()){
            System.out.println("Error: Queue is Full.");
        }
        else{
            rear++;
            item[rear]=data;
        }
    }
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Error: Queue is Empty.");
        }
        else{
            try{
                int x= item[front++];
                System.out.println("Dequeued Element: "+x);
            }
         catch(ArrayIndexOutOfBoundsException e){
            System.out.println("All item are dequeued.");
        }  
        }
    }
    public void display(){
        if(isEmpty()){
        System.out.println("Error: Queue is Empty.");
        }
        else{
            System.out.print("--> | ");
            for(int i=rear;i>=front;i--){
                System.out.print(item[i]+" | ");
            }
            System.out.print(" --> \n ");
            }
    }
    public void dequeueFixedQueue(){
        if(isEmpty()){
            System.out.println("Error: Queue is Empty.");
        }
        else{
            int x = item[front];
            for(int i=front;i<rear;i++){
                item[i]=item[i+1];
            }
            rear--;
            System.out.println("Dequeued from fixed queue: "+x);
        }
    }
    public static void main(String[] args) {
         queueWithArray qrr = new queueWithArray(6);
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
                    qrr.enqueue(in.nextInt());
                    break;
                case 2:
                    //qrr.dequeue();
                    qrr.dequeueFixedQueue();
                    break;
                case 3:
                    qrr.display();
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
