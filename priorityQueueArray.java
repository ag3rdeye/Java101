import java.util.Scanner;
/**
 @author Arzun Giri
 */

/* This is minimum priority queue implementation using array. Enqueue process is same as normal queue but dequeue is different.
The minimum value should be dequeue first and so on.
*/
public class priorityQueueArray {
    private int rear,capacity;
    private int item[];
    priorityQueueArray (int capacity){
        rear = -1;
        this.capacity = capacity;
        item = new int[capacity];
    }
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
            int min = 0;
            for(int i =0; i<rear;i++){
                if(item[i]<item[min])
                 min = i;
            }
            System.out.println("Item Dequeue: "+item[min]);
            for(int i=min;i<rear;i++){
                item[i]=item[i+1];
            }
            rear--;
            
            }
    }
    public void display(){
        if(isEmpty()){
        System.out.println("Error: Queue is Empty.");
        }
        else{
            System.out.print("--> | ");
            for(int i=rear;i>=0;i--){
                System.out.print(item[i]+" | ");
            }
            System.out.print(" --> \n ");
            }
    }
    public static void main(String[] args) {
        priorityQueueArray pq = new priorityQueueArray(4);
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
                    pq.enqueue(in.nextInt());
                    break;
                case 2:
                    pq.dequeue();
                    break;
                case 3:
                    pq.display();
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
