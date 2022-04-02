/** 
    @author Arzun Giri
    
 */
// Stack implementation using Linked List in java
import java.util.Scanner;
public class StackusingLL {
   private Node top;
   private int size; 
   class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void push(int data){
        Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
            size++;
        }
    public  void pop(){ 
        if(!isEmpty()){
            System.out.println("Item popped: "+top.data);
            top=top.next;
            size--;
        }
        else{
            System.out.println("Error Popping: Stack is Empty.");
        }
    }
    void display(){
       if(!isEmpty()){
        Node temp = top;
        while(temp!=null){
            System.out.println(temp.data);
            System.out.println("----");
            temp=temp.next;
        }
       }
       else{
           System.out.println("Error: Stack is Empty.");
       }
    }
    public boolean isEmpty(){
        return size==0;
    }
    
    public static void main(String[] args) {
        StackusingLL st = new StackusingLL();
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
                    st.push(in.nextInt());
                    break;
                case 2:
                    st.pop();
                    break;
                case 3:
                    st.display();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Error: Invalid Choice.");
            }
        }while(choice!=0);
    }
    
}
