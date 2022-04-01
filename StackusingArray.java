/**
  @author Arzun Giri
  @category Data Structure
 */
import java.util.Scanner;
public class StackusingArray {
    private  int capacity, tos;
    private int item[];
    StackusingArray(int size){
        tos=-1;
        capacity = size;
        item = new int[size];
    }
    
  public boolean isEmpty(){
    if(tos==-1)
        return true;
    else
        return false;
    }
    public boolean  isFull(){
        if(tos==capacity-1)
            return true;
        
        else
            return false;
        
    }
    public void push(int data){
        if(isFull())
            System.out.println("Stack is Full.");
        else{
            tos++;
            item[tos]=data;
        }
    }
    public void  pop(){
        if(isEmpty()){
        System.out.println("Error: Stack is Empty.");
       
        }
        else{
            int del = item[tos];
            tos--;
            System.out.println("Item deleted: "+del);
        }
    }
    public void display(){
        if(isEmpty())
            System.out.println("Stack is Empty.");
        else{
            System.out.println("---");
            for(int i=tos;i>=0;i--){
                System.out.println(item[i]);
                System.out.println("---");
            }
        }
    
    }
  // To avoid using hard coded values, this program takes limit of the stack which 
  // can be provided while running the code, as
  // javac StackusingArray.java
  // java StackusingArray <limit>
    public static void main(String[] args) {
         int limit= Integer.parseInt(args[0]);
        StackusingArray sta = new StackusingArray(limit);
        Scanner in = new Scanner(System.in);
        int choice;
        System.out.println("1: To Push");
        System.out.println("2: To Pop");
        System.out.println("3: To Display");
        System.out.println("0: To Exit");
        do{
            choice = in.nextInt();
            switch(choice){
                case 1:
                System.out.println("Enter a number:");
                    sta.push(in.nextInt());
                    break;
                case 2:
                    sta.pop();
                    break;
                case 3:
                    sta.display();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Error: Invalid Choice.");
            }
        }while(choice!=0);
    }
}
