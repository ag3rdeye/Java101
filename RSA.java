import java.util.Random;
import java.util.Scanner;
public class RSA{
  private static int p,q;
  private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
    
      int funcN = ((p-1)*(q-1));
 
    while(true){
      if(isPrime(getP()) == true){
        break;
      }
      getP();
    }

    while(true){
      if(isPrime(getQ()) == true){
        break;
      }
      getQ();
    }
    }

   public static boolean isPrime(int num){
    boolean flag = false;
    for(int i=2;i<=num/2;i++){
      if(num%i==0){
        return flag;
      }
    }
    return flag = true;
   } 

   public static int getP(){
    System.out.println("Enter prime number P: ");
     p = in.nextInt();
     return p;
       }

   public static int getQ(){
    System.out.println("Enter prime number Q: ");
      q = in.nextInt();
      return q;
     }


     public int getE(int p, int q){
      int e=0;
      int funcN = ((p-1)*(q-1));
      return e;
     }

    //  public static void rand(){
    //   Random random = new Random(); 
    //   for(int i =1 ;i<=20;i++){
    //   int e = 2 + random.nextInt(200);
    //   System.out.println(e);
    //   }
    //  }
}